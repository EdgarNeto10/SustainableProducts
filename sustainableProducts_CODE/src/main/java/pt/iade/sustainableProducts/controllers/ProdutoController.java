package pt.iade.sustainableProducts.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.sustainableProducts.controllers.results.SimpleResult;
import pt.iade.sustainableProducts.models.Produto;
import pt.iade.sustainableProducts.models.Stock;
import pt.iade.sustainableProducts.models.repositories.ProdutoRepository;

@RestController
@RequestMapping(path = "/api/categorias/produtos")

public class ProdutoController {

    private Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Produto> getProdutos() {
        logger.info("Sending all products");
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto getProduto(@PathVariable int id) {
        logger.info("Sending produto with id " + id);
        Optional<Produto> _produto = produtoRepository.findById(id);
        return _produto.get();

    }

    @GetMapping(path = "/{text:[^0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE )
    public Iterable<Produto> getProdutoM(
    @PathVariable(value = "text") String text) {
    logger.info("Produto with marca "+text);
    return produtoRepository.findByMarca(text);
    }


    // Update o Stock de cada produto em foi feita uma encomenda 
    @PutMapping(path = "/{id:[0-9]+}/stocks/{idStock:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  SimpleResult updateStock(@RequestBody Stock stock, @PathVariable int idStock) { 
        logger.info("updating stock with id " + idStock);
        produtoRepository.updateStock(stock, idStock);
        return new SimpleResult("Added enc with id ", idStock);

    
    }



}
