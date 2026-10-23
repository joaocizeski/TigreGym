package com.example.tigregym.application.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.tigregym.application.DTOs.LoginRequest;
import com.example.tigregym.application.DTOs.UsuarioLogado;
import com.example.tigregym.domain.entities.Token;
import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.repository.TokenRepository;
import com.example.tigregym.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.util.Arrays.stream;

@Service
public class TokenService {


    @Value("${spring.secret}")
    private String secret;

    @Value("${spring.expiracao}")
    private Long expiracao;

    @Value("${spring.emissor}")
    private String emissor;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public String gerarToken(LoginRequest loginRequestDto) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        var usuario = usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(loginRequestDto.email()))
                .findFirst().orElse(null);

        String token = JWT.create()
                .withIssuer(emissor)
                .withSubject(loginRequestDto.email())
                .withExpiresAt(this.gerarDataExpiracao())
                .sign(algorithm);

        tokenRepository.save(new Token(token, usuario));

        return token;
    }

    public UsuarioLogado verificarToken(String token) throws JWTVerificationException {
        // Usa a mesma chave para conferir se o token é válido
        Algorithm algorithm =Algorithm.HMAC256(secret);

        // Cria o verificador usando o emissor configurado
        JWTVerifier verificador = JWT.require(algorithm).withIssuer(emissor).build();

        verificador.verify(token);

        var tokenBanco = tokenRepository.findTokenByToken(token).orElse(null);

        if(tokenBanco==null){
            throw  new IllegalArgumentException("Token Invalido!");
        }

        return new UsuarioLogado(tokenBanco.getUsuario());

    }

    private Instant gerarDataExpiracao(){

        // Pega a data e hora atual
        var dataAtual = LocalDateTime.now();

        // Adiciona os minutos de validade do token
        dataAtual = dataAtual.plusMinutes(expiracao);

        // Converte a data para o formato usado pelo JWT
        return dataAtual.toInstant(ZoneOffset.of("-03:00"));
    }

}