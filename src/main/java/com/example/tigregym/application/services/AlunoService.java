package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.AlunoResponse;
import com.example.tigregym.domain.entities.EnumStatusAluno;
import com.example.tigregym.domain.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponse> listarTodosAlunoTable() {

        // Busca os alunos que ainda não foram excluídos
        return alunoRepository.findByStatusNot(EnumStatusAluno.EXCLUIDO)
                .orElse(List.of())
                .stream()
                .map(AlunoResponse::new)
                .toList();
    }
}
