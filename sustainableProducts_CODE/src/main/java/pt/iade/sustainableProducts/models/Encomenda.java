package pt.iade.sustainableProducts.models;

import java.time.LocalDate;
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
    @Column(name= "Enc_id") private int Enc_id;
    @Column(name= "Enc_data_Envio") private LocalDate Enc_data_Envio;
    @Column(name="Enc_local_Entrega") private String Enc_local_Entrega;
    @Column(name="Enc_Estado") private String Enc_Estado;
    @Column(name="Enc_preco_Porte") private double Enc_preco_Porte;
    @Column(name="Enc_preco_Total") private double Enc_preco_Total;

    @JsonIgnore private int Enc_cli_id;
    //pk                             //fk
    @ManyToOne @MapsId("cli_id") @JoinColumn(name = "Enc_cli_id")  @JsonIgnoreProperties("encomendas")  private Cliente cliente;

    @OneToMany @JoinColumn(name="Carr_fk_enc") @JsonIgnoreProperties("encomenda")
    private List<Carrinho> carrinhos;

    @OneToMany @JoinColumn(name="vend_enc_fk_enc") @JsonIgnoreProperties("encomenda")
    private List<VendedorEncomendas> vend_encomendas;



 // As mesmas duvidas apresentadas na classe Pagamento também se aplican aqui 
 // O cascade é utilizado para não termos conflitos qunado estivermos a guardar a encomenda com o seu pagamento. Nã sei 
 // se há uma outra forma de se fazer mas esta é a q encontrei. Qualquer coisa pergunto ao Bugalho

   //@OneToOne(cascade= CascadeType.ALL) @MapsId("Pag_id") @JoinColumn(name = "Pag_id") private Pagamento pagamento;


    public Encomenda() {}

    public int getEnc_id() {
        return Enc_id;
    }



    public LocalDate getEnc_data_Envio() {
        return Enc_data_Envio;
    }

  

    public String getEnc_local_Entrega() {
        return Enc_local_Entrega;
    }

 
    public String getEnc_Estado() {
        return Enc_Estado;
    }

   
    public double getEnc_preco_Porte() {
        return Enc_preco_Porte;
    }

   

    public double getEnc_preco_Total() {
        return Enc_preco_Total;
    }

  

    public int getEnc_cli_id() {
        return Enc_cli_id;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public List<VendedorEncomendas> getVend_encomendas() {
        return vend_encomendas;
    }

  

    /*public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }*/

    

    

    

   


    
}
