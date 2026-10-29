package com.example.tigregym.application.DTOs;

import java.time.LocalDateTime;

public record MatriculaRequest(
        Long aluno_id,
        Long plano_id,
        LocalDateTime dataInicio,
        LocalDateTime dataVencimento
) {
}
