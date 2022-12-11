package br.univille.projetofinal.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.univille.projetofinal.entity.Funcionario;
import br.univille.projetofinal.repository.FuncionarioRepository;

@Component
public class funcionarioSeed implements CommandLineRunner{
    @Autowired
    FuncionarioRepository repo;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (repo.count() == 0) {
            Funcionario func = new Funcionario();
            func.setLogin("admin");
            func.setSenha("admin");
            repo.save(func);
        }
    }
}

