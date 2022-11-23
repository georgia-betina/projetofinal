package br.univille.projetofinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinal.entity.Fornecedor;
import br.univille.projetofinal.repository.FornecedorRepository;
import br.univille.projetofinal.service.FornecedorService;

@Service
public class FornecedorServiceImpl
implements FornecedorService{

    @Autowired
    private FornecedorRepository repositorio;

    @Override
    public List<Fornecedor> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return repositorio.save(fornecedor);
        
    }

    @Override
    public Fornecedor findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Fornecedor();
    }
    @Override
    public void delete(long id){
        repositorio.deleteById(id);
    }

}