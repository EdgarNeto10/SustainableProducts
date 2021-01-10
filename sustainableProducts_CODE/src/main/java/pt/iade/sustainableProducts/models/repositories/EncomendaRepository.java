package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.sustainableProducts.models.Encomenda;


public interface EncomendaRepository extends CrudRepository<Encomenda, Integer> {
    Optional<Encomenda> findById(int id);

    @Modifying
    @Transactional
    @Query(value="Insert into encomendas "+
    "(Enc_data_Envio, Enc_local_Entrega, Enc_estado, Enc_preco_Porte, Enc_preco_Total) "+
    "values(:#{#enc.dataenvio}, "+
    ":#{#enc.localentrega}, "+
    ":#{#enc.estado}, "+
    ":#{#enc.precoporte}, "+
    ":#{#enc.precototal}) ",
    nativeQuery=true)
    void addProdsToOrder(@Param("enc") Encomenda enc);
}


