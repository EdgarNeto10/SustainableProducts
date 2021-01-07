package pt.iade.sustainableProducts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="carrinhos")


public class Carrinho {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name="carr_id") private int carr_id;
    @Column(name= "Carr_quant_prod") private int Carr_quant_prod;
    @Column(name= "Carr_preco_total") private double Carr_preco_total;

    @OneToMany @JoinColumn(name = "carrprod_fk_carr")  @JsonIgnoreProperties("carrinho") private List<CarrinhoProduto> carrinhoprodutos;
    
    public Carrinho() {}

    public int getCarr_id() {
        return carr_id;
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

    public void setCarr_preco_total(double carr_preco_total) {
        Carr_preco_total = carr_preco_total;
    }

    public List<CarrinhoProduto> getCarrinhoprodutos() {
        return carrinhoprodutos;
    }


   

 
   

  

    
}
