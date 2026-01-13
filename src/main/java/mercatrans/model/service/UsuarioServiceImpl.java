package mercatrans.model.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mercatrans.model.repository.UsuarioRepository;
import mercatrans.model.collections.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usrRepo;

	@Override
	public Usuario buscarUsuario(String username) {
		// TODO Auto-generated method stub
		return usrRepo.findByUsername(username);
	}

	@Override
	public Usuario buscarPorUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return usrRepo.findByNombreAndContrasena(username, password);
	}

	@Override
	public Usuario altaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usrRepo.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usrRepo.findByUsername(username);
	}
	

}
