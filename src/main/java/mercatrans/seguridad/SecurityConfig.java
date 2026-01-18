package mercatrans.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import mercatrans.seguridad.JwtAuthenticationFilter;

/**
 * Configuración de seguridad de la aplicación.
 *
 * Esta clase configura la seguridad web, incluyendo filtros JWT y políticas de autorización.
 *
 * @author victor_sabariego
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwt;

	/**
	 * Configura la cadena de filtros de seguridad.
	 *
	 * @param http El objeto HttpSecurity para configurar.
	 * @return La cadena de filtros de seguridad configurada.
	 * @throws Exception Si ocurre un error durante la configuración.
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

		http
		.csrf(csrf -> csrf.disable())
		.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests( auth -> auth
			//TODO Arreglar rutas
			// Rutas publicas minimas (ajusta a tu gusto) BORRAR ("/**")
			.requestMatchers("/**", "/register", "/error", "/public/**").permitAll()
			// tu API (ajusta prefijos/rutas
			.requestMatchers("/empresa/**").hasRole("EMPRESA")
			.requestMatchers("/conductor/**").hasRole("CONDUCTOR")
			.anyRequest().authenticated()
		)
		.addFilterBefore(jwt, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}

	/**
	 * Crea el administrador de autenticación.
	 *
	 * @param config La configuración de autenticación.
	 * @return El administrador de autenticación.
	 * @throws Exception Si ocurre un error al obtener el administrador.
	 */
    @Bean
    AuthenticationManager authenticationManager(
        AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
