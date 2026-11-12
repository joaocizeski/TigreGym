package com.example.tigregym.application.interfaces;

import com.example.tigregym.application.DTOs.EnderecoResponse;

public interface IEnderecoService {

    EnderecoResponse BuscarEndereco(String cep);
}
