package com.example.tigregym.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    private EnumStatusUsuario status;

    // Token temporário usado para permitir a troca de senha
    public String resetToken;

    // Data e hora em que o token de recuperação deixa de ser válido
    public LocalDateTime resetTokenExpiracao;

}