package pt.iade.sustainableProducts.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.CarrinhoProduto;

public interface CarrinhoProdutoRepository extends CrudRepository<CarrinhoProduto, Integer> {
    
 
    
}
