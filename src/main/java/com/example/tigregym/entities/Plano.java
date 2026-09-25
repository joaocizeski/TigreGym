package com.example.tigregym.entities;

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

    // Usa uma nova coluna numérica para não conflitar com a coluna antiga de data
    @Column(name = "duracao_meses")
    public Integer duracaoEmMeses;

    public EnumStatusPlano status = EnumStatusPlano.ATIVO;
}
