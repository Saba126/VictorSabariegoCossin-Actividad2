package mercatrans.model.service;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import mercatrans.model.collections.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	Usuario buscarPorEmail(String email);
	Usuario buscarPorUsernamePassword(String e, String password);
	Usuario altaUsuario(Usuario usuario);
    boolean existsByEmail(String email);
}
