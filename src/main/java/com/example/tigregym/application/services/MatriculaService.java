package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.MatriculaRequest;
import com.example.tigregym.application.DTOs.MatriculaResponse;
import com.example.tigregym.domain.entities.Aluno;
import com.example.tigregym.domain.entities.EnumStatusMatricula;
import com.example.tigregym.domain.entities.Matricula;
import com.example.tigregym.domain.entities.Plano;
import com.example.tigregym.domain.repository.AlunoRepository;
import com.example.tigregym.domain.repository.MatriculaRepository;
import com.example.tigregym.domain.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public List<MatriculaResponse> listarTodosMatriculaTable() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaResponse::new)
                .toList();
    }

    public MatriculaResponse salvarMatricula(MatriculaRequest matricula, Long id) {

        Aluno alunoBanco = alunoRepository.findById(matricula.aluno_id()).orElse(null);
        Plano planoBanco = planoRepository.findById(matricula.plano_id()).orElse(null);

        if (alunoBanco == null || planoBanco == null) {
            return null;
        }

        if (id == 0L) {
            Matricula matriculaBanco = new Matricula();
            matriculaBanco.setAluno(alunoBanco);
            matriculaBanco.setPlano(planoBanco);
            matriculaBanco.setDataInicio(matricula.dataInicio());
            matriculaBanco.setDataVencimento(matricula.dataVencimento());

            matriculaRepository.save(matriculaBanco);

            return new MatriculaResponse(matriculaBanco);
        }

        Matricula matriculaBanco = matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {
            matriculaBanco.setAluno(alunoBanco);
            matriculaBanco.setPlano(planoBanco);
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
