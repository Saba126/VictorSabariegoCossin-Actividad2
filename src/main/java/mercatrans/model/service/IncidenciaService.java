package mercatrans.model.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import mercatrans.model.collections.Camion;
import mercatrans.model.collections.Incidencia;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Camion.Estado;

public interface IncidenciaService {
	List<Incidencia> findByConductor(ObjectId conductorId);
}
