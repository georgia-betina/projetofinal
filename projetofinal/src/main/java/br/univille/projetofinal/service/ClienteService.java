package br.univille.projetofinal.service;

import java.util.List;

import br.univille.projetofinal.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente save (Cliente cliente);
    Cliente findById (long id);
    List <Cliente> findByNome (String nome);
}
