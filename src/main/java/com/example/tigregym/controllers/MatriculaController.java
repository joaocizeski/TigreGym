package com.example.tigregym.controllers;

import com.example.tigregym.entidades.Matricula;
import com.example.tigregym.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(matriculaRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Matricula> criar(@RequestBody Matricula matricula){

        var matriculaBanco = matriculaRepository.save(matricula);
        return ResponseEntity.ok(matriculaBanco);

    }

}
