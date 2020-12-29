package pt.iade.sustainableProducts.models;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name="Pag_id") private int Pag_id;
    @Column(name="Pag_tipo") private String Pag_tipo;
    @Column(name="Pag_num_cartao") private int Pag_num_cartao;
    @Column(name="Pag_data") private LocalDate Pag_data;
    @Column(name="Pag_total_compra") private double Pag_total_compra;
    @Column(name="Pag_nome_cliente") private String Pag_nome_cliente;
    
  
     

    public Pagamento() {

    }

    public int getPag_id() {
        return Pag_id;
    }

    public void setPag_id(int pag_id) {
        Pag_id = pag_id;
    }

    public String getPag_tipo() {
        return Pag_tipo;
    }

    public void setPag_tipo(String pag_tipo) {
        Pag_tipo = pag_tipo;
    }

    public int getPag_num_cartao() {
        return Pag_num_cartao;
    }



    public LocalDate getPag_data() {
        return Pag_data;
    }

    public void setPag_data(LocalDate pag_data) {
        Pag_data = pag_data;
    }

    public double getPag_total_compra() {
        return Pag_total_compra;
    }


    public String getPag_nome_cliente() {
        return Pag_nome_cliente;
    }


    


    
}
