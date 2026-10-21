package com.example.tigregym.application.DTOs;

public record PlanoRequest(
        String nome,
        String descricao,
        String valor,
        Integer duracaoEmMeses
) {
}
