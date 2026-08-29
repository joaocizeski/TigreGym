package com.example.tigregym.repository;

import com.example.tigregym.entities.EnumStatusUsuario;
import com.example.tigregym.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<List<Usuario>> findByStatusNot(EnumStatusUsuario status);

    // Busca um usuário pelo e-mail
    Optional<Usuario> findByEmail(String email);

    // Busca o usuário que possui determinado token de recuperação
    Optional<Usuario> findByResetToken(String resetToken);

    // Verifica se já existe algum usuário com esse e-mail
    boolean existsUsuarioByEmailAndSenha(String email, String senha);

}
