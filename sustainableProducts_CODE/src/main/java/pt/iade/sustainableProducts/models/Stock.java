package pt.iade.sustainableProducts.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "stocks")

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "Stock_id") private int id;  
    @Column(name = "Stock_quant_prod") private int quantidade;  

    public Stock(){}

    public int getId() {
        return id;
    }


    public int getQuantidade() {
        return quantidade;
    }

  
    


    
}
