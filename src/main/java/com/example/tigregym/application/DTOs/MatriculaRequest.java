package com.example.tigregym.application.DTOs;

import java.time.LocalDateTime;

public record MatriculaRequest(
        String aluno,
        String plano,
        LocalDateTime dataInicio,
        LocalDateTime dataVencimento
) {
}
