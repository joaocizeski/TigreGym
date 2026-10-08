package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.MatriculaResponse;
import com.example.tigregym.domain.entities.EnumStatusMatricula;
import com.example.tigregym.domain.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<MatriculaResponse> listarTodosMatriculaTable() {

        // Busca as matrículas que ainda não foram excluídas
        return matriculaRepository.findByStatusNot(EnumStatusMatricula.EXCLUIDO)
                .orElse(List.of())
                .stream()
                .map(MatriculaResponse::new)
                .toList();
    }
}
