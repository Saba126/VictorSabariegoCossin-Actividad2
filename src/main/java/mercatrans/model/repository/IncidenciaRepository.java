package mercatrans.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Incidencia;

public interface IncidenciaRepository extends MongoRepository<Incidencia, ObjectId>{
	
}
