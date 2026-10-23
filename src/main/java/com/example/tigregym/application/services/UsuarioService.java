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

import java.util.List;

@Service
public class UsuarioService {

    @Value("${spring.secret}")
    private String secret;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public UsuarioLogado getUsuarioLogado(){
        return (UsuarioLogado) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public LoginResponse validarUsuarioAutenticadoRetornaToken(LoginRequest request) {

        Email email = new Email(request.email());

        if (usuarioRepository.existsUsuarioByEmailAndSenha(email, request.senha())) {
            var token = tokenService.gerarToken(request.email());
            return new LoginResponse(token);
        }

        return null;
    }

    public List<UsuarioResponse> listarTodosUsuarioTable() {
        return usuarioRepository.findByStatusNot(EnumStatusUsuario.EXCLUIDO)
                .orElse(List.of())
                .stream()
                .map(UsuarioResponse::new)
                .toList();
    }

    public CriarAdminResponse criarAdmin(CriarAdminRequest criarAdminRequest) {

        if (!criarAdminRequest.secretKey().equals(secret)) {
            return new CriarAdminResponse(0L, "Usuario salvo com sucesso!");
        }

        Usuario usuarioAdminSalvar = new Usuario(criarAdminRequest);
        usuarioRepository.save(usuarioAdminSalvar);

        return new CriarAdminResponse(usuarioAdminSalvar.getId(), "Usuário Salvo com Sucesso!");
    }

    public UsuarioResponse salvarUsuario(UsuarioRequest usuario, Long id) {

        var usuarioLogado = getUsuarioLogado();

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
            usuarioBanco.setEmpresa_id(usuarioLogado.empresa_id());

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


}
