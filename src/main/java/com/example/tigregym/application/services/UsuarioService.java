package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.LoginRequest;
import com.example.tigregym.application.DTOs.LoginResponse;
import com.example.tigregym.application.DTOs.UsuarioResponse;
import com.example.tigregym.domain.entities.EnumStatusUsuario;
import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired TokenService tokenService;

    public LoginResponse validarUsuarioAutenticadoRetornaToken(LoginRequest request) {

        if (usuarioRepository.existsUsuarioByEmailAndSenha(request.email(), request.senha())) {

            var token = tokenService.gerarToken(request.email());
            return new LoginResponse(token);
        }
        return null;
    }


    public List<UsuarioResponse> listarTodosUsuarioTable(){

        // Busca os usuários que ainda não foram excluídos
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponse::new)
                .toList();

    }


}
