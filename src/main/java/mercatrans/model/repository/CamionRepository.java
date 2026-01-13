package mercatrans.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Camion;

public interface CamionRepository extends MongoRepository<Camion, ObjectId>{
	
}
