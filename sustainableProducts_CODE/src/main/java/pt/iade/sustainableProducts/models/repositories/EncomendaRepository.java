package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.sustainableProducts.models.Encomenda;


public interface EncomendaRepository extends CrudRepository<Encomenda, Integer> {
    Optional<Encomenda> findById(int id);

}
