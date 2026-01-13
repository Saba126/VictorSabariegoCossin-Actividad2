package mercatrans.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Mercancia;

public interface MercanciaRepository extends MongoRepository<Mercancia, ObjectId>{
	
}
