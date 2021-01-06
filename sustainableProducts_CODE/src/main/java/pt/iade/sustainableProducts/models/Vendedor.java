package pt.iade.sustainableProducts.models;

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
@Table(name = "vendedores")

public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = " vend_id") private int id;  
    @Column(name = "vend_cargo") private String cargo;
    
    @JsonIgnore private int vend_fk_uti;
                                
    @ManyToOne @MapsId("uti_id") @JoinColumn(name = "vend_fk_uti")  private Utilizador utilizador;
    
    @OneToMany @JoinColumn(name="vend_enc_fk_vend") @JsonIgnoreProperties("vendedor")
    private List<VendedorEncomendas> vend_encomendas;

    
     public Vendedor(){}

     public int getId() {
         return id;
     }

     public String getCargo() {
         return cargo;
     }


     public int getVend_fk_uti() {
         return vend_fk_uti;
     }


     public Utilizador getUtilizador() {
         return utilizador;
     }

     public List<VendedorEncomendas> getVend_encomendas() {
         return vend_encomendas;
     }


}
