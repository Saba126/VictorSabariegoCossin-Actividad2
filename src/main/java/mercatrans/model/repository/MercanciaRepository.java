package mercatrans.model.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Mercancia;
import mercatrans.model.collections.Mercancia.Estado;

public interface MercanciaRepository extends MongoRepository<Mercancia, ObjectId>{
	List<Mercancia> findByEstado(Estado estado);
	List<Mercancia> findByOrigenOrDestinoOrPesoKg(String origen, String destino, int peso);
}
