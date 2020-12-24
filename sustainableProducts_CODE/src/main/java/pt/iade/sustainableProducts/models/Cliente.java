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



@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name= "Cli_id") private int Cli_id;
    @Column(name= "Cli_tipo_Cartao") private String Cli_tipo_Cartao;
    @Column(name= "Cli_num_Cartao") private int Cli_num_Cartao;
    @OneToMany @JoinColumn(name="Enc_cli_id") private List<Encomenda> encomendas; 

    public Cliente() {}

    public int getCli_id() {
        return Cli_id;
    }

    public void setCli_id(int cli_id) {
        Cli_id = cli_id;
    }

    public String getCli_tipo_Cartao() {
        return Cli_tipo_Cartao;
    }

    public void setCli_tipo_Cartao(String cli_tipo_Cartao) {
        Cli_tipo_Cartao = cli_tipo_Cartao;
    }

    public int getCli_num_Cartao() {
        return Cli_num_Cartao;
    }

    public void setCli_num_Cartao(int cli_num_Cartao) {
        Cli_num_Cartao = cli_num_Cartao;
    }

    

    

   

    
    
}
