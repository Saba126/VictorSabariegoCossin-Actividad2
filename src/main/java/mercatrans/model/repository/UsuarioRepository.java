package mercatrans.model.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Usuario;

/**
 * Repositorio para la entidad Usuario.
 *
 * Esta interfaz proporciona métodos para acceder y manipular datos de usuarios en la base de datos MongoDB.
 *
 * @author victor_sabariego
 */
public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId>{

	/**
	 * Busca un usuario por su nombre.
	 *
	 * @param username El nombre del usuario.
	 * @return Un Optional que contiene el usuario si se encuentra, o vacío en caso contrario.
	 */
	Optional<Usuario> findByNombre(String username);

	/**
	 * Busca un usuario por su correo electrónico.
	 *
	 * @param email El correo electrónico del usuario.
	 * @return Un Optional que contiene el usuario si se encuentra, o vacío en caso contrario.
	 */
	Optional<Usuario> findByEmail(String email);

	/**
	 * Verifica si existe un usuario con el correo electrónico dado.
	 *
	 * @param email El correo electrónico a verificar.
	 * @return true si existe un usuario con ese correo, false en caso contrario.
	 */
    boolean existsByEmail(String email);

	/**
	 * Busca un usuario por nombre y contraseña.
	 *
	 * @param username El nombre del usuario.
	 * @param password La contraseña del usuario.
	 * @return El usuario si se encuentra, o null en caso contrario.
	 */
	Usuario findByNombreAndContrasena(String username, String password);

}
