package mercatrans.model.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import mercatrans.model.collections.Camion;
import mercatrans.model.collections.Camion.Estado;

public interface CamionService {
	Optional<Camion> findById(ObjectId Id);
	List<Camion> findAll();
	List<Camion> findByConductorIdAndEstado(ObjectId camioneroId, Estado estado);
}
