package com.example.tigregym.infra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtFIlter jwtFIlter;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        return http.cors(Customizer.withDefaults())
                .cors(AbstractHttpConfigurer :: disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/v3/api-docs/**")
                        .permitAll()
                        .requestMatchers("/usuarios/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(jwtFIlter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
