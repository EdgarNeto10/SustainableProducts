package pt.iade.sustainableProducts.models;

import org.springframework.data.repository.CrudRepository;

// Isto quer dizer q o repositorio gere produtos e o ID é um inteiro
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
   
}
    

