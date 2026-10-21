package com.example.tigregym.domain.entities;

import com.example.tigregym.application.DTOs.CriarAdminRequest;
import com.example.tigregym.application.DTOs.UsuarioRequest;
import com.example.tigregym.domain.valueobject.CPF;
import com.example.tigregym.domain.valueobject.Email;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private CPF cpf;

    @Embedded
    private Email email;

    private String senha;

    private String role = "ROLE_USER";

    private EnumStatusUsuario status = EnumStatusUsuario.ATIVO;

    public Usuario(CriarAdminRequest criarAdminRequest) {
        this.setCpf(new CPF(criarAdminRequest.cpf()));
        this.setNome(criarAdminRequest.nome());
        this.setSenha(criarAdminRequest.senha());
        this.setEmail(new Email(criarAdminRequest.email()));
        this.setRole("ROLE_ADMIN");
    }

    public Usuario(UsuarioRequest usuario) {
        this.setCpf(new CPF(usuario.cpf()));
        this.setNome(usuario.nome());
        this.setSenha(usuario.senha());
        this.setEmail(new Email(usuario.email()));
        this.setRole("ROLE_USER");
    }
}
