package pt.iade.sustainableProducts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="vendedor_encomendas")
@IdClass(VendCatId.class)

public class VendedorEncomendas {
    @Id @Column(name ="vend_enc_fk_vend")
    
    @JsonIgnore private int vend_id;
    
    @ManyToOne @MapsId("vend_id") @JoinColumn(name="vend_enc_fk_vend")
    @JsonIgnoreProperties("vend_encomendas") 
    private Vendedor vendedor;

    @Id @Column(name ="vend_enc_fk_enc")
    
    @JsonIgnore private int enc_id;
    
    @ManyToOne @MapsId("enc_id") @JoinColumn(name="vend_enc_fk_enc")
    @JsonIgnoreProperties("vend_encomendas") 
    private Encomenda encomenda;

    public VendedorEncomendas(){}

    public int getVend_id() {
        return vend_id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public int getEnc_id() {
        return enc_id;
    }

    

    public Encomenda getEncomenda() {
        return encomenda;
    }


   
    
    
}
