package com.example.tigregym.repository;

import com.example.tigregym.entidades.Plano;
import com.example.tigregym.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {



}
