package pt.iade.sustainableProducts.models;

import java.sql.Date;
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

@Entity
@Table(name = "encomendas")
public class Encomenda {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name= "Enc_id") private int id;
    @Column(name= "Enc_data_Envio") private Date dataenvio;
    @Column(name="Enc_local_Entrega") private String localentrega;
    @Column(name="Enc_Estado") private String estado;
    @Column(name="Enc_preco_Porte") private double precoporte;
    @Column(name="Enc_preco_Total") private double precototal;
    


    @JsonIgnore private int Enc_cli_id;
    //pk                             //fk
    @ManyToOne @MapsId("cli_id") @JoinColumn(name = "Enc_cli_id")  @JsonIgnoreProperties("encomendas")  private Cliente cliente;

    

   
    @JsonIgnore private int Enc_fk_carr;

    @OneToOne(cascade= CascadeType.ALL) @MapsId("Carr_id") @JoinColumn(name="Enc_fk_carr") private Carrinho carrinho;

    @OneToMany @JoinColumn(name="vend_enc_fk_enc") @JsonIgnoreProperties("encomenda")
    private List<VendedorEncomendas> vend_encomendas;



  
 // O cascade é utilizado para não termos conflitos qunado estivermos a guardar a encomenda com o seu pagamento. Nã sei 
 // se há uma outra forma de se fazer mas esta é a q encontrei. Qualquer coisa pergunto ao Bugalho



    public Encomenda() {}

    public int getId() {
        return id;
    }


    public Date getDataenvio() {
        return dataenvio;
    }

    
    public String getLocalentrega() {
        return localentrega;
    }

   

    public String getEstado() {
        return estado;
    }

  

    public double getPrecoporte() {
        return precoporte;
    }

    public void setPrecoporte(double precoporte) {
        this.precoporte = precoporte;
    }

    public double getPrecototal() {
        return precototal;
    }

    public void setPrecototal(double precototal) {
        this.precototal = precototal;
    }

    public int getEnc_cli_id() {
        return Enc_cli_id;
    }

  

    public Cliente getCliente() {
        return cliente;
    }

   

    public int getEnc_fk_carr() {
        return Enc_fk_carr;
    }

    

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<VendedorEncomendas> getVend_encomendas() {
        return vend_encomendas;
    }

    

    

   


 
}
