package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.PlanoResponse;
import com.example.tigregym.domain.entities.EnumStatusPlano;
import com.example.tigregym.domain.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<PlanoResponse> listarTodosPlanoTable() {

        // Busca os planos que ainda não foram excluídos
        return planoRepository.findByStatusNot(EnumStatusPlano.EXCLUIDO)
                .orElse(List.of())
                .stream()
                .map(PlanoResponse::new)
                .toList();
    }
}
