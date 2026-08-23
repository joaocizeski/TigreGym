package com.example.tigregym.controllers;

import com.example.tigregym.entities.Plano;
import com.example.tigregym.repository.PlanoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planos")
@Tag(name = "Planos",
        description = "Grupo de APIs responsável por controlar a estrutura de planos do sistema!")
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping
    @Operation(summary = "Método de consulta da lista de planos!",
            description = "Método responsável por efetuar a consulta de todos os planos sem filtro")
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(planoRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de plano!",
            description = "Método responsável por efetuar a criação de novos planos!")
    public ResponseEntity<Plano> criar(@RequestBody Plano plano){

        var planoBanco = planoRepository.save(plano);
        return ResponseEntity.ok(planoBanco);

    }

}
