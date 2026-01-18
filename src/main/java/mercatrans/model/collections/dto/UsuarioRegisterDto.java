package mercatrans.model.collections.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Usuario.Rol;

/**
 * DTO para el registro de usuarios.
 *
 * Esta clase representa un objeto de transferencia de datos (DTO) que contiene la información necesaria para el registro de un nuevo usuario.
 * Incluye el correo electrónico, la contraseña y el rol del usuario.
 *
 * @author [victor_sabariego]
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioRegisterDto {
	private String email;
	private String contrasena;
	private Rol rol;
	
	/**
	 * Genera un atributo nombre en base a un string recibido.
	 *
	 * Este método utiliza el correo electrónico para generar un nombre, extrayendo la parte antes del símbolo '@'.
	 *
	 * @return El nombre generado a partir del correo electrónico.
	 */
	public String getNombre() {
		String name = this.email.split("@")[0];
		return name;
	}
	
	/**
	 * Convierte un objeto Usuario en un UsuarioRegisterDto.
	 *
	 * Este método toma un objeto Usuario y crea un nuevo UsuarioRegisterDto utilizando los atributos del usuario.
	 *
	 * @param user El objeto Usuario que se va a convertir.
	 * @return Un nuevo objeto UsuarioRegisterDto con los datos del usuario.
	 */
	public static UsuarioRegisterDto convertToUsuarioDto(Usuario user) {
		UsuarioRegisterDto userDto = UsuarioRegisterDto.builder()
				.contrasena(user.getContrasena())
				.email(user.getEmail())
				.rol(user.getRol())
				.build();
		return userDto;
	}
}
