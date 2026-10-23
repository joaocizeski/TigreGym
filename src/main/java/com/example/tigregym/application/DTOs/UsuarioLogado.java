package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.valueobject.CPF;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UsuarioLogado(
        Long id,
        String email,
        CPF cpf,
        String role,
        Collection<? extends GrantedAuthority> authorities
) {

    public UsuarioLogado(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getEmail().toString(),
                usuario.getCpf(),
                usuario.getRole(),
                usuario.getAuthorities()
        );
    }
}
