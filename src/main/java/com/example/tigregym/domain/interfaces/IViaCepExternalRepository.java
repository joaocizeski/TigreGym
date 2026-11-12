package com.example.tigregym.domain.interfaces;

import com.example.tigregym.domain.valueobject.EnderecoViaCep;

public interface IViaCepExternalRepository {

    EnderecoViaCep buscarEnderecoViaCepPorCep(String cep);

}
