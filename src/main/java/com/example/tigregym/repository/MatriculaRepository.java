package com.example.tigregym.repository;

import com.example.tigregym.entities.EnumStatusMatricula;
import com.example.tigregym.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Optional<List<Matricula>> findByStatusNot(EnumStatusMatricula status);

}
