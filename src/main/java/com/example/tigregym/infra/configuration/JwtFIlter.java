package com.example.tigregym.infra.configuration;

import com.example.tigregym.application.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFIlter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String uri = request.getRequestURI();

        // Libera o preflight do navegador
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        // Rotas que não precisam de token
        if (uri.startsWith("/swagger-ui")
                || uri.startsWith("/v2/api-docs")
                || uri.startsWith("/v3/api-docs")
                || uri.startsWith("/swagger-resources")
                || uri.startsWith("/webjars")
                || uri.equals("/auth/login")
                || ("POST".equalsIgnoreCase(request.getMethod())
                && uri.equals("/usuarios/admin"))) {

            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Token não informado");
            return;
        }

        String token = authHeader.substring(7);

        try {

            // Valida assinatura, expiração e existência do token no banco
            var usuarioLogado = tokenService.verificarToken(token);

            var autenticacao = new UsernamePasswordAuthenticationToken(
                    usuarioLogado,
                    null,
                    usuarioLogado.authorities()
            );

            SecurityContextHolder.getContext().setAuthentication(autenticacao);

        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Token inválido");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
