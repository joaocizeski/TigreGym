package com.example.tigregym.controllers;

import com.example.tigregym.entities.Aluno;
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

        return ResponseEntity.ok(alunoRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de aluno!",
            description = "Método responsável por efetuar a criação de novos alunos!")
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno){

        var alunoBanco = alunoRepository.save(aluno);

        return ResponseEntity.ok(alunoBanco);

    }

}
