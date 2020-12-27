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
@Table(name ="categoria_produtos")
@IdClass(CatProdId.class)

public class CategoriaProduto {
    @Id @Column(name ="catprod_fk_cat")
    
    @JsonIgnore private int cat_id;
    
    @ManyToOne @MapsId("cat_id") @JoinColumn(name="catprod_fk_cat")
    @JsonIgnoreProperties("categoriaprodutos") 
    private Categoria categoria;


    @Id @Column(name ="catprod_fk_prod")
    
    @JsonIgnore private int prod_id;
    
    @ManyToOne @MapsId("prod_id") @JoinColumn(name="catprod_fk_prod")
    @JsonIgnoreProperties("categoriaprodutos")
    private Produto produto;

    public CategoriaProduto(){}

    public int getCat_id() {
        return cat_id;
    }


    public Categoria getCategoria() {
        return categoria;
    }

   

    public int getProd_id() {
        return prod_id;
    }


    public Produto getProduto() {
        return produto;
    }

   

    

    
}
