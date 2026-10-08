package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.EnumStatusMatricula;
import com.example.tigregym.domain.entities.Matricula;

import java.time.LocalDateTime;

public record MatriculaResponse(Long id, String aluno, String plano, LocalDateTime dataInicio, LocalDateTime dataVencimento, EnumStatusMatricula status) {

    public MatriculaResponse(Matricula matriculaEntidade) {
        this(
                matriculaEntidade.getId(),
                matriculaEntidade.getAluno(),
                matriculaEntidade.getPlano(),
                matriculaEntidade.getDataInicio(),
                matriculaEntidade.getDataVencimento(),
                matriculaEntidade.getStatus()
        );
    }
}
