package pt.iade.sustainableProducts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    private int cat_id;
    private String cat_nome;

    public Categoria() {}

    public int getCat_id() {
        return cat_id;
    }


    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    




    
}
