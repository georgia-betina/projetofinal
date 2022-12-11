package br.univille.projetofinal.service;

import java.util.List;

import br.univille.projetofinal.entity.Fornecedor;

public interface FornecedorService{
    List<Fornecedor> getAll();
    Fornecedor save(Fornecedor fornecedor);
    Fornecedor findById(long id);   
    void delete(long id);
    List<Fornecedor> findByLoginAndSenha(String login, String senha);    
}