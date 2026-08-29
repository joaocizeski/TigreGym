package com.example.tigregym.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordConfiguration {

    /* Cria o objeto responsável por criptografar e comparar as senhas
    O BCrypt faz com que no banco a senha não fique:
    123456

    Ela fica algo  parecido com:
    $2a$10$wE89...
    */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}