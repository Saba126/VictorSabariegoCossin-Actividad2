package mercatrans.model.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mercatrans.model.repository.UsuarioRepository;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Usuario.Rol;

/**
 * Implementación del servicio de usuarios.
 *
 * Esta clase proporciona la implementación concreta de la interfaz UsuarioService,
 * manejando operaciones como búsqueda, alta y verificación de usuarios.
 *
 * @author victor_sabariego
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usrRepo;

    private final PasswordEncoder passwordEncoder;

	/**
	 * {@inheritDoc}
	 *
	 * Busca un usuario por nombre de usuario y contraseña.
	 *
	 * @param username El nombre de usuario.
	 * @param password La contraseña del usuario.
	 * @return El objeto Usuario si se encuentra, o null en caso contrario.
	 */
	@Override
	public Usuario buscarPorUsernamePassword(String username, String password) {
		return usrRepo.findByNombreAndContrasena(username, password);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Da de alta a un nuevo usuario en el sistema, codificando la contraseña.
	 *
	 * @param usuario El objeto Usuario a registrar.
	 * @return El objeto Usuario registrado si el email no existe, o null si ya existe.
	 */
	@Override
	public Usuario altaUsuario(Usuario usuario) {
		if(!existsByEmail(usuario.getEmail())) {
			usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
			return usrRepo.save(usuario);
		}else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * Carga los detalles del usuario por nombre de usuario (email).
	 *
	 * @param username El nombre de usuario (email).
	 * @return Los detalles del usuario.
	 * @throws UsernameNotFoundException Si el usuario no existe.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usrRepo.findByEmail(username).orElseThrow(() ->
				new UsernameNotFoundException("Usuario no existe"));
	}

	/**
	 * {@inheritDoc}
	 *
	 * Busca un usuario por su correo electrónico.
	 *
	 * @param email El correo electrónico del usuario.
	 * @return El objeto Usuario si se encuentra, o null en caso contrario.
	 */
	@Override
	public Usuario buscarPorEmail(String email) {
		return usrRepo.findByEmail(email).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Verifica si existe un usuario con el correo electrónico dado.
	 *
	 * @param email El correo electrónico a verificar.
	 * @return true si existe, false en caso contrario.
	 */
	@Override
	public boolean existsByEmail(String email) {
		return usrRepo.existsByEmail(email);
	}

	@Override
	public Optional<Usuario> conductorPorId(ObjectId id) {
		
		return usrRepo.findById(id);
		/*
		Optional<Usuario> user = usrRepo.findById(id);
		if(user.get().getRol() == Rol.CONDUCTOR)
			return usrRepo.findById(id);
		else {
			System.out.println("Not A Conductor");
			return null;
		}*/
	}

	@Override
	public Usuario buscarPorIdCamioneros(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
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
