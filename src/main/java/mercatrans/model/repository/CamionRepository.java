package mercatrans.model.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Camion;
import mercatrans.model.collections.Camion.Estado;

public interface CamionRepository extends MongoRepository<Camion, ObjectId>{
	List<Camion> findByConductorIdAndEstado(ObjectId camioneroId, Estado estado);
	
}
