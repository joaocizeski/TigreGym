package com.example.tigregym.controllers;

import com.example.tigregym.entities.Usuario;
import com.example.tigregym.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários",
        description = "Grupo de APIs responsável por controlar a estrutura de usuário do sistema!")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @Operation(summary = "Método de consulta de lista de usuário!",
            description = "Método reponsável em efetuar a consulta de todos os usuário sem filtro")
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(usuarioRepository.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de usuário!",
            description = "Método reponsável em efetuar a criação de novos usuários!")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){

        var usuarioBanco = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioBanco);

    }

}