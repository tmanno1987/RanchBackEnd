package com.ranch.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ranch.security.services.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtility {
	private static final Logger log = LoggerFactory.getLogger(JwtUtility.class);
	
	@Value("${com.ranch.security.jwt.jwtSecret}")
	private String jwtSecret;
	
	@Value("${com.ranch.security.jwt.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication auth) {
		UserDetailsImpl principal = (UserDetailsImpl) auth.getPrincipal();
		
		return Jwts.builder().setSubject((principal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	
	public String getUsernameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authTok) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authTok);
			return true;
		} catch (SignatureException se) {
			log.error("Invalid JWT Signature: {}", se.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}










