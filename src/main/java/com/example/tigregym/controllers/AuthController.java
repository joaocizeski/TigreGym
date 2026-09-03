package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.CadastroRequest;
import com.example.tigregym.DTOs.LoginRequest;
import com.example.tigregym.DTOs.RecuperarSenhaRequest;
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

    @PostMapping("/recuperar-senha")
    @Operation(
            summary = "Método de recuperação de senha!",
            description = "Método responsável por recuperar a senha de um usuário"
    )
    public ResponseEntity<?> recuperarSenha(@RequestBody RecuperarSenhaRequest request) {

        Usuario usuarioBanco = usuarioRepository
                .findByEmailAndCpf(request.email(), request.cpf())
                .orElse(null);

        if (usuarioBanco != null) {

            // Verifica se a nova senha é diferente da senha atual
            if (usuarioBanco.getSenha().equals(request.novaSenha())) {
                return ResponseEntity.badRequest()
                        .body("A nova senha não pode ser igual à senha atual!");
            }

            // Altera a senha do usuário
            usuarioBanco.setSenha(request.novaSenha());

            usuarioRepository.save(usuarioBanco);

            return ResponseEntity.ok("Senha alterada com sucesso!");
        }

        return ResponseEntity.badRequest().body("E-mail ou CPF inválido!");
    }
}