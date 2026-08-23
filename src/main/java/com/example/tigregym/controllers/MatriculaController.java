package com.example.tigregym.controllers;

import com.example.tigregym.entities.Matricula;
import com.example.tigregym.repository.MatriculaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@Tag(name = "Matrículas",
        description = "Grupo de APIs responsável por controlar a estrutura de matrículas do sistema!")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    @Operation(summary = "Método de consulta da lista de matrículas!",
            description = "Método responsável por efetuar a consulta de todas as matrículas sem filtro")
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(matriculaRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de matrícula!",
            description = "Método responsável por efetuar a criação de novas matrículas!")
    public ResponseEntity<Matricula> criar(@RequestBody Matricula matricula){

        var matriculaBanco = matriculaRepository.save(matricula);
        return ResponseEntity.ok(matriculaBanco);

    }

}
