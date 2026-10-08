package com.example.tigregym.application.DTOs;

import com.example.tigregym.domain.entities.EnumStatusPlano;
import com.example.tigregym.domain.entities.Plano;

public record PlanoResponse(Long id, String nome, String descricao, String valor, Integer duracaoEmMeses, EnumStatusPlano status) {

    public PlanoResponse(Plano planoEntidade) {
        this(
                planoEntidade.getId(),
                planoEntidade.getNome(),
                planoEntidade.getDescricao(),
                planoEntidade.getValor(),
                planoEntidade.getDuracaoEmMeses(),
                planoEntidade.getStatus()
        );
    }
}
