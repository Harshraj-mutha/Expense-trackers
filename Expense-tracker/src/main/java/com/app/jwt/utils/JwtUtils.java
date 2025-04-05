package com.app.jwt.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.app.service.CustomUserDetail;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${Secret_key}")
	private String JWTSecretKey;

	@Value("${EXP_timeout}")
	private String expTimeout;

	public String generateToken(Authentication authentication) {
		SecretKey key = Keys.hmacShaKeyFor(JWTSecretKey.getBytes(StandardCharsets.UTF_8));
		CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
		return Jwts.builder().setSubject(userDetail.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expTimeout)))
				.signWith(key)
				.compact();

	}

	public String getUserNameFromJWTToken(String token) {
		String name = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWTSecretKey)))
				.build().parseClaimsJws(token).getBody().getSubject();
		return name;
	}

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWTSecretKey))).build()
					.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
