package com.example.tigregym.controllers;

import com.example.tigregym.entidades.Plano;
import com.example.tigregym.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(planoRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Plano> criar(@RequestBody Plano plano){

        var planoBanco = planoRepository.save(plano);
        return ResponseEntity.ok(planoBanco);

    }

}
