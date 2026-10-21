package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.AlunoRequest;
import com.example.tigregym.application.DTOs.AlunoResponse;
import com.example.tigregym.domain.entities.Aluno;
import com.example.tigregym.domain.entities.EnumStatusAluno;
import com.example.tigregym.domain.repository.AlunoRepository;
import com.example.tigregym.domain.valueobject.CPF;
import com.example.tigregym.domain.valueobject.Email;
import com.example.tigregym.domain.valueobject.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponse> listarTodosAlunoTable() {
        return alunoRepository.findByStatusNot(EnumStatusAluno.EXCLUIDO)
                .orElse(List.of())
                .stream()
                .map(AlunoResponse::new)
                .toList();
    }

    public AlunoResponse salvarAluno(AlunoRequest aluno, Long id) {

        if (id == 0L) {
            Aluno alunoBanco = new Aluno();
            alunoBanco.setNome(aluno.nome());
            alunoBanco.setCpf(new CPF(aluno.cpf()));
            alunoBanco.setDataNascimento(aluno.dataNascimento());
            alunoBanco.setTelefone(new Telefone(aluno.telefone()));
            alunoBanco.setEmail(new Email(aluno.email()));

            alunoRepository.save(alunoBanco);

            return new AlunoResponse(alunoBanco);
        }

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {
            alunoBanco.setNome(aluno.nome());
            alunoBanco.setCpf(new CPF(aluno.cpf()));
            alunoBanco.setDataNascimento(aluno.dataNascimento());
            alunoBanco.setTelefone(new Telefone(aluno.telefone()));
            alunoBanco.setEmail(new Email(aluno.email()));

            alunoRepository.save(alunoBanco);

            return new AlunoResponse(alunoBanco);
        }

        return null;
    }

    public AlunoResponse buscarPorId(Long id) {

        Aluno aluno = alunoRepository.findById(id).orElse(null);

        if (aluno == null) {
            return null;
        }

        return new AlunoResponse(aluno);
    }

    public boolean atualizarStatus(EnumStatusAluno status, Long id) {

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {
            alunoBanco.setStatus(status);
            alunoRepository.save(alunoBanco);
            return true;
        }

        return false;
    }
}
