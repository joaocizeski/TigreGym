package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.MatriculaRequest;
import com.example.tigregym.application.DTOs.MatriculaResponse;
import com.example.tigregym.domain.entities.EnumStatusMatricula;
import com.example.tigregym.domain.entities.Matricula;
import com.example.tigregym.domain.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<MatriculaResponse> listarTodosMatriculaTable() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaResponse::new)
                .toList();
    }

    public MatriculaResponse salvarMatricula(MatriculaRequest matricula, Long id) {

        if (id == 0L) {
            Matricula matriculaBanco = new Matricula();
            matriculaBanco.setAluno(matricula.aluno());
            matriculaBanco.setPlano(matricula.plano());
            matriculaBanco.setDataInicio(matricula.dataInicio());
            matriculaBanco.setDataVencimento(matricula.dataVencimento());

            matriculaRepository.save(matriculaBanco);

            return new MatriculaResponse(matriculaBanco);
        }

        Matricula matriculaBanco = matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {
            matriculaBanco.setAluno(matricula.aluno());
            matriculaBanco.setPlano(matricula.plano());
            matriculaBanco.setDataInicio(matricula.dataInicio());
            matriculaBanco.setDataVencimento(matricula.dataVencimento());

            matriculaRepository.save(matriculaBanco);

            return new MatriculaResponse(matriculaBanco);
        }

        return null;
    }

    public MatriculaResponse buscarPorId(Long id) {

        Matricula matricula = matriculaRepository.findById(id).orElse(null);

        if (matricula == null) {
            return null;
        }

        return new MatriculaResponse(matricula);
    }

    public boolean atualizarStatus(EnumStatusMatricula status, Long id) {

        Matricula matriculaBanco = matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {
            matriculaBanco.setStatus(status);
            matriculaRepository.save(matriculaBanco);
            return true;
        }

        return false;
    }
}
