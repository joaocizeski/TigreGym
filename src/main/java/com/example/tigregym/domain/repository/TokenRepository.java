package com.example.tigregym.domain.repository;

import com.example.tigregym.domain.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findFirstByTokenOrderByIdDesc(String token);
}
