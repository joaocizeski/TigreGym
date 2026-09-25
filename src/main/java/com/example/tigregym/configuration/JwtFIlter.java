package com.example.tigregym.configuration;

import com.example.tigregym.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFIlter extends OncePerRequestFilter {

    @Autowired // É uma injeção de dependência
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Pega a rota que está sendo acessada
        String uri = request.getRequestURI();

        // Verifica se a rota está na lista que pode passar sem validar o token
        if (uri.startsWith("/swagger-ui")
        || uri.startsWith("/v2/api-docs")
        || uri.startsWith("/v3/api-docs")
        || uri.startsWith("/swagger-resources")
        || uri.startsWith("/webjars")
        || uri.startsWith("/auth/login")
        || uri.startsWith("/auth/cadastro")
        || uri.startsWith("/auth/recuperar-senha")
        || uri.startsWith("/")
        ){
            filterChain.doFilter(request,response);
            return;
        }

        // Pega o token enviado no cabeçalho da requisição
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")){
             // Remove o texto Bearer e deixa somente o token
             String token = authHeader.replace("Bearer ", "");

             try {

                 // Confere se o token recebido é válido
                 var jwtValidator = tokenService.verificarToken(token);

                 System.out.println(jwtValidator.getSubject());

             } catch (Exception e) {

                 // Retorna 401 quando o token não é válido
                 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                 response.getWriter().println("Token inválido");
                 return;

             }

        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Token inválido");
            return;
        }

        // Continua a requisição depois da validação
        filterChain.doFilter(request,response);

    }
}
