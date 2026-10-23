package com.example.tigregym.infra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtFIlter jwtFIlter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        // Rotas públicas
                        .requestMatchers(HttpMethod.POST,
                                "/auth/login",
                                "/usuarios/admin")
                        .permitAll()

                        .requestMatchers(
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/v3/api-docs/**")
                        .permitAll()

                        // Somente administrador pode gerenciar usuários
                        .requestMatchers("/usuarios/**")
                        .hasRole("ADMIN")

                        // Todos os perfis podem consultar os planos
                        .requestMatchers(HttpMethod.GET, "/planos/**")
                        .hasAnyRole("ADMIN", "FUNCIONARIO", "USER")

                        // Administrador e funcionário podem gerenciar os planos
                        .requestMatchers("/planos/**")
                        .hasAnyRole("ADMIN", "FUNCIONARIO")

                        // Administrador e funcionário gerenciam alunos e matrículas
                        .requestMatchers("/alunos/**", "/matriculas/**")
                        .hasAnyRole("ADMIN", "FUNCIONARIO")

                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(jwtFIlter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
