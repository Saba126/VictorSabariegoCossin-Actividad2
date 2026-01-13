package mercatrans.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InscripcionTransporteRepository extends MongoRepository<InscripcionTransporteRepository, ObjectId>{
	
}
