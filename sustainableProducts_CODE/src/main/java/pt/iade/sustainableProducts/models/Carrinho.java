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
@Table(name ="carrinhos")
@IdClass(CarrinhoId.class)

public class Carrinho {
    @Id @Column(name ="Carr_fk_enc")
    
    @JsonIgnore private int Enc_id;
    
    @ManyToOne @MapsId("Enc_id") @JoinColumn(name="Carr_fk_enc")
    @JsonIgnoreProperties("carrinhos") 
    private Encomenda encomenda;


    @Id @Column(name ="Carr_fk_prod")
    
    @JsonIgnore private int prod_id;
    
    @ManyToOne @MapsId("prod_id") @JoinColumn(name="Carr_fk_prod")
    @JsonIgnoreProperties("carrinhos")
    private Produto produto;

    @Column(name= "Carr_quant_prod") private int Carr_quant_prod;
    @Column(name= "Carr_preco_total") private double Carr_preco_total;

    public int getEnc_id() {
        return Enc_id;
    }

    public void setEnc_id(int enc_id) {
        Enc_id = enc_id;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCarr_quant_prod() {
        return Carr_quant_prod;
    }

    public void setCarr_quant_prod(int carr_quant_prod) {
        Carr_quant_prod = carr_quant_prod;
    }

    public double getCarr_preco_total() {
        return Carr_preco_total;
    }

    public void setCarr_precoTotal(double carr_precoTotal) {
        Carr_preco_total = carr_precoTotal;
    }

    




    
}
