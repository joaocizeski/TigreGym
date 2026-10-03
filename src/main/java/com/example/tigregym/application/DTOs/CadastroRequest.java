package com.example.tigregym.application.DTOs;

// Recebe os dados necessários para cadastrar um usuário
public record CadastroRequest(
        String nome,
        String cpf,
        String email,
        String senha
) {
}