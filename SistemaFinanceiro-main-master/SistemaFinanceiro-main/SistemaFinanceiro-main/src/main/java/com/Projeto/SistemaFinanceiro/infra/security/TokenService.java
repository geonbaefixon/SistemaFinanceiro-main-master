package com.Projeto.SistemaFinanceiro.infra.security;

import com.Projeto.SistemaFinanceiro.domain.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.Value;
import org.springframework.stereotype.Service;

public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Service
    public String gerarToken( usuario){
        try {
            var algoritmo =  Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("API SistemaFinanceiro")
                    .withSubject(usuario.getLogin())
                    .withExpireAt(dataExpiracao())
                    .sign(algoritmo);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token jwt", exception);
        }

    }

   public String getSubject(String tokenJWT){
        try{
        Algorithm algoritmo = Algorithm.HMAC256(secret);
        return JWT.require(algoritmo)
                .withIssuer("API SistemaFinanceiro")
                .build()
                .verify(tokenJWT)
                .getSubject();
        decodedJWT = verifier.verify(token);
    } catch (JWTVerificationException exception){
        throw new RuntimeException("Token JWT inválido ou expirado!");
    }
        }


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).
        toInstant(ZoneOffset.of("-03:00"));
    }
}