package mercatrans.model.collections.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para el login de usuarios.
 *
 * Esta clase representa un objeto de transferencia de datos (DTO) que contiene la información necesaria para el login de un usuario.
 * Incluye el correo electrónico y la contraseña del usuario.
 *
 * @author [victor_sabariego]
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioLoginDto {
	private String email;
	private String contrasena;
}
