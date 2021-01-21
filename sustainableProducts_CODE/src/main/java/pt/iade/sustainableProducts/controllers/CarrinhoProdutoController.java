package pt.iade.sustainableProducts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.sustainableProducts.controllers.results.SimpleResult;
import pt.iade.sustainableProducts.models.CarrinhoProduto;
import pt.iade.sustainableProducts.models.repositories.CarrinhoProdutoRepository;

@RestController
@RequestMapping(path = "/api/carrinhosprodutos")
public class CarrinhoProdutoController {
    private Logger logger = LoggerFactory.getLogger(CarrinhoProdutoController.class);

    @Autowired
    private CarrinhoProdutoRepository carrinhoprodutoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<CarrinhoProduto> getCarrinhos() {
        logger.info("Sending all categories");
        return carrinhoprodutoRepository.findAll();
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE )
    public SimpleResult deleteProductsCart(@PathVariable int id){
    logger.info("Deleting products in cart ");
    // No verification to see if it exists
    carrinhoprodutoRepository.deleteById(id);;
    return new SimpleResult("Deleted products)", null);
}

    
    
}
