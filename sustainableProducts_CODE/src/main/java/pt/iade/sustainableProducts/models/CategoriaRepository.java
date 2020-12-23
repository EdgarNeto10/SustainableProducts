package pt.iade.sustainableProducts.models;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Optional<Categoria> findById(int id);
    
}
