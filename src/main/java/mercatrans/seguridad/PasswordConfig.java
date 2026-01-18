package mercatrans.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración de codificación de contraseñas.
 *
 * Esta clase configura el codificador de contraseñas para la aplicación.
 *
 * @author victor_sabariego
 */
@Configuration
public class PasswordConfig {

    /**
     * Crea un bean de codificador de contraseñas.
     *
     * @return Una instancia de BCryptPasswordEncoder para codificar contraseñas.
     */
    @Bean
    PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


}
