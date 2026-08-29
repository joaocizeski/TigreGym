package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.CadastroRequest;
import com.example.tigregym.DTOs.LoginRequest;
import com.example.tigregym.entities.Usuario;
import com.example.tigregym.repository.UsuarioRepository;
import com.example.tigregym.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação",
        description = "Grupo de APIs responsável pela autenticação de usuários do sistema!")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    @Operation(description = "Método de login", summary = "Autenticação de usuário")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (usuarioRepository.existsUsuarioByEmailAndSenha(request.email(), request.senha())) {

            var token = tokenService.gerarToken(request.email());

            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.badRequest().body("Usuário ou senha Invalido!");
    }

    @PostMapping("/cadastro")
    @Operation(
            summary = "Método de cadastro de usuário!",
            description = "Método responsável por efetuar o cadastro de um novo usuário no sistema"
    )
    public ResponseEntity<?> cadastro(@RequestBody CadastroRequest request) {

        // Verifica se o email já está cadastrado
        if (usuarioRepository.existsUsuarioByEmail(request.email())) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado!");
        }

        // Cria um novo usuário
        Usuario usuario = new Usuario();

        usuario.setNome(request.nome());
        usuario.setCpf(request.cpf());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());

        // Salva o usuário no banco de dados
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

}