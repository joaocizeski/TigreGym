package com.example.tigregym.repository;

import com.example.tigregym.entidades.Matricula;
import com.example.tigregym.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {



}
