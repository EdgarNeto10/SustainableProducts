package pt.iade.sustainableProducts.models.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.sustainableProducts.models.Encomenda;
import pt.iade.sustainableProducts.models.EncomendaProduto;


public interface EncomendaRepository extends CrudRepository<Encomenda, Integer> {
    Optional<Encomenda> findById(int id);

    @Modifying
    @Transactional
    @Query(value="Insert into encomendas "+
    "(Enc_data_Envio, Enc_local_Entrega, Enc_estado, Enc_preco_Porte, Enc_preco_Total, Enc_cli_id) "+
    "values(:#{#enc.dataenvio}, "+
    ":#{#enc.localentrega}, "+
    ":#{#enc.estado.ordinal()}, "+
    ":#{#enc.precoporte}, "+
    ":#{#enc.precototal}, "+
    ":#{#enc.cliid})",
    nativeQuery=true)
    void addProdsToOrder(@Param("enc") Encomenda enc);

    

    @Modifying
    @Transactional

    @Query(value="Insert into encomenda_produtos "+
    "(encpro_fk_enc ,encpro_fk_prod) "+
    "values(:#{#encprod.encomenda.id}, "+
    ":#{#encprod.produto.id})",
    nativeQuery=true)
    void addProdToEnc(@Param("encprod") EncomendaProduto encprod);


   @Modifying
    @Transactional
    
    @Query(value="update encomendas set Enc_estado = :#{#encestado.estado.ordinal()} where enc_id = :id",nativeQuery=true )
    void updateEncEstado(@Param("encestado") Encomenda encestado, @Param("id") int id);
    





}


