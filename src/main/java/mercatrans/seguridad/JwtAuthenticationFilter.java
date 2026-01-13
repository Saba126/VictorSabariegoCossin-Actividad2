package mercatrans.seguridad;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mercatrans.model.service.UsuarioService;

@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final JwtSecurityService jwt;
	@Autowired
	private UsuarioService uds;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
										HttpServletResponse response,
										FilterChain chain) throws ServletException, IOException{
		
			String authHeader = request.getHeader("Authorization");
			
			if(authHeader != null && authHeader.startsWith("Bearer ")) {
				String token = authHeader.substring(7);
				
				if(jwt.isTokenValid(token)
						&& SecurityContextHolder.getContext().getAuthentication() == null) {
					
					String username = jwt.extractUsername(token);
					
					UserDetails userDetails = uds.loadUserByUsername(username);
					
					UsernamePasswordAuthenticationToken authentication = 
							new UsernamePasswordAuthenticationToken(
									userDetails,
									null,
									userDetails.getAuthorities()
							);
					authentication.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request)
					);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
	chain.doFilter(request, response);
	}

}
