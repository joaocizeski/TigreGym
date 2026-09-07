package com.example.tigregym.DTOs;

public record RecuperarSenhaRequest(
        String email,
        String cpf,
        String novaSenha
) {
}