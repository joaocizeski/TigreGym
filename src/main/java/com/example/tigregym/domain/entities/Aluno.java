package com.example.tigregym.domain.entities;

import com.example.tigregym.domain.valueobject.CPF;
import com.example.tigregym.domain.valueobject.Email;
import com.example.tigregym.domain.valueobject.Telefone;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    @Embedded
    public CPF cpf;

    public LocalDate dataNascimento;

    @Embedded
    public Telefone telefone;

    @Embedded
    public Email email;

    public EnumStatusAluno status = EnumStatusAluno.ATIVO;
}
