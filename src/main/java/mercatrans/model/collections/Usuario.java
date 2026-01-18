package mercatrans.model.collections;

import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mercatrans.model.collections.dto.UsuarioRegisterDto;

/**
	 * Clase que representa un usuario en el sistema.
	 *
	 * Esta clase implementa la interfaz UserDetails y contiene la información del usuario,
	 * incluyendo su nombre, correo electrónico, contraseña y rol.
	 *
	 * @param id El identificador único del usuario.
	 * @param nombre El nombre del usuario.
	 * @param email El correo electrónico del usuario.
	 * @param contrasena La contraseña del usuario.
	 * @param rol El rol del usuario (EMPRESA o CONDUCTOR).
	 * @author victor_sabariego
	 */
	
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
@Document(collection="usuarios")
public class Usuario implements UserDetails{
	
	public enum Rol {
	    EMPRESA,
	    CONDUCTOR
	}

	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	
	private String nombre;
	private String email;
	private String contrasena;
	private Rol rol;
	
	/**
	 * Obtiene las autoridades del usuario.
	 *
	 * Este método devuelve una colección de las autoridades del usuario basadas en su rol.
	 *
	 * @return Una colección de GrantedAuthority que representa el rol del usuario.
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.rol.name()));
	}
	/**
	 * Obtiene la contraseña del usuario.
	 *
	 * Este método devuelve la contraseña del usuario.
	 *
	 * @return La contraseña del usuario.
	 */
	@Override
	public String getPassword() {
		return this.contrasena;
	}
	/**
	 * Obtiene el nombre de usuario.
	 *
	 * Este método devuelve el nombre del usuario que se utiliza para la autenticación.
	 *
	 * @return El nombre del usuario.
	 */
	@Override
	public String getUsername() {
		return this.nombre;
	}
	
	/**
	 * Convierte un UsuarioRegisterDto en un objeto Usuario.
	 *
	 * Este método toma un objeto UsuarioRegisterDto y crea un nuevo objeto Usuario
	 * utilizando los datos del DTO.
	 *
	 * @param dto El objeto UsuarioRegisterDto que se va a convertir.
	 * @return Un nuevo objeto Usuario con los datos del DTO.
	 */
    public static Usuario convertRegisterDtoToUser(UsuarioRegisterDto dto) {
    	Usuario user = Usuario.builder()
    			.nombre(dto.getNombre())
    			.email(dto.getEmail())
    			.contrasena(dto.getContrasena())
    			.rol(dto.getRol())
    			.build();
        return user;
    }
}
