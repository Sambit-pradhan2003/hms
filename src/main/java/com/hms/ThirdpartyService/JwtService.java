package com.hms.ThirdpartyService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Algorithm algorithm;

    @PostConstruct
    public  void postconstruct(){
        algorithm = Algorithm.HMAC256(secret);
    }

    public String generateToken( String username) {
        return JWT.create()
                .withClaim("name",username)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .withIssuer(issuer)
                .sign(algorithm);

    }
    public String decodetoken(String token){
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(token);
        return decodedJWT.getClaim("name").asString();
    }

}
