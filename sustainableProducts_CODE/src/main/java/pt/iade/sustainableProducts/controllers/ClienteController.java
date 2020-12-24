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

import pt.iade.sustainableProducts.models.Cliente;
import pt.iade.sustainableProducts.models.repositories.ClienteRepository;


@RestController
@RequestMapping(path = "/api/clientes")

public class ClienteController {
    private Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Cliente> getClientes() {
        logger.info("Sending all clients");
        return clienteRepository.findAll();
    }


    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getCliente(@PathVariable int id) {
         logger.info("Sending client with id "+id);
         Optional<Cliente> _cliente=clienteRepository.findById(id);
         return _cliente.get();
    }

}