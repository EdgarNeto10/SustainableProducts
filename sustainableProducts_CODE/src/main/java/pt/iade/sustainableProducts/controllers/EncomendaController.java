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
import pt.iade.sustainableProducts.models.Encomenda;
import pt.iade.sustainableProducts.models.EncomendaProduto;
import pt.iade.sustainableProducts.models.EstadoEncomenda;
import pt.iade.sustainableProducts.models.repositories.EncomendaRepository;

@RestController
@RequestMapping(path = "/api/clientes/encomendas")

public class EncomendaController {

    private Logger logger = LoggerFactory.getLogger(EncomendaController.class);

    @Autowired
    private EncomendaRepository encomendaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Encomenda> getEncomendas() {
        logger.info("Sending all encomendas");
        return encomendaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Encomenda getEncomenda(@PathVariable int id) {
        logger.info("Sending encomenda with id " + id);
        Optional<Encomenda> _encomenda = encomendaRepository.findById(id);
        return _encomenda.get();

    }

    /*@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) // mesmo caminho q o find all
    public Encomenda saveOrder(@RequestBody Encomenda encomenda) {
        Encomenda savedOrder = encomendaRepository.save(encomenda);
        logger.info("Saving encomenda with id " + savedOrder.getEnc_id());
        return savedOrder;
    }*/

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveOrder(@RequestBody Encomenda enc) {
        logger.info("Adding encomenda with id " + enc.getId());
        encomendaRepository.addProdsToOrder(enc);
        return new SimpleResult("Added encomenda with id " + enc.getId(), enc);

    }

    @PostMapping(path = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveProductInCart(@RequestBody EncomendaProduto encprod) {
        logger.info("Adding prod with id " + encprod.getProduto().getId());
        encomendaRepository.addProdToEnc(encprod);
        return new SimpleResult("Added prod with id " ,encprod);

    }

}
