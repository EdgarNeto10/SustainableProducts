package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pt.iade.sustainableProducts.models.Carrinho;
import pt.iade.sustainableProducts.models.CarrinhoProduto;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer> {
    Optional<Carrinho> findById(int id);

    
    @Modifying
    @Transactional

    @Query(value="Insert into carrinho_produtos "+
    "(carrprod_fk_carr ,carrprod_fk_prod) "+
    "values(:#{#carrprod.carrinho.carr_id}, "+
    ":#{#carrprod.produto.id})",
    nativeQuery=true)
    void addProdToCart(@Param("carrprod") CarrinhoProduto carrprod);



    @Modifying
    @Transactional
    // Query para zerar os produtos de um carrinho. 
    @Query(value=" DELETE FROM carrinho_produtos WHERE carrinho_produtos.carrprod_fk_carr = :id",nativeQuery=true )
    void deleteProductsCart(@Param("id") int id);

    @Modifying
    @Transactional
    // Query para apagar um produto de um carrinho. 
    @Query(value=" DELETE FROM carrinho_produtos WHERE carrinho_produtos.carrprod_fk_carr = :carrid AND carrinho_produtos.carrprod_fk_prod = :prodid",nativeQuery=true )
    void deleteProductCart(@Param("prodid") int prodid,@Param("carrid") int carrid);






}

