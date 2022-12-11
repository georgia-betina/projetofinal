package br.univille.projetofinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinal.entity.Funcionario;
import br.univille.projetofinal.repository.FuncionarioRepository;
import br.univille.projetofinal.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl
implements FuncionarioService{

    @Autowired
    private FuncionarioRepository repositorio;

    @Override
    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
        
    }

    @Override
    public Funcionario findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Funcionario();
    }
    @Override
    public void delete(long id){
        repositorio.deleteById(id);
    }

    @Override
    public List<Funcionario> findByLoginAndSenha(String login, String senha) {
        return repositorio.findByLoginAndSenha(login, senha);
    }
}