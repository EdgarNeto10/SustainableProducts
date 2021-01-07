package pt.iade.sustainableProducts.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Classe pode ser utlizada para fazer o historico de encomendas de um ou mais clientes.

@Entity
@Table(name = "clientes")
public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "Cli_id") private int Cli_id; 
    @Column(name = "Cli_tipo_Cartao") private String Cli_tipo_Cartao; 
    @Column(name = "Cli_num_Cartao") private int Cli_num_Cartao;
   
    
    @JsonIgnore private int cli_fk_uti;
                                
    @ManyToOne @MapsId("uti_id") @JoinColumn(name = "cli_fk_uti")  private Utilizador utilizador;

    @OneToMany @JoinColumn(name = "Enc_cli_id")  @JsonIgnoreProperties("cliente") private List<Encomenda> encomendas;

    @OneToOne(cascade= CascadeType.ALL) @MapsId("carr_id") @JoinColumn(name="cli_fk_carr") private Carrinho carrinho;

    public Cliente() {
    }

    public int getCli_id() {
        return Cli_id;
    }

    public String getCli_tipo_Cartao() {
        return Cli_tipo_Cartao;
    }

    public int getCli_num_Cartao() {
        return Cli_num_Cartao;
    }


    public Utilizador getUtilizador() {
        return utilizador;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

  
    

  
}