package com.example.tigregym.controllers;

import com.example.tigregym.entidades.Usuario;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/listar")
    public ResponseEntity<?> listarTodos(){
        List<Usuario> usuarios = List.of(new Usuario(1L,
                "João",
                "11698652917",
                "12345",
                "joao.cizeski@alunos.sc.senac.br"));

        return ResponseEntity.ok("Sucesso");
    }
}