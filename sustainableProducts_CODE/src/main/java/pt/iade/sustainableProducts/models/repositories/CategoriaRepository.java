package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Optional<Categoria> findById(int id);
    
}
