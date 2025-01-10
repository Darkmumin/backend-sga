package com.jai.darkmumin.sga.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    @Value("${tokenSignature}")
    private String tokenSignature;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public String tokenGenerate(UserDetails userDetails) {
        return tokenGenerate(new HashMap<>(), userDetails);
    }
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private String tokenGenerate(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts
            .builder()
            .claims(claims)
            .subject(userDetails.getUsername())
            .claim("sub", userDetails.getUsername()) // Set the subject using a claim
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)) // 1 hour
            .signWith(getSignature(), Jwts.SIG.HS256)
            .compact();
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSignature())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
    private SecretKey getSignature() {
        byte[] keyBytes = Decoders.BASE64.decode(tokenSignature);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
