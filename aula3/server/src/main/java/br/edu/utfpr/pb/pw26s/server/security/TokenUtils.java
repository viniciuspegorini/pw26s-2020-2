package br.edu.utfpr.pb.pw26s.server.security;

import br.edu.utfpr.pb.pw26s.server.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

	private final String AUDIENCE_WEB = "web";
	private final String AUDIENCE_MOBILE = "mobile";
	private final String AUDIENCE_TABLET = "tablet";

	private String secret = "utfpr";
	private Long expiration = 604800L;

	private Claims getClaimsFromToken(String token) {
		return null;
	}

	public String getUsernameFromToken(String token) {
		return null;
	}
	public Date getCreatedDateFromToken(String token) {
		return null;
	}

	public Date getExpirationDateFromToken(String token) {
		return null;
	}

	public String getAudienceFromToken(String token) {
		return null;
	}

	private Date generateCurrentDate() {
		return null;
	}

	private Date generateExpirationDate() {
		return null;
	}

	private Boolean isTokenExpired(String token) {

		return null;
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return null;
	}

	public Boolean ignoreTokenExpired(String token) {
		return null;
	}

	public String generateToken(UserDetails userDetails) {

		return null;
	}

	private String generateToken(Map<String, Object> claims) {
		return null;
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		return null;
	}

	public String refreshToken(String token) {
		return null;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		Usuario user = (Usuario) userDetails;
		final String username = this.getUsernameFromToken(token);
		final Date created = this.getCreatedDateFromToken(token);
		return (username.equals(user.getUsername())
				&& !(this.isTokenExpired(token))
				&& !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset() ))
				);
	}
}
