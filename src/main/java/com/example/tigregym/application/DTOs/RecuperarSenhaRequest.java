package com.example.tigregym.application.DTOs;

public record RecuperarSenhaRequest(
        String email,
        String cpf,
        String novaSenha
) {
}