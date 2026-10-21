package com.example.tigregym.domain.entities;

import jakarta.persistence.Column;
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
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String descricao;

    public String valor;

    @Column(name = "duracao_meses")
    public Integer duracaoEmMeses;

    public EnumStatusPlano status = EnumStatusPlano.ATIVO;

    public void setDuracaoEmMeses(Integer duracaoEmMeses) {
        if (duracaoEmMeses == null || duracaoEmMeses < 1) {
            throw new IllegalArgumentException("A duração do plano deve ser maior que zero!");
        }

        this.duracaoEmMeses = duracaoEmMeses;
    }
}
