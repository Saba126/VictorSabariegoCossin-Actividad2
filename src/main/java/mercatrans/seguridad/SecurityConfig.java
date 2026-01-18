package mercatrans.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import mercatrans.seguridad.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwt;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		.csrf(csrf -> csrf.disable())
		.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests( auth -> auth
			//TODO Arreglar r
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
	
    @Bean
    AuthenticationManager authenticationManager(
        AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
