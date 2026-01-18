package mercatrans.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    // Activar encriptación de password 
    @Bean
    PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
}
