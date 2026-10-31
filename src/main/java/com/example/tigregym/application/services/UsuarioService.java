package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.*;
import com.example.tigregym.domain.entities.EnumStatusUsuario;
import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.repository.UsuarioRepository;
import com.example.tigregym.domain.valueobject.CPF;
import com.example.tigregym.domain.valueobject.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
public class UsuarioService {

    @Value("${spring.secret}")
    private String secret;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponse validarUsuarioAutenticadoRetornaToken(LoginRequest request) {

        Email email = new Email(request.email());

        if (usuarioRepository.existsUsuarioByEmailAndSenha(email, request.senha())) {

            Usuario usuario = usuarioRepository
                    .findByEmailAndSenha(email, request.senha())
                    .orElse(null);

            var token = tokenService.gerarToken(usuario);
            return new LoginResponse(token);
        }

        return null;
    }

    public List<UsuarioResponse> listarTodosUsuariosTable() {

        var usuarioLogado = getUsuarioLogado();

        if (usuarioLogado.empresa_id() == null) {
            return usuarioRepository.findAll()
                    .stream()
                    .map(UsuarioResponse::new)
                    .toList();
        }

        return usuarioRepository.getUsuariosByEmpresa_Id(usuarioLogado.empresa_id())
                .stream()
                .map(UsuarioResponse::new)
                .toList();
    }

    public CriarAdminResponse criarAdmin(CriarAdminRequest criarAdminRequest) {

        if (!criarAdminRequest.secretKey().equals(secret)) {
            throw new IllegalArgumentException("Chave inválida!");
        }

        Usuario usuarioAdminSalvar = new Usuario(criarAdminRequest);
        usuarioRepository.save(usuarioAdminSalvar);

        return new CriarAdminResponse(
                usuarioAdminSalvar.getId(),
                "Usuário salvo com sucesso!"
        );
    }

        public UsuarioLogado getUsuarioLogado() {
            return (UsuarioLogado) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
        }

    public UsuarioResponse salvarUsuario(UsuarioRequest usuario, Long id) {

        if (id == 0L) {
            Usuario usuarioBanco = new Usuario(usuario);
            usuarioRepository.save(usuarioBanco);
            return new UsuarioResponse(usuarioBanco);
        }

        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        if (usuarioBanco != null) {
            usuarioBanco.setNome(usuario.nome());
            usuarioBanco.setCpf(new CPF(usuario.cpf()));
            usuarioBanco.setEmail(new Email(usuario.email()));
            usuarioBanco.setSenha(usuario.senha());

            // Se não enviar role na edição, mantém a role que já estava salva
            if (usuario.role() != null && !usuario.role().isBlank()) {
                usuarioBanco.setRole(usuario.role());
            }

            usuarioRepository.save(usuarioBanco);

            return new UsuarioResponse(usuarioBanco);
        }

        return null;
    }

    public UsuarioResponse buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        return new UsuarioResponse(usuario);
    }

    public boolean atualizarStatus(EnumStatusUsuario status, Long id) {

        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);

        if (usuarioBanco != null) {
            usuarioBanco.setStatus(status);
            usuarioRepository.save(usuarioBanco);
            return true;
        }

        return false;
    }

    public UsuarioResponse BuscarUsuariologado() {

        try {
            var usuarioLogado = getUsuarioLogado();
            return usuarioRepository.findById(usuarioLogado.id())
                    .stream()
                    .map(UsuarioResponse::new)
                    .findFirst()
                    .orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar usuário logado");
        }
    }
}
