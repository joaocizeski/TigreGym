package com.example.tigregym.repository;

import com.example.tigregym.entities.EnumStatusPlano;
import com.example.tigregym.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    Optional<List<Plano>> findByStatusNot(EnumStatusPlano status);

}
