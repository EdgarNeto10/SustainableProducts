package pt.iade.sustainableProducts.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity

@Table(name ="carrinhos")


public class Carrinho {
   
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name="carr_id") private int carr_id;
  
    @OneToMany @JoinColumn(name = "carrprod_fk_carr")  @JsonIgnoreProperties("carrinho") 
    private List<CarrinhoProduto> carrinhoprodutos= new ArrayList<>();

    
    public Carrinho() {}

    public int getCarr_id() {
        return carr_id;
    }

    public List<CarrinhoProduto> getCarrinhoprodutos() {
        return carrinhoprodutos;
    }


    //Método para calcular o preço total dos produtos no carrinho
    public  double getSomaTotal() {
        double total=0;
        for(CarrinhoProduto prods: carrinhoprodutos){
            total += prods.getProduto().getPreco();
        }
        return  total;
    }

     //Método para calcular a quantidade de produtos no carrinho 
     public  int getQuantidadeProds() {
        return carrinhoprodutos.size();
    }


    
    

}
