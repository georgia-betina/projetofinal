package br.univille.projetofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetofinal.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);
}