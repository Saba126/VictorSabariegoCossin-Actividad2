package mercatrans.model.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import mercatrans.model.collections.Usuario;

/**
 * Servicio para operaciones relacionadas con usuarios.
 *
 * Esta interfaz define los métodos para gestionar usuarios en el sistema,
 * incluyendo búsqueda, alta y verificación de existencia.
 *
 * @author victor_sabariego
 */
public interface UsuarioService extends UserDetailsService{

	/**
	 * Busca un usuario por su correo electrónico.
	 *
	 * @param email El correo electrónico del usuario a buscar.
	 * @return El objeto Usuario correspondiente al correo electrónico, o null si no se encuentra.
	 */
	Usuario buscarPorEmail(String email);

	/**
	 * Busca un usuario por nombre de usuario y contraseña.
	 *
	 * @param username El nombre de usuario o correo electrónico.
	 * @param password La contraseña del usuario.
	 * @return El objeto Usuario si las credenciales son correctas, o null en caso contrario.
	 */
	Usuario buscarPorUsernamePassword(String username, String password);

	/**
	 * Da de alta a un nuevo usuario en el sistema.
	 *
	 * @param usuario El objeto Usuario a registrar.
	 * @return El objeto Usuario registrado.
	 */
	Usuario altaUsuario(Usuario usuario);

	/**
	 * Verifica si existe un usuario con el correo electrónico dado.
	 *
	 * @param email El correo electrónico a verificar.
	 * @return true si existe un usuario con ese correo, false en caso contrario.
	 */
    boolean existsByEmail(String email);
    
    Optional<Usuario> conductorPorId(ObjectId id);
  
}
