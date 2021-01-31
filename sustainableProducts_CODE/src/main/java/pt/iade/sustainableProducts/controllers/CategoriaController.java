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

import pt.iade.sustainableProducts.models.Categoria;
import pt.iade.sustainableProducts.models.repositories.CategoriaRepository;


@RestController
@RequestMapping(path = "/api/produtos/categorias")

public class CategoriaController {
    private Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)


    // A pegar todas as categorias
    public Iterable<Categoria> getCategorias() {
        logger.info("Sending all categories");
        return categoriaRepository.findAll();
    }

    // A pegar uma determinada categoria
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria getCategoria(@PathVariable int id) {
         logger.info("Sending category with id "+id);
         Optional<Categoria> _categoria=categoriaRepository.findById(id);
         return _categoria.get();
    }

}

