package mercatrans.model.collections.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Usuario.Rol;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioRegisterDto {
	private String email;
	private String contrasena;
	private Rol rol;
	
	// Genera un atributo nombre en base a un string recibido (útil para generar el objeto usuario utilizando UsuarioRegisterDto)
	public String getNombre() {
		String name = this.email.split("@")[0];
		return name;
	}
	
	public static UsuarioRegisterDto convertToUsuarioDto(Usuario user) {
		UsuarioRegisterDto userDto = UsuarioRegisterDto.builder()
				.contrasena(user.getContrasena())
				.email(user.getEmail())
				.rol(user.getRol())
				.build();
		return userDto;
	}
}
