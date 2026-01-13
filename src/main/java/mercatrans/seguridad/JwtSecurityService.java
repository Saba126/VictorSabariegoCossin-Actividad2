package mercatrans.seguridad;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;



@Service
public class JwtSecurityService {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}") 
	private Long expirationMs; 
	
	private Key signingKey() {
		// Si el secret esta en Base64:
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String generateToken(String username, Collection<? extends GrantedAuthority> auths) {
		Map<String, Object> claims = Map.of("roles", auths.stream().map(GrantedAuthority::getAuthority).toList());
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject (username) 
				.setIssuedAt(new Date()) 
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(signingKey(), SignatureAlgorithm.HS256) 
				.compact();
	}
	
	public String extractUsername (String token) {
		return Jwts.parserBuilder() 
				.setSigningKey(signingKey()) 
				.build() 
				.parseClaimsJws (token)
				.getBody() 
				.getSubject();
	}
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parserBuilder() 
			.setSigningKey(signingKey())
			.build()
			.parseClaimsJws (token);
		return true;		
		} catch (io.jsonwebtoken.security.SignatureException e) { 
			System.out.println("Firma JWT invélida"); 
			return false;
		} catch (io.jsonwebtoken.ExpiredJwtException e) { 
			System.out.println("Token JWT expirado");
			return false;
		} catch (Exception e) {
			System.out.println("Token JWT invalido");
			return false;
		}
	}
}
