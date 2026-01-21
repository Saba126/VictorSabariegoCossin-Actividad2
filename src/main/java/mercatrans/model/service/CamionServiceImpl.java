package mercatrans.model.service;

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
import mercatrans.model.repository.UsuarioRepository;
import mercatrans.model.collections.Camion;
import mercatrans.model.collections.Camion.Estado;
import mercatrans.model.collections.Usuario;

@Service
@RequiredArgsConstructor
public class CamionServiceImpl implements CamionService{

	@Autowired
	private CamionRepository camionRepo;
	
	@Autowired
	private UsuarioService usuarioServ;

	@Override
	public Optional<Camion> findById(ObjectId Id) {
		return camionRepo.findById(Id);
	}
	
	@Override
	public List<Camion> findByConductorIdAndEstado(ObjectId camioneroId, Estado estado) {
		
		System.out.println(camionRepo.findByConductorIdAndEstado(camioneroId, estado));
		return camionRepo.findByConductorIdAndEstado(camioneroId, estado);
		/*
		if(usuarioServ.conductorPorId(camioneroId) != null) 
			return camionRepo.findByConductorIdAndEstado(camioneroId, estado);
		else
			System.out.println("Id no pertenece a un conductor");
			return null;
		*/
	}

	@Override
	public List<Camion> findAll() {
		List<Camion> todosCamiones = camionRepo.findAll(); 
		if(todosCamiones != null) {
			return todosCamiones;			
		}else 
			return null;
	}

}
