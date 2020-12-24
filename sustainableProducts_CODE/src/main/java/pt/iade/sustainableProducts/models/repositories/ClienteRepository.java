package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findById(int id);
    
}
