package com.example.tigregym.repository;

import com.example.tigregym.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {



}
