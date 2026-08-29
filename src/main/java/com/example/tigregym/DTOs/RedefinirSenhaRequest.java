package com.example.tigregym.DTOs;

// DTO usado para receber o token de recuperação e a nova senha
public record RedefinirSenhaRequest(
        String token,
        String novaSenha
) {
}