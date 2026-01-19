package mercatrans.restcontroller;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.seguridad.JwtSecurityService;
import mercatrans.model.collections.dto.UsuarioRegisterDto;
import mercatrans.model.service.CamionService;
import mercatrans.model.service.MercanciaService;
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Mercancia.Estado;
import mercatrans.model.collections.dto.UsuarioLoginDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/mercancias")
public class MercanciasRestController {

	@Autowired
	private MercanciaService mercanciaServ;

	@GetMapping("/disponibles-para-transporte")
	public ResponseEntity<?> mercanciasDisponiblesParaTransporte(){
		
		Estado estadoPendiente = Estado.PENDIENTE;
		
		return ResponseEntity.status(200).body(mercanciaServ.findByEstado(estadoPendiente));			
	}
}
