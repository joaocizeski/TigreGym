package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.AtualizarStatusUsuarioRequest;
import com.example.tigregym.entities.EnumStatusUsuario;
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
        description = "Grupo de APIs responsável por controlar a estrutura de usuários do sistema!")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @Operation(summary = "Método de consulta da lista de usuários!",
            description = "Método responsável por efetuar a consulta de todos os usuários sem filtro")
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(usuarioRepository.findByStatusNot(EnumStatusUsuario.EXCLUIDO));

    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Método de consulta de usuário por ID!",
            description = "Método responsável por efetuar a consulta de um usuário através do ID"
    )
    public ResponseEntity<Usuario> listarPorId(@PathVariable Long id) {

        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if (usuarioBanco != null) {
            return ResponseEntity.ok(usuarioBanco);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Método de criação de usuário!",
            description = "Método responsável por efetuar a criação de novos usuários!")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){

        var usuarioBanco = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioBanco);

    }

    @PatchMapping("/{id}/status")
    @Operation(
            summary = "Método de atualização do status do usuário!",
            description = "Método responsável por alterar o status de um usuário através do ID"
    )
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusUsuarioRequest statusRequest){

        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if(usuarioBanco!= null ){
            usuarioBanco.setStatus(statusRequest.status());
            usuarioRepository.save(usuarioBanco);
            return ResponseEntity.ok().build();
        }

        return  ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Método de atualização de usuário!",
            description = "Método responsável por atualizar os dados de um usuário através do ID"
    )
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){

        try {
            Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
            if (usuarioBanco != null) {
                usuarioBanco.setStatus(usuario.getStatus());
                usuarioBanco.setNome(usuario.getNome());
                usuarioBanco.setCpf(usuario.getCpf());
                usuarioBanco.setEmail(usuario.getEmail());
                usuarioBanco.setSenha(usuario.getSenha());
                usuarioRepository.save(usuarioBanco);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/{id}/excluir")
    @Operation(
            summary = "Método de exclusão de usuário!",
            description = "Método responsável por alterar o status do usuário para EXCLUIDO através do ID"
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if (usuarioBanco != null) {
            usuarioBanco.setStatus(EnumStatusUsuario.EXCLUIDO);
            usuarioRepository.save(usuarioBanco);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}