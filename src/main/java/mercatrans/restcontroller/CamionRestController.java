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
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Camion.Estado;
import mercatrans.model.collections.dto.UsuarioLoginDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/camiones")
public class CamionRestController {

	@Autowired
	private CamionService camionServ;

	@GetMapping("/todos")
	public ResponseEntity<?> allCamiones(){
		return ResponseEntity.status(200).body(camionServ.findAll());			
	}

	@GetMapping("/{conductorId}-{estado}")
	public ResponseEntity<?> camionesPorConductorYEstado(
			@PathVariable("conductorId") ObjectId camioneroId,
			@PathVariable("estado") Estado estado
	) {
		//estado = estado.ACTIVO
		return ResponseEntity.status(302).body(camionServ.findByConductorIdAndEstado(camioneroId, estado));	
	}
}
