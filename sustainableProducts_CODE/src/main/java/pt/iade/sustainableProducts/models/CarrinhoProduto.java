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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="carrinho_produtos")
@IdClass(CarrProdId.class)



public class CarrinhoProduto {
    @Id @Column(name ="carrprod_fk_carr")
    
    @JsonIgnore private int carr_id;
    @ManyToOne @MapsId("carr_id") @JoinColumn(name="carrprod_fk_carr")
    @JsonIgnoreProperties("carrinhoprodutos") 
    private Carrinho carrinho;

    @Id @Column(name ="carrprod_fk_prod")
    
    @JsonIgnore private int prod_id;
    @ManyToOne @MapsId("prod_id") @JoinColumn(name="carrprod_fk_prod")
    @JsonIgnoreProperties("carrinhoprodutos")
    private Produto produto;

    public CarrinhoProduto() {}

    public int getCarr_id() {
        return carr_id;
    }

   

    public Carrinho getCarrinho() {
        return carrinho;
    }

  

    public int getProd_id() {
        return prod_id;
    }

  

    public Produto getProduto() {
        return produto;
    }

    
    


    
}
