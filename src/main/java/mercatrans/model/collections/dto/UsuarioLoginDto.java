package mercatrans.model.collections.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mercatrans.model.collections.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioLoginDto {
	private String email;
	private String contrasena;
}
