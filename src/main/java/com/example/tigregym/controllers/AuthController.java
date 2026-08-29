package com.example.tigregym.controllers;

import com.example.tigregym.DTOs.CadastroRequest;
import com.example.tigregym.DTOs.EsqueciSenhaRequest;
import com.example.tigregym.DTOs.LoginRequest;
import com.example.tigregym.DTOs.RedefinirSenhaRequest;
import com.example.tigregym.entities.Usuario;
import com.example.tigregym.repository.UsuarioRepository;
import com.example.tigregym.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação",
        description = "Grupo de APIs responsável pela autenticação de usuários do sistema!")
public class AuthController {

// ------------------------------------------------------- // ------------------------------------------------------- //
    // ESTÁ ERRADO, ARRUMAR:

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    @Operation(description = "Método de login", summary = "Autenticação de usuário")
    public ResponseEntity<?> login( @RequestBody LoginRequest request){

        if (usuarioRepository.existsUsuarioByEmailAndSenha(request.email(), request.senha())) {

            var token = tokenService.gerarToken(request.email());
            return  ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
    }

}

// ------------------------------------------------------- // ------------------------------------------------------- //

  // PROVAVELMENTE ISSO TEM Q ARRUMAR PQ MUDOU TUDO:

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    // Permite criptografar a senha e conferir se uma senha está correta

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody CadastroRequest request) {

        // Verifica se já existe um usuário cadastrado com esse e-mail
        if (usuarioRepository.existsByUsuarioByEmailAndSenha(request.email(), request.senha())) {

            // Se já existir, retorna erro 400
            return ResponseEntity.badRequest().body("E-mail já cadastrado");
        }

        // Cria um novo objeto Usuario
        Usuario usuario = new Usuario();

        // Pega o nome recebido no JSON e coloca no usuário
        usuario.setNome(request.nome());

        // Pega o CPF recebido no JSON
        usuario.setCpf(request.cpf());

        // Pega o e-mail recebido no JSON
        usuario.setEmail(request.email());

        // Criptografa a senha antes de salvar no banco
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        // Salva o novo usuário no banco de dados
        usuarioRepository.save(usuario);

        // Retorna status 201, significando que o usuário foi criado
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário cadastrado com sucesso");
    }

    @PostMapping("/esqueci-senha")
    public ResponseEntity<?> esqueciSenha(
            @RequestBody EsqueciSenhaRequest request) {

        // Procura no banco o usuário pelo e-mail informado
        var usuarioOptional =
                usuarioRepository.findByEmail(request.email());

        // Se o e-mail não existir no banco
        if (usuarioOptional.isEmpty()) {

            // Retorna erro
            return ResponseEntity.badRequest()
                    .body("E-mail não encontrado");
        }

        // Pega o usuário encontrado
        Usuario usuario = usuarioOptional.get();

        // Cria um token aleatório para recuperação da senha
        String resetToken = UUID.randomUUID().toString();

        // Salva o token no usuário
        usuario.setResetToken(resetToken);

        // Define que esse token só poderá ser usado durante 15 minutos
        usuario.setResetTokenExpiracao(
                LocalDateTime.now().plusMinutes(15)
        );

        // Salva as alterações no banco
        usuarioRepository.save(usuario);

        // Por enquanto retorna o token pelo Swagger
        // Futuramente esse token pode ser enviado por e-mail
        return ResponseEntity.ok(resetToken);
    }

    @PostMapping("/redefinir-senha")
    public ResponseEntity<?> redefinirSenha(
            @RequestBody RedefinirSenhaRequest request) {

        // Procura no banco quem possui o token informado
        var usuarioOptional =
                usuarioRepository.findByResetToken(request.token());

        // Se nenhum usuário tiver esse token
        if (usuarioOptional.isEmpty()) {

            // O token é inválido
            return ResponseEntity.badRequest()
                    .body("Token inválido");
        }

        // Pega o usuário encontrado pelo token
        Usuario usuario = usuarioOptional.get();

        // Verifica se o token não possui data de expiração
        // ou se os 15 minutos já passaram
        if (usuario.getResetTokenExpiracao() == null ||
                usuario.getResetTokenExpiracao()
                        .isBefore(LocalDateTime.now())) {

            return ResponseEntity.badRequest()
                    .body("Token expirado");
        }

        // Criptografa a nova senha e substitui a senha antiga
        usuario.setSenha(
                passwordEncoder.encode(request.novaSenha())
        );

        // Apaga o token depois que ele foi utilizado
        usuario.setResetToken(null);

        // Apaga também a data de validade do token
        usuario.setResetTokenExpiracao(null);

        // Salva a nova senha no banco
        usuarioRepository.save(usuario);

        // Informa que a alteração funcionou
        return ResponseEntity.ok("Senha alterada com sucesso");
    }

}