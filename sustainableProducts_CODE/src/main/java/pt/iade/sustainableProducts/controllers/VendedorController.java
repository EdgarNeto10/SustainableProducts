package pt.iade.sustainableProducts.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.sustainableProducts.models.Vendedor;
import pt.iade.sustainableProducts.models.repositories.VendedorRepository;


@RestController
@RequestMapping(path = "/api/vendedores")

public class VendedorController {
    private Logger logger = LoggerFactory.getLogger(VendedorController.class);

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Vendedor> getClientes() {
        logger.info("Sending all vendedores");
        return vendedorRepository.findAll();
    }


    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vendedor getVendedor(@PathVariable int id) {
         logger.info("Sending vendedor with id "+id);
         Optional<Vendedor> _vendedor=vendedorRepository.findById(id);
         return _vendedor.get();
    }

}