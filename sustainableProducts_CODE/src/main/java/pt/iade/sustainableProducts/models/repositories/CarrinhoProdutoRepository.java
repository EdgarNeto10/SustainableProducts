package pt.iade.sustainableProducts.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.CarrinhoProduto;

public interface CarrinhoProdutoRepository extends CrudRepository<CarrinhoProduto, Integer> {
    
}
