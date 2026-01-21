package mercatrans.model.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.InscripcionTransporte;
import mercatrans.model.service.InscripcionTranspoerteService;

public interface InscripcionTransporteRepository extends MongoRepository<InscripcionTransporte, ObjectId>{
	List<InscripcionTranspoerteService> findByMercanciaId(ObjectId mercanciaId);

}
