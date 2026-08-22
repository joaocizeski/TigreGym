package com.example.tigregym.controllers;

import com.example.tigregym.entities.Aluno;
import com.example.tigregym.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(alunoRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno){

        var alunoBanco = alunoRepository.save(aluno);

        return ResponseEntity.ok(alunoBanco);

    }

}
