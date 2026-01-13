package mercatrans.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.seguridad.JwtSecurityService;
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.dto.UsuarioLoginDto;

@CrossOrigin(origins="*")
@RestController
public class HomeRestController {
	
	@Autowired
	private UsuarioService uServ;
	
	@Autowired
	private JwtSecurityService jwtSecurityService;
	
	@GetMapping("/")
	public ResponseEntity<?> home(){
		return ResponseEntity.ok("Bienvenido al Home Page");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioLoginDto usuDto){
		
		Usuario u = uServ.buscarPorUsernamePassword(usuDto.getUsername(), "{noop}" + usuDto.getContrasena());
		if(u != null) {
			u.setContrasena(null);
			String token = jwtSecurityService.generateToken(usuDto.getUsername(), u.getAuthorities());
			System.out.println(token);
			return ResponseEntity.ok(u);
		}else
			return ResponseEntity.status(400).body("Usuario o contraseña incorrectos");
			
	}
}
