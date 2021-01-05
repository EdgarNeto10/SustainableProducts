package pt.iade.sustainableProducts.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Produtos")

public class Produto {
    
        @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY) 
    
    private int prod_id;
    private String prod_nome;
    private double prod_preco;
    private String prod_marca;
    private String prod_descricao;

    @OneToMany @JoinColumn(name="catprod_fk_prod")
    @JsonIgnoreProperties("produto")
    private List<CategoriaProduto> categoriaprodutos;

    @JsonIgnore private int  prod_fk_stock;
    @ManyToOne @MapsId("stock_id") @JoinColumn(name = "prod_fk_stock")  private Stock stock;

    

    public Produto() {}

    public int getId() {
        return prod_id;
    }


    public String getNome() {
        return prod_nome ;
    }

    public void setNome(String prod_nome ) {
        this.prod_nome  = prod_nome ;
    }

    public double getPreco() {
        return prod_preco;
    }

    public void setPreco(double prod_preco) {
        this.prod_preco = prod_preco;
    }

    public String getMarca() {
        return prod_marca;
    }

    public void setMarca(String prod_marca) {
        this.prod_marca = prod_marca;
    }

    public List<CategoriaProduto> getCategoriaprodutos() {
        return categoriaprodutos;
    }

    public Stock getStock() {
        return stock;
    }

    public String getDescricao(){
        return prod_descricao;
    }

    
   


}

    

    

