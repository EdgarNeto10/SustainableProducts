/*package pt.iade.sustainableProducts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name= "cli_id") @JsonIgnore private int id;
    @Column(name= "cli_tipoCartao") private String tipoCartao;
    @Column(name= "cli_numCartao") private int numCartao;
    @OneToMany @MapsId("cli_id") private List<Encomenda> encomendas; 
    public Cliente() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public int getnumCartao() {
        return numCartao;
    }

    public void setCli_numCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    
    
}*/
