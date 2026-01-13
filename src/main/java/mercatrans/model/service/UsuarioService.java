package mercatrans.model.service;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import mercatrans.model.collections.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	Usuario buscarUsuario(String username);
	Usuario buscarPorUsernamePassword(String username, String password);
	Usuario altaUsuario(Usuario usuario);
}
