package com.example.tigregym.domain.valueobject;

public record EnderecoViaCep(
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String uf
) {
}
