package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.AtualizarStatusPlanoRequest;
import com.example.tigregym.entities.EnumStatusPlano;
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

        return ResponseEntity.ok(planoRepository.findByStatusNot(EnumStatusPlano.EXCLUIDO));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de plano!",
            description = "Método responsável por efetuar a criação de novos planos!")
    public ResponseEntity<Plano> criar(@RequestBody Plano plano){

        var planoBanco = planoRepository.save(plano);
        return ResponseEntity.ok(planoBanco);

    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Método de consulta de plano por ID!",
            description = "Método responsável por efetuar a consulta de um plano através do ID"
    )
    public ResponseEntity<Plano> listarPorId(@PathVariable Long id) {

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {
            return ResponseEntity.ok(planoBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    @Operation(
            summary = "Método de atualização do status do plano!",
            description = "Método responsável por alterar o status de um plano através do ID"
    )
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusPlanoRequest statusRequest) {

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {

            // Altera o status do plano
            planoBanco.setStatus(statusRequest.status());

            planoRepository.save(planoBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Método de atualização de plano!",
            description = "Método responsável por atualizar os dados de um plano através do ID"
    )
    public ResponseEntity<Plano> atualizar(
            @PathVariable Long id,
            @RequestBody Plano plano) {

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {

            // Atualiza os dados do plano
            planoBanco.setNome(plano.getNome());
            planoBanco.setDescricao(plano.getDescricao());
            planoBanco.setValor(plano.getValor());
            planoBanco.setDuracaoEmMeses(plano.getDuracaoEmMeses());
            planoBanco.setStatus(plano.getStatus());

            planoRepository.save(planoBanco);

            return ResponseEntity.ok(planoBanco);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/excluir")
    @Operation(
            summary = "Método de exclusão de plano!",
            description = "Método responsável por alterar o status do plano para EXCLUIDO"
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {

            // Faz a exclusão lógica do plano
            planoBanco.setStatus(EnumStatusPlano.EXCLUIDO);

            planoRepository.save(planoBanco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
