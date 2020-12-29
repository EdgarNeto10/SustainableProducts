package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Vendedor;



public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
    Optional<Vendedor> findById(int id);
    
}