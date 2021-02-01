package pt.iade.sustainableProducts.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
    
    @Column(name = "prod_id") private int id;
    @Column(name = "prod_nome") private String nome;
    @Column(name = "prod_preco") private double preco;
    @Column(name = "prod_marca") private String marca;
    @Column(name = "prod_descricao") private String descricao;

    @OneToMany @JoinColumn(name="catprod_fk_prod")
    @JsonIgnoreProperties("produto")
    private List<CategoriaProduto> categoriaprodutos= new ArrayList<>();

    @JsonIgnore private int  prod_fk_stock;
    @ManyToOne @MapsId("stock_id") @JoinColumn(name = "prod_fk_stock")  private Stock stock;

    @JsonIgnore private int  prod_fk_vend;
    @ManyToOne @MapsId("vend_id") @JoinColumn(name = "prod_fk_vend")  private Vendedor vendedor;

    @OneToMany @JoinColumn(name = "carrprod_fk_prod")  @JsonIgnoreProperties("produto")
    private List<CarrinhoProduto> carrinhoprodutos= new ArrayList<>();

     @OneToMany @JoinColumn(name = "encpro_fk_prod")  @JsonIgnoreProperties("produto") 
     private List<EncomendaProduto> encomendaprodutos = new ArrayList<>();

    

    public Produto() {}

    public int getId() {
        return id;
    }

  
    public String getNome() {
        return nome;
    }

   

    public double getPreco() {
        return preco;
    }

   

    public String getMarca() {
        return marca;
    }

   

    public String getDescricao() {
        return descricao;
    }

  
    public List<CategoriaProduto> getCategoriaprodutos() {
        return categoriaprodutos;
    }

   

    public int getProd_fk_stock() {
        return prod_fk_stock;
    }

  

    public Stock getStock() {
        return stock;
    }

   
    public List<CarrinhoProduto> getCarrinhoprodutos() {
        return carrinhoprodutos;

    }
    

/*
    public Vendedor getVendedor() {
        return vendedor;
    }
*/





 



    


}

    

    

