package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Carrinho;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer> {
    Optional<Carrinho> findById(int id);
}
