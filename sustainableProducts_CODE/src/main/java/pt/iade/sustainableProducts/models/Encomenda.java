package pt.iade.sustainableProducts.models;

import java.sql.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "encomendas")
public class Encomenda {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name= "Enc_id") private int id;
    @Column(name= "Enc_data_Envio") private Date dataenvio;
    @Column(name="Enc_local_Entrega") private String localentrega;
    @Column (name="Enc_estado") @Enumerated(EnumType.ORDINAL) private EstadoEncomenda estado;
    @Column(name="Enc_preco_Porte") private double precoporte;
    @Column(name="Enc_preco_Total") private double precototal;

    


    @Column(name="Enc_cli_id") private int cliid;
    //pk                             //fk
    @ManyToOne @MapsId("cli_id") @JoinColumn(name = "Enc_cli_id")  @JsonIgnoreProperties("encomendas")  private Cliente cliente;

  
    @Column(name="Enc_vend_id") private int vendid;
                           
    @ManyToOne @MapsId("vend_id") @JoinColumn(name = "Enc_vend_id")  @JsonIgnoreProperties("encomendas")  private Vendedor vendedor;




    

   /*
    @JsonIgnore private int Enc_fk_carr;
    @OneToOne(cascade= CascadeType.ALL) @MapsId("Carr_id") @JoinColumn(name="Enc_fk_carr") private Carrinho carrinho;
   */
    
   /*
   @OneToMany @JoinColumn(name="vend_enc_fk_enc") @JsonIgnoreProperties("encomenda")
    private List<VendedorEncomendas> vend_encomendas;
    */


    @OneToMany @JoinColumn(name = "encpro_fk_enc")  @JsonIgnoreProperties("encomenda")
    private List<EncomendaProduto> encomendaprodutos;
  
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

  

    public Cliente getCliente() {
        return cliente;
    }

   

    public List<EncomendaProduto> getEncomendaprodutos() {
        return encomendaprodutos;
    }


    public EstadoEncomenda getEstado() {
        return estado;
    }

    public int getCliid() {
        return cliid;
    }

  
    public Vendedor getVendedor() {
        return vendedor;
    }

    public int getVendid() {
        return vendid;
    }

    

   
   
  

 
}
