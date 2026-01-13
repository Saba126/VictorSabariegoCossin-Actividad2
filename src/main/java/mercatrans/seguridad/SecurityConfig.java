package mercatrans.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
			// Rutas publicas minimas (ajusta a tu gusto)
			.requestMatchers("/", "/login", "/error", "/public/**").permitAll()
			// tu API (ajusta prefijos/rutas
			.requestMatchers("/empresa/**").hasRole("EMPRESA")
			.requestMatchers("/conductor/**").hasRole("CONDUCTOR")
			.requestMatchers("/api/usuarios/**").authenticated()
			.anyRequest().authenticated()
		)
		.addFilterBefore(jwt, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		
	}
	
}
