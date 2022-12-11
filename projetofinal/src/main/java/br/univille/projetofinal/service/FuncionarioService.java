package br.univille.projetofinal.service;

import java.util.List;

import br.univille.projetofinal.entity.Funcionario;

public interface FuncionarioService{
    List<Funcionario> getAll();
    Funcionario save(Funcionario funcionario);
    Funcionario findById(long id);   
    void delete(long id); 
    List<Funcionario> findByLoginAndSenha(String login, String senha);    
}