package com.example.tigregym.application.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.tigregym.application.DTOs.UsuarioLogado;
import com.example.tigregym.domain.entities.EnumStatusUsuario;
import com.example.tigregym.domain.entities.Token;
import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class TokenService {

    @Value("${spring.secret}")
    private String secret;

    @Value("${spring.expiracao}")
    private Long expiracao;

    @Value("${spring.emissor}")
    private String emissor;

    @Autowired
    private TokenRepository tokenRepository;

    public String gerarToken(Usuario usuario) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(expiracao);

        String token = JWT.create()
                .withIssuer(emissor)
                .withSubject(usuario.getEmail().toString())
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("role", usuario.getRole())
                .withExpiresAt(converterParaInstant(dataExpiracao))
                .sign(algorithm);

        // Salva o mesmo token gerado no banco para validar os próximos acessos
        tokenRepository.save(new Token(token, usuario, dataExpiracao));

        return token;
    }

    public UsuarioLogado verificarToken(String token) throws JWTVerificationException {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        JWTVerifier verificador = JWT.require(algorithm)
                .withIssuer(emissor)
                .build();

        // Primeiro valida assinatura e expiração do JWT
        var tokenDecodificado = verificador.verify(token);

        // Depois confirma se o token existe e continua válido no banco
        Token tokenBanco = tokenRepository
                .findFirstByTokenOrderByIdDesc(token)
                .orElse(null);

        if (tokenBanco == null || !tokenBanco.estaValido()) {
            throw new IllegalArgumentException("Token inválido!");
        }

        Usuario usuario = tokenBanco.getUsuario();

        if (usuario == null || usuario.getStatus() != EnumStatusUsuario.ATIVO) {
            throw new IllegalArgumentException("Usuário não está ativo!");
        }

        if (!tokenDecodificado.getSubject().equals(usuario.getEmail().toString())) {
            throw new IllegalArgumentException("Token inválido!");
        }

        return new UsuarioLogado(usuario);
    }

    private Instant converterParaInstant(LocalDateTime dataExpiracao) {
        return dataExpiracao.toInstant(ZoneOffset.of("-03:00"));
    }
}
