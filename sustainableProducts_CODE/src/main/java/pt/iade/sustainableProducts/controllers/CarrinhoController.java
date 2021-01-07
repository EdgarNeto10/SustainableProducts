package pt.iade.sustainableProducts.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.sustainableProducts.controllers.results.SimpleResult;
import pt.iade.sustainableProducts.models.Carrinho;
import pt.iade.sustainableProducts.models.CarrinhoProduto;
import pt.iade.sustainableProducts.models.repositories.CarrinhoRepository;

@RestController
@RequestMapping(path = "/api/carrinhos")
public class CarrinhoController {
    private Logger logger = LoggerFactory.getLogger(CarrinhoController.class);

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Carrinho> getCarrinhos() {
        logger.info("Sending all categories");
        return carrinhoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrinho getCarrinho(@PathVariable int id) {
        logger.info("Sending cart with id " + id);
        Optional<Carrinho> _carrinho = carrinhoRepository.findById(id);
        return _carrinho.get();

    }

    @PostMapping(path = "/{produtoId}/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveProductInCart(@RequestBody CarrinhoProduto carrprod) {
        logger.info("Adding prod with id " + carrprod.getProduto().getId());
        carrinhoRepository.addProdToCart(carrprod);
        return new SimpleResult("Added prod with id " + carrprod.getProduto().getId(), carrprod);

    }

}
