package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.AtualizarStatusMatriculaRequest;
import com.example.tigregym.entities.EnumStatusMatricula;
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

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> listarPorId(@PathVariable Long id) {

        Matricula matriculaBanco =
                matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {
            return ResponseEntity.ok(matriculaBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestBody AtualizarStatusMatriculaRequest statusRequest) {

        Matricula matriculaBanco =
                matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {

            // Altera o status da matrícula
            matriculaBanco.setStatus(statusRequest.status());

            matriculaRepository.save(matriculaBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(
            @PathVariable Long id,
            @RequestBody Matricula matricula) {

        Matricula matriculaBanco =
                matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {

            // Atualiza os dados da matrícula
            matriculaBanco.setAluno(matricula.getAluno());
            matriculaBanco.setPlano(matricula.getPlano());
            matriculaBanco.setDataInicio(matricula.getDataInicio());
            matriculaBanco.setDataVencimento(matricula.getDataVencimento());
            matriculaBanco.setStatus(matricula.getStatus());

            matriculaRepository.save(matriculaBanco);

            return ResponseEntity.ok(matriculaBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        Matricula matriculaBanco =
                matriculaRepository.findById(id).orElse(null);

        if (matriculaBanco != null) {

            // Faz a exclusão lógica da matrícula
            matriculaBanco.setStatus(EnumStatusMatricula.EXCLUIDO);

            matriculaRepository.save(matriculaBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
