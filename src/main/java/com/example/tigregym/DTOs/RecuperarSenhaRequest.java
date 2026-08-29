package com.example.tigregym.DTOs;

public record RedefinirSenhaRequest(
        String email,
        String cpf,
        String novaSenha
) {
}