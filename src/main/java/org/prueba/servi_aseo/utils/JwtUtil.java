package org.prueba.servi_aseo.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;

@Component
public class JwtUtil {

    public String generateToken(Map<String, Object> claims) throws InvalidKeyException, Exception {
        return createToken(claims);
    }

    private SecretKey generateSecretKey() throws Exception {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(256);
            return keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O maneja el error según tus necesidades
        }

    }

    private String createToken(Map<String, Object> claims) throws Exception {

        try {
            return Jwts.builder().claims(claims).issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 12)) // 10 horas de
                                                                                                 // expiración
                    .signWith(generateSecretKey()).compact();
        } catch (InvalidKeyException ex) {
            throw new InvalidKeyException(ex.getMessage(), ex);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }

    public boolean validateToken(String token, String username) throws Exception {
        final String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) throws Exception {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) throws Exception {
        JwtParser parser = Jwts.parser().verifyWith(generateSecretKey()) // Configura la clave secreta
                .build();
        return parser.parseSignedClaims(token).getPayload();
    }

    private Boolean isTokenExpired(String token) throws Exception {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

}
