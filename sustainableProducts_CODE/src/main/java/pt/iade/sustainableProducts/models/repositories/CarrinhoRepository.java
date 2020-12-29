package pt.iade.sustainableProducts.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Carrinho;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer> {
    
}
