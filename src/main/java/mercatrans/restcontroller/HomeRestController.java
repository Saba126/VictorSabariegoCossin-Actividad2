package mercatrans.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mercatrans.seguridad.JwtSecurityService;
import mercatrans.model.collections.dto.UsuarioRegisterDto;
import mercatrans.model.service.UsuarioService;
import mercatrans.model.collections.Usuario;
import mercatrans.model.collections.dto.UsuarioLoginDto;

/**
 * Controlador REST para las operaciones principales de la aplicación.
 *
 * Esta clase maneja las rutas para el home, login y registro de usuarios.
 *
 * @author victor_sabariego
 */
@CrossOrigin(origins="*")
@RestController
public class HomeRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioService uServ;

	@Autowired
	private JwtSecurityService jwtSecurityService;

	/**
	 * Maneja la solicitud GET a la ruta raíz.
	 *
	 * @return Una respuesta con un mensaje de bienvenida.
	 */
	@GetMapping("/")
	public ResponseEntity<?> home(){
		return ResponseEntity.ok("Bienvenido al Home Page");
	}

	/**
	 * Maneja la solicitud POST para el login de usuarios.
	 *
	 * Autentica al usuario y genera un token JWT si es exitoso.
	 *
	 * @param usuDto El objeto UsuarioLoginDto con las credenciales del usuario.
	 * @return Una respuesta con el token JWT si el login es exitoso, o un error si falla.
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioLoginDto usuDto){

		Authentication u = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						usuDto.getEmail(),
						usuDto.getContrasena()
				)
		);

		if(u != null) {
			String token = jwtSecurityService.generateToken(usuDto.getEmail(), u.getAuthorities());
			System.out.println(token);
	        return ResponseEntity.ok(Map.of("token", token));
		}else
			return ResponseEntity.status(400).body("Usuario o contraseña incorrectos");

	}

	/**
	 * Maneja la solicitud POST para el registro de nuevos usuarios.
	 *
	 * Convierte el DTO en un usuario y lo registra en el sistema.
	 *
	 * @param usuarioRegisterDto El objeto UsuarioRegisterDto con los datos del nuevo usuario.
	 * @return Una respuesta confirmando el registro exitoso.
	 */
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UsuarioRegisterDto usuarioRegisterDto){
			Usuario newUser = Usuario.convertRegisterDtoToUser(usuarioRegisterDto);
			uServ.altaUsuario(newUser);
			return ResponseEntity.status(200).body("Registro completado " + uServ.buscarPorEmail(newUser.getEmail()));
	}


	//TODO: mover este metodo a otra clase que sea para editar usuarios
	/*
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
		uServ.updateUsuario(usuario);
		return ResponseEntity.status(200).body("user Updated: " + uServ.buscarPorUsuario(usuario.getUsername()));
	}*/
}
