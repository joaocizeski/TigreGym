package com.example.tigregym.application.interfaces;

import com.example.tigregym.application.DTOs.UsuarioLogado;
import com.example.tigregym.domain.entities.Usuario;

public interface ITokenService {

    String gerarToken(Usuario usuario);

    UsuarioLogado verificarToken(String token);
}
