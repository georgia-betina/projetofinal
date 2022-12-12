package br.univille.projetofinal.service;

import java.util.List;

import br.univille.projetofinal.entity.Produto;

public interface ProdutoService{
    List<Produto> getAll();
    Produto save(Produto produto);
    Produto findById(long id);
    void delete(long id);
    List<Produto> findByFornecedorId(long id);
    List<Produto> findTop5ByOrderByDataInclusaoAsc();
    List<Produto> findByDataFimGreaterThan(String dataFim);
}