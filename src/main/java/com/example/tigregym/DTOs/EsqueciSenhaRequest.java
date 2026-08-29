package com.example.tigregym.DTOs;

// DTO usado para receber o e-mail do usuário que esqueceu a senha
public record EsqueciSenhaRequest(
        String email
) {
}