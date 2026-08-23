package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.LoginRequest;
import com.example.tigregym.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação",
        description = "Grupo de APIs responsável pela autenticação de usuários do sistema!")
public class AuthController {

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    @Operation(summary = "Método de autenticação de usuário!",
            description = "Método responsável por efetuar o login do usuário e gerar o token de autenticação!")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        if (loginRequest.email().equals("string") && loginRequest.senha().equals("string")){

            var token = tokenService.gerarToken(loginRequest.email());

            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
    }

}