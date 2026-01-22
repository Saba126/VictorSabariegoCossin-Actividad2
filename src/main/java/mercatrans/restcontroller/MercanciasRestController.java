package mercatrans.restcontroller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.seguridad.JwtSecurityService;
import mercatrans.model.collections.dto.UsuarioRegisterDto;
import mercatrans.model.service.CamionService;
import mercatrans.model.service.MercanciaService;
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Mercancia;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.Mercancia.Estado;
import mercatrans.model.collections.dto.UsuarioLoginDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/mercancias")
public class MercanciasRestController {

	@Autowired
	private MercanciaService mercanciaServ;

	@GetMapping("/disponibles-para-transporte")
	public ResponseEntity<?> mercanciasDisponiblesParaTransporte(){
		
		return ResponseEntity.status(200).body(mercanciaServ.obatainPendientes());			
	}
	
	@GetMapping("/por-origen-destino-peso/{atrbMercancia}")
	public ResponseEntity<?> FindByOrigenDestinoPeso(@PathVariable String atrbMercancia){
		boolean isIntvalid = mercanciaServ.isValidInteger(atrbMercancia);
		
		if (isIntvalid) {
			int number = Integer.parseInt(atrbMercancia);
			List<Mercancia> resultBody = mercanciaServ.
					findByOrigenOrDestinoOrPeso(atrbMercancia, atrbMercancia, number);
			
			ResponseEntity<?> result = ResponseEntity.status(200).body(resultBody);
			
			return result;
		}else {
			List<Mercancia> resultBody = mercanciaServ.
					findByOrigenOrDestinoOrPeso(atrbMercancia, atrbMercancia, 0);
			return ResponseEntity.status(200).body(resultBody);			
		}
		
				
		//return ResponseEntity.status(200).body(mercanciaServ.findByEstado(estadoPendiente));		
	
	}
	
}
