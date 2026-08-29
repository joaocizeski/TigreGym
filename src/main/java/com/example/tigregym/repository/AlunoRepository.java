package com.example.tigregym.repository;

import com.example.tigregym.entities.Aluno;
import com.example.tigregym.entities.EnumStatusAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<List<Aluno>> findByStatusNot(EnumStatusAluno status);

}
