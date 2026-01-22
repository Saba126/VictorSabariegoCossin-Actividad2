package mercatrans.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import mercatrans.model.collections.Camion;
import mercatrans.model.collections.Incidencia;
import mercatrans.model.collections.Incidencia.Estado;

public interface IncidenciaRepository extends MongoRepository<Incidencia, ObjectId>{
	List<Incidencia> findByEstadoAndFechaGreaterThan(Estado estado, LocalDate fecha);
	List<Incidencia> findByCamionId(Camion camionId);
}
