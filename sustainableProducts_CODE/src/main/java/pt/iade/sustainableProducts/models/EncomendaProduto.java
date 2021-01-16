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
@Table(name ="encomenda_produtos")
@IdClass(EncProdId.class)


public class EncomendaProduto {
    @Id @Column(name ="encpro_fk_enc")
    
    @JsonIgnore private int enc_id;
    
    @ManyToOne @MapsId("enc_id") @JoinColumn(name="encpro_fk_enc")
    @JsonIgnoreProperties("encomendaprodutos") 
    private Encomenda encomenda;

    @Id @Column(name ="encpro_fk_prod")
    
    @JsonIgnore private int prod_id;
    
    @ManyToOne @MapsId("prod_id") @JoinColumn(name="encpro_fk_prod")
    @JsonIgnoreProperties("encomendaprodutos")
    private Produto produto;

    

    public EncomendaProduto(){}

    public int getEnc_id() {
        return enc_id;
    }



    public Encomenda getEncomenda() {
        return encomenda;
    }

    
    public int getProd_id() {
        return prod_id;
    }

 

    public Produto getProduto() {
        return produto;
    }


    
}
