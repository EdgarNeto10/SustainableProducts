package pt.iade.sustainableProducts.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "encomendas")
public class Encomenda {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name= "Enc_id") private int id;
    @Column(name= "Enc_dataEnvio") private LocalDate dataEnvio;
    @Column(name="Enc_localEntrega") private String localEntrega;
    @Column(name="Enc_Estado") private String estado;
    @Column(name="Enc_precoPorte") private double precoPorte;
    @Column(name="Enc_precoTotal") private double precoTotal;
    /*@ManyToOne @JoinColumn(name="cli_id") private Cliente cliente;*/
    public Encomenda() {}

    public int getId() {
        return id;
    }


    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecoPorte() {
        return precoPorte;
    }

    public void setPrecoPorte(double precoPorte) {
        this.precoPorte = precoPorte;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    /*public Cliente getCliente() {
        return cliente;
    }*/

   
    
}
