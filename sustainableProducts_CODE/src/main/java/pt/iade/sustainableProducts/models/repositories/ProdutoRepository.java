package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.sustainableProducts.models.Produto;
import pt.iade.sustainableProducts.models.Stock;

// Isto quer dizer q o repositorio gere produtos e o ID é um inteiro
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    Optional<Produto> findById(int id);
    Iterable<Produto> findByMarca(String marca);

    @Modifying
    @Transactional
    
    @Query(value="update stocks set Stock_quant_prod = :#{#stock.quantidade} where Stock_id = :idStock",nativeQuery=true )
    void updateStock(@Param("stock") Stock stock, @Param("idStock") int idStock);





   
}

