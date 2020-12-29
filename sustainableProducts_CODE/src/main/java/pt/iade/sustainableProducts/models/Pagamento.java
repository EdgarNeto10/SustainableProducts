package pt.iade.sustainableProducts.models;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id @GeneratedValue
 (strategy = GenerationType.IDENTITY)
    @Column(name="Pag_id") private int Pag_id;
    @Column(name="Pag_tipo") private String Pag_tipo;
    @Column(name="Pag_numCartao") private int Pag_numCartao;
    @Column(name="Pag_data") private LocalDate Pag_data;
    @Column(name="Pag_totalCompra") private double Pag_totalCompra;
    @Column(name="Pag_nomeCliente") private String Pag_nomeCliente;
    
  // Dúvida: Esta é uma relação de um para um com a tabela das encomendas. Qual vai ser o nome da joinColumn, 
  //visto que não temos uma coluna na encomenda para pagamento. Seria correto por o nome da Join Column como "Pag_totalCompra" e nas encomendas como "Enc_preco_Total"?
  // Ou então a join column do pagamento seria a Enc_id e da encomenda seria o pag_id?
    
   //@OneToOne @MapsId("Enc_id") @JoinColumn(name="Enc_id") private Encomenda encomenda;

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

    public int getPag_numCartao() {
        return Pag_numCartao;
    }

    public void setPag_numCartao(int pag_numCartao) {
        Pag_numCartao = pag_numCartao;
    }

    public LocalDate getPag_data() {
        return Pag_data;
    }

    public void setPag_data(LocalDate pag_data) {
        Pag_data = pag_data;
    }

    public double getPag_totalCompra() {
        return Pag_totalCompra;
    }

    public void setPag_totalCompra(double pag_totalCompra) {
        Pag_totalCompra = pag_totalCompra;
    }

    public String getPag_nomeCliente() {
        return Pag_nomeCliente;
    }

    public void setPag_nomeCliente(String pag_nomeCliente) {
        Pag_nomeCliente = pag_nomeCliente;
    }

    /*public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }*/

    


    
}
