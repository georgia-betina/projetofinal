package br.univille.projetofinal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.univille.projetofinal.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    List<Fornecedor> findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);
}