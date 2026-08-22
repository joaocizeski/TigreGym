package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.LoginRequest;
import com.example.tigregym.services.TokenService;
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
@Tag(description = "Controler de autenticação!", name = "Autenticação")
public class AuthController {

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    @Tag(description = "Método de login!", name = "Autenticação de usuário")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        if (loginRequest.equals("string")&& loginRequest.senha().equals("string")){

            var token = tokenService.gerarToken(loginRequest.email());

            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
    }

}