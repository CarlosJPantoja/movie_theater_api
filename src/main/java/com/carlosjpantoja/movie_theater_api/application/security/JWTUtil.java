package com.carlosjpantoja.movie_theater_api.application.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.carlosjpantoja.movie_theater_api.application.security.JWTAuthorizationRequestFilter.USERNAME_CLAIM_KEY;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static java.lang.System.currentTimeMillis;
import static javax.xml.bind.DatatypeConverter.parseBase64Binary;

public class JWTUtil {

	private static final String SECRET_KEY = "eY>j<]ecHpDB#.OluHOrAP%g<mb$UG;E}&!&uT&5o27Uu'xinn5fd$1LJZcGGie";

	public static String generateToken(String username) {
		Map<String, String> claims = new HashMap<>();
		claims.put(USERNAME_CLAIM_KEY, username);
		byte[] bytes = parseBase64Binary(SECRET_KEY);
		Key key = new SecretKeySpec(bytes, HS256.getJcaName());
		return Jwts.builder()
				.setId(username)
				.setIssuedAt(new Date(currentTimeMillis()))
				.setSubject(username)
				.setIssuer(username)
				.setClaims(claims)
				.signWith(key, HS256)
				.setExpiration(new Date(currentTimeMillis() + 1000 * 60 * 60))
				.compact();
	}

	public static Claims decodeJWT(String token) {
		return Jwts.parserBuilder().setSigningKey(parseBase64Binary(SECRET_KEY)).build()
				.parseClaimsJws(token).getBody();
	}

}
