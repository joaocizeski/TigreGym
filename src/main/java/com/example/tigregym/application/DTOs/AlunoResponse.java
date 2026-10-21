package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.Aluno;
import com.example.tigregym.domain.entities.EnumStatusAluno;

import java.time.LocalDate;

public record AlunoResponse(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email, EnumStatusAluno status) {

    public AlunoResponse(Aluno alunoEntidade) {
        this(
                alunoEntidade.getId(),
                alunoEntidade.getNome(),
                alunoEntidade.getCpf().toString(),
                alunoEntidade.getDataNascimento(),
                alunoEntidade.getTelefone().toString(),
                alunoEntidade.getEmail().toString(),
                alunoEntidade.getStatus()
        );
    }
}
