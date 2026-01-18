package mercatrans.model.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId>{

	Optional<Usuario> findByNombre(String username);
	Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
	Usuario findByNombreAndContrasena(String username, String password);
	
}
