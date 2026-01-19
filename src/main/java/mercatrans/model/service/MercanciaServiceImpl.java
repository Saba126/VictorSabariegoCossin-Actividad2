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
import mercatrans.model.repository.MercanciaRepository;
import mercatrans.model.collections.Mercancia;
import mercatrans.model.collections.Mercancia.Estado;
import mercatrans.model.collections.Usuario;

@Service
@RequiredArgsConstructor
public class MercanciaServiceImpl implements MercanciaService{

	@Autowired
	private MercanciaRepository mercanciaRepo;

	@Override
	public 	List<Mercancia> findByEstado(Estado estado)	{
		return mercanciaRepo.findByEstado(estado);
	}
}
