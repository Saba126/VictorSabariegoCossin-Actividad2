//TODO Replace all with correct Rest controller construction 

/*package mercatrans.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.seguridad.JwtSecurityService;
import mercatrans.model.collections.dto.UsuarioRegisterDto;
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.dto.UsuarioLoginDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Usuario")
public class UsuarioRestController {
	
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
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UsuarioRegisterDto usuarioRegisterDto){
			Usuario newUser = Usuario.convertRegisterDtoToUser(usuarioRegisterDto);
			uServ.altaUsuario(newUser);
			return ResponseEntity.status(200).body("Registro completado " + uServ.buscarPorUsuario(newUser.getUsername()));
	}
	
	
	//TODO: mover este metodo a otra clase que sea para editar usuarios
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
		uServ.updateUsuario(usuario);
		return ResponseEntity.status(200).body("user Updated: " + uServ.buscarPorUsuario(usuario.getUsername()));
	}
}
*/