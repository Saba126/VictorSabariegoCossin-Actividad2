package mercatrans.restcontroller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.model.service.InscripcionTranspoerteService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/inscripcion-transporte")
public class InscripcionTransporteRestController {

	@Autowired
	private InscripcionTranspoerteService inscripcionServ;
	
	
	
	// !!!!Este metodo se debe probar en Postman ya que swagger no lo entiende
		
	@GetMapping("/{mercanciaId}")
	public ResponseEntity<?> findByMercanciaId(@PathVariable ObjectId mercanciaId){
		
		return ResponseEntity.status(200).body(inscripcionServ.findByMercanciaId(mercanciaId));			
	}
}
