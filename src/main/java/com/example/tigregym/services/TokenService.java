package com.example.tigregym.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    @Value("${spring.secret}")
    private String secret;

    @Value("${spring.expiracao}")
    private Long expiracao;

    @Value("${spring.emissor}")
    private String emissor;


    public String gerarToken(String subject){

        try{

            // Usa a chave secreta para assinar o token
            Algorithm algorithm =Algorithm.HMAC256(secret);

            // Monta o token com emissor, usuário e tempo de expiração
            String token = JWT.create()
                    .withIssuer(emissor)
                    .withSubject(subject)
                    .withExpiresAt(getDataExpiracao())
                    .sign(algorithm);

            return token;

        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

    }

    public DecodedJWT verificarToken(String token) throws JWTVerificationException {
        // Usa a mesma chave para conferir se o token é válido
        Algorithm algorithm =Algorithm.HMAC256(secret);

        // Cria o verificador usando o emissor configurado
        JWTVerifier verificador = JWT.require(algorithm).withIssuer(emissor).build();

        return verificador.verify(token);

    }

    private Instant getDataExpiracao(){

        // Pega a data e hora atual
        var dataAtual = LocalDateTime.now();

        // Adiciona os minutos de validade do token
        dataAtual = dataAtual.plusMinutes(expiracao);

        // Converte a data para o formato usado pelo JWT
        return dataAtual.toInstant(ZoneOffset.of("-03:00"));
    }

}