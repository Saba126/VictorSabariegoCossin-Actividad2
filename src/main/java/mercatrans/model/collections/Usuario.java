package mercatrans.model.collections;

import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.jspecify.annotations.Nullable;
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
import mercatrans.model.collections.dto.UsuarioLoginDto;
import mercatrans.model.collections.dto.UsuarioRegisterDto;

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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.rol.name()));
	}
	@Override
	public String getPassword() {
		return this.contrasena;
	}
	@Override
	public String getUsername() {
		return this.nombre;
	}
	
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
