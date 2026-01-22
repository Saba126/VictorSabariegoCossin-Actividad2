package mercatrans.model.service;

import java.util.List;

import org.bson.types.ObjectId;

import mercatrans.model.collections.InscripcionTransporte;

public interface InscripcionTranspoerteService {
	List<InscripcionTransporte> findByMercanciaId(ObjectId mercanciaId);
}
