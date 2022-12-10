package br.univille.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD

=======
>>>>>>> 3a472ec (alteracoes)
import br.univille.projetofinal.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}