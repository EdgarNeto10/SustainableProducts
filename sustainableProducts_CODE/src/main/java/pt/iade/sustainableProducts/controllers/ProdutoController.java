package pt.iade.sustainableProducts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pt.iade.sustainableProducts.models.Produto;
import pt.iade.sustainableProducts.models.ProdutoRepository;


@RestController
@RequestMapping(path = "/api/produtos")

public class ProdutoController {

    private Logger logger = LoggerFactory.getLogger(ProdutoController.class);
 
    @Autowired
    private ProdutoRepository ProdutoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 


    public Iterable<Produto> getProdutos() {
        logger.info("Sending all products");
        return ProdutoRepository.findAll();
    }
}
