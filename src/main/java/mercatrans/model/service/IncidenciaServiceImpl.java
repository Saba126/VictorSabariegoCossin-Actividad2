package mercatrans.model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mercatrans.model.repository.CamionRepository;
import mercatrans.model.repository.IncidenciaRepository;
import mercatrans.model.repository.UsuarioRepository;
import mercatrans.model.collections.Incidencia.Estado;
import mercatrans.model.collections.Incidencia;
import mercatrans.model.collections.Usuario;

@Service
@RequiredArgsConstructor
public class IncidenciaServiceImpl implements IncidenciaService{

	@Autowired
	private IncidenciaRepository IncidenciaRepo;
	/*
	@Autowired
	private UsuarioRepository usuRepo;
*/	
	@Autowired
	private CamionRepository camionRepo;

	@Override
	public List<Incidencia> findByConductor(ObjectId conductorId) {
		
		Estado estado = Estado.ABIERTA;
		LocalDate lastMonth = LocalDate.now().minusMonths(1L);
				
		
		List<Incidencia> listIincidenciaActivaUltimoMes = IncidenciaRepo.findByEstadoAndFechaGreaterThan(estado,lastMonth);
		
		for (Incidencia incidencia : listIincidenciaActivaUltimoMes) {
			usuRepo.findById(conductorId);
		}
		
		
		List<Incidencia> result = null;
		
		return result;
	}
	
	
}
