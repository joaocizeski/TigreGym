package com.example.tigregym.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String token;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataExpiracao;

    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Token(String token, Usuario usuario, LocalDateTime dataExpiracao) {
        this.setToken(token);
        this.setUsuario(usuario);
        this.setDataCadastro(LocalDateTime.now());
        this.setDataExpiracao(dataExpiracao);
        this.setAtivo(true);
    }

    public boolean estaValido() {
        return Boolean.TRUE.equals(ativo)
                && dataExpiracao != null
                && dataExpiracao.isAfter(LocalDateTime.now());
    }
}
