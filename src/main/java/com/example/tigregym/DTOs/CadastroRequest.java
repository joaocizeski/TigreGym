package com.example.tigregym.DTOs;

// DTO usado para receber os dados enviados no cadastro
public record CadastroRequest(
        String nome,
        String cpf,
        String email,
        String senha
) {
}