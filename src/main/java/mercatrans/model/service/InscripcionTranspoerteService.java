package mercatrans.model.service;

import java.util.List;

import org.bson.types.ObjectId;

public interface InscripcionTranspoerteService {

	List<InscripcionTranspoerteService> findByMercanciaId(ObjectId mercanciaId);
}
