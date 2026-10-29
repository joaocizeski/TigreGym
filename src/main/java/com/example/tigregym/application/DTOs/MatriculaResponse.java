package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.EnumStatusMatricula;
import com.example.tigregym.domain.entities.Matricula;

import java.time.LocalDateTime;

public record MatriculaResponse(
        Long id,
        Long alunoId,
        String aluno,
        Long planoId,
        String plano,
        LocalDateTime dataInicio,
        LocalDateTime dataVencimento,
        EnumStatusMatricula status
) {

    public MatriculaResponse(Matricula matriculaEntidade) {
        this(
                matriculaEntidade.getId(),
                matriculaEntidade.getAluno() != null ? matriculaEntidade.getAluno().getId() : null,
                matriculaEntidade.getAluno() != null ? matriculaEntidade.getAluno().getNome() : "",
                matriculaEntidade.getPlano() != null ? matriculaEntidade.getPlano().getId() : null,
                matriculaEntidade.getPlano() != null ? matriculaEntidade.getPlano().getNome() : "",
                matriculaEntidade.getDataInicio(),
                matriculaEntidade.getDataVencimento(),
                matriculaEntidade.getStatus()
        );
    }
}
