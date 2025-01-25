//package com.semicolon.farm_Links.config;
//
//import com.semicolon.farm_Links.data.model.Role;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    private final String secret = "your_secret_key"; // Use a strong key in production
//
//    public String generateToken(String username, Role role) {
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("role", role.name())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String extractRole(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role", String.class);
//    }
//
//    public boolean validateToken(String token) {
//        return !Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().before(new Date());
//    }
//}
