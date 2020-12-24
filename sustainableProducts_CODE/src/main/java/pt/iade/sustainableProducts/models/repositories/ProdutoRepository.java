package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Produto;

// Isto quer dizer q o repositorio gere produtos e o ID é um inteiro
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    Optional<Produto> findById(int id);
   
}
    

