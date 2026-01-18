package mercatrans.model.service;

import java.util.Optional;
import mercatrans.seguridad.JwtAuthenticationFilter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mercatrans.model.repository.UsuarioRepository;
import mercatrans.model.collections.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{


   // private final JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private UsuarioRepository usrRepo;

    private final PasswordEncoder passwordEncoder;

	@Override
	public Usuario buscarPorUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return usrRepo.findByNombreAndContrasena(username, password);
	}

	@Override
	public Usuario altaUsuario(Usuario usuario) {
		if(!existsByEmail(usuario.getEmail())) {
			usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
			return usrRepo.save(usuario);			
		}else {
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usrRepo.findByEmail(username).orElseThrow(() -> 
				new UsernameNotFoundException("Usuario no existe"));
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usrRepo.findByEmail(email).orElse(null);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usrRepo.existsByEmail(email);
	}

	// TODO updateUsuario
	
	/*
	@Override
	public void updateUsuario(Usuario usuario) {
		
		if(usrRepo.existsByEmail(usuario.getEmail())) {
			usrRepo.save(usuario);
			System.out.println("usuario actualizado correctamente: " + usrRepo.findByEmail(usuario.getEmail()));
		}else {
			throw new UsernameNotFoundException("User not found"); 
		}
		
	}*/	

}
