package pt.iade.sustainableProducts.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.sustainableProducts.controllers.results.SimpleResult;
import pt.iade.sustainableProducts.models.Carrinho;
import pt.iade.sustainableProducts.models.CarrinhoProduto;
import pt.iade.sustainableProducts.models.exceptions.NotAcceptableException;
import pt.iade.sustainableProducts.models.repositories.CarrinhoRepository;

@RestController
@RequestMapping(path = "/api/carrinhos")
public class CarrinhoController {
    private Logger logger = LoggerFactory.getLogger(CarrinhoController.class);

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    
  //A pegar todos os carrinhos presentes na plataforma
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Carrinho> getCarrinhos() {
        logger.info("Sending all carrinhos");
        return carrinhoRepository.findAll();
    }


    // A pegar um determinadado carinho atribuido a um cliente 
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrinho getCarrinho(@PathVariable int id) {
        logger.info("Sending cart with id " + id);
        Optional<Carrinho> _carrinho = carrinhoRepository.findById(id);
        return _carrinho.get();

    }

  
    //Add um produto ao carrinho.
    @PostMapping(path = "/{carrinhoId}/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveProductInCart(@RequestBody CarrinhoProduto carrprod) {
    
        //A verificar se o produto tem Stock disponível antes de adcionar o mesmo ao carrinho.
        if(carrprod.getProduto().getStock().getDisponivel()){

            logger.info("Adding prod with id " + carrprod.getProduto().getId());
            carrinhoRepository.addProdToCart(carrprod);
            return new SimpleResult("Added prod with id " + carrprod.getProduto().getId(), carrprod);
        
        } else {
            throw new NotAcceptableException(carrprod.getProduto().getId(), "Produto", carrprod.getProduto().getNome());
         }
 
    }


     //Apagar todos os produtos de um carrinho, tendo como parametro o id do carrinho.
    @DeleteMapping(path = "{id:[0-9]+}/produtos/", produces = MediaType.APPLICATION_JSON_VALUE )
    public SimpleResult deleteProductsCart(@PathVariable int id){
        logger.info("Deleting all products in cart"+ id);
        // No verification to see if it exists
        carrinhoRepository.deleteProductsCart(id);
        return new SimpleResult("Deleted products", null);
    }


    //Apagar um produto de um carrinho, tendo como parametro o id do carrinho e do produto selecionado. 
    @DeleteMapping(path = "{carrid:[0-9]+}/produtos/{prodid:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE )
    
    public SimpleResult deleteProductCart(@PathVariable int prodid,@PathVariable int carrid){
        logger.info("Deleting product in cart with id"+prodid );
        // No verification to see if it exists
        carrinhoRepository.deleteProductCart(prodid,carrid);
        return new SimpleResult("Deleted product", null);
    }


}
