package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.Usuario;
import com.example.tigregym.domain.valueobject.CPF;

public record UsuarioLogado(Long id, String email, CPF cpf,
                            Long empresa_id,
                            java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {

    public UsuarioLogado(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getCpf(),
                1L,
                usuario.getAuthorities()
        );
    }
}
