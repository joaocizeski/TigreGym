package com.example.tigregym.application.services;

import com.example.tigregym.application.DTOs.PlanoRequest;
import com.example.tigregym.application.DTOs.PlanoResponse;
import com.example.tigregym.domain.entities.EnumStatusPlano;
import com.example.tigregym.domain.entities.Plano;
import com.example.tigregym.domain.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<PlanoResponse> listarTodosPlanoTable() {
        return planoRepository.findAll()
                .stream()
                .map(PlanoResponse::new)
                .toList();
    }

    public PlanoResponse salvarPlano(PlanoRequest plano, Long id) {

        if (id == 0L) {
            Plano planoBanco = new Plano();
            planoBanco.setNome(plano.nome());
            planoBanco.setDescricao(plano.descricao());
            planoBanco.setValor(plano.valor());
            planoBanco.setDuracaoEmMeses(plano.duracaoEmMeses());

            planoRepository.save(planoBanco);

            return new PlanoResponse(planoBanco);
        }

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {
            planoBanco.setNome(plano.nome());
            planoBanco.setDescricao(plano.descricao());
            planoBanco.setValor(plano.valor());
            planoBanco.setDuracaoEmMeses(plano.duracaoEmMeses());

            planoRepository.save(planoBanco);

            return new PlanoResponse(planoBanco);
        }

        return null;
    }

    public PlanoResponse buscarPorId(Long id) {

        Plano plano = planoRepository.findById(id).orElse(null);

        if (plano == null) {
            return null;
        }

        return new PlanoResponse(plano);
    }

    public boolean atualizarStatus(EnumStatusPlano status, Long id) {

        Plano planoBanco = planoRepository.findById(id).orElse(null);

        if (planoBanco != null) {
            planoBanco.setStatus(status);
            planoRepository.save(planoBanco);
            return true;
        }

        return false;
    }
}
