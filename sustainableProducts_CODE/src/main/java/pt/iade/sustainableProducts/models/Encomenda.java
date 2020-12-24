package pt.iade.sustainableProducts.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @ManyToOne @MapsId("cli_id") @JoinColumn(name = "Enc_cli_id")  private Cliente cliente;


    public Encomenda() {}



    public Cliente getCliente() {
        return cliente;
    }

    public int getEnc_id() {
        return Enc_id;
    }

    public void setEnc_id(int enc_id) {
        Enc_id = enc_id;
    }

    public LocalDate getEnc_data_Envio() {
        return Enc_data_Envio;
    }

    public void setEnc_data_Envio(LocalDate enc_data_Envio) {
        Enc_data_Envio = enc_data_Envio;
    }

    public String getEnc_local_Entrega() {
        return Enc_local_Entrega;
    }

    public void setEnc_local_Entrega(String enc_local_Entrega) {
        Enc_local_Entrega = enc_local_Entrega;
    }

    public String getEnc_Estado() {
        return Enc_Estado;
    }

    public void setEnc_Estado(String enc_Estado) {
        Enc_Estado = enc_Estado;
    }

    public double getEnc_preco_Porte() {
        return Enc_preco_Porte;
    }

    public void setEnc_preco_Porte(double enc_preco_Porte) {
        Enc_preco_Porte = enc_preco_Porte;
    }

    public double getEnc_preco_Total() {
        return Enc_preco_Total;
    }

    public void setEnc_preco_Total(double enc_preco_Total) {
        Enc_preco_Total = enc_preco_Total;
    }

    public int getCli_id() {
        return Enc_cli_id;
    }

    public void setCli_id(int cli_id) {
        Enc_cli_id= cli_id;
    }

   
    
}
