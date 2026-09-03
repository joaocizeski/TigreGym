package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.AtualizarStatusAlunoRequest;
import com.example.tigregym.entities.Aluno;
import com.example.tigregym.entities.EnumStatusAluno;
import com.example.tigregym.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos",
        description = "Grupo de APIs responsável por controlar a estrutura de alunos do sistema!")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    @Operation(summary = "Método de consulta da lista de alunos!",
            description = "Método responsável por efetuar a consulta de todos os alunos sem filtro")
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(alunoRepository.findByStatusNot(EnumStatusAluno.EXCLUIDO));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de aluno!",
            description = "Método responsável por efetuar a criação de novos alunos!")
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno){

        var alunoBanco = alunoRepository.save(aluno);

        return ResponseEntity.ok(alunoBanco);

    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Método de consulta de aluno por ID!",
            description = "Método responsável por efetuar a consulta de um aluno através do ID"
    )
    public ResponseEntity<Aluno> listarPorId(@PathVariable Long id) {

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {
            return ResponseEntity.ok(alunoBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    @Operation(
            summary = "Método de atualização do status do aluno!",
            description = "Método responsável por alterar o status de um aluno através do ID"
    )
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestBody AtualizarStatusAlunoRequest statusRequest) {

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {

            // Altera o status do aluno
            alunoBanco.setStatus(statusRequest.status());

            alunoRepository.save(alunoBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Método de atualização de aluno!",
            description = "Método responsável por atualizar os dados de um aluno através do ID"
    )
    public ResponseEntity<Aluno> atualizar(
            @PathVariable Long id,
            @RequestBody Aluno aluno) {

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {

            // Atualiza os dados do aluno
            alunoBanco.setNome(aluno.getNome());
            alunoBanco.setCpf(aluno.getCpf());
            alunoBanco.setDataNascimento(aluno.getDataNascimento());
            alunoBanco.setTelefone(aluno.getTelefone());
            alunoBanco.setEmail(aluno.getEmail());
            alunoBanco.setStatus(aluno.getStatus());

            alunoRepository.save(alunoBanco);

            return ResponseEntity.ok(alunoBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/excluir")
    @Operation(
            summary = "Método de exclusão de aluno!",
            description = "Método responsável por alterar o status do aluno para EXCLUIDO"
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        Aluno alunoBanco = alunoRepository.findById(id).orElse(null);

        if (alunoBanco != null) {

            // Faz a exclusão lógica do aluno
            alunoBanco.setStatus(EnumStatusAluno.EXCLUIDO);

            alunoRepository.save(alunoBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
