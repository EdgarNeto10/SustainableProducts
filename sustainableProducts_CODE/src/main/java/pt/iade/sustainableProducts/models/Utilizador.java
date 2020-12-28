package pt.iade.sustainableProducts.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "utilizadores")
public  class Utilizador {
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    
    @Column(name= "Uti_id") private int id;
    @Column(name= "Uti_nome") private String nome;
    @Column(name= "Uti_data_Nac") private Date dataNac; 
    @Column(name= "Uti_morada") private String morada;
    @Column(name= "Uti_sexo") private char sexo;
    @Column(name= "Uti_email") private String email;
    @Column(name= "Uti_password") private String password;

  


    public Utilizador(){}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNac() {
        return dataNac;
    }


    public String getMorada() {
        return morada;
    }


    public char getSexo() {
        return sexo;
    }

  

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

   

   

   

    
    
}
