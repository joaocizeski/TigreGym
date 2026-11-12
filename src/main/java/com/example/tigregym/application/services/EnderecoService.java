package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.EnderecoResponse;
import com.example.tigregym.domain.interfaces.IViaCepExternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.tigregym.application.interfaces.IEnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService {

    @Autowired
    private IViaCepExternalRepository viaCepExternalRepository;

   public EnderecoResponse BuscarEndereco(String cep){

        var enderecoCompleto = viaCepExternalRepository.buscarEnderecoViaCepPorCep(cep);

        return new EnderecoResponse( enderecoCompleto.cep(),
                enderecoCompleto.logradouro(),
                enderecoCompleto.bairro(),
                enderecoCompleto.cidade(),
                enderecoCompleto.uf());
   }

}
