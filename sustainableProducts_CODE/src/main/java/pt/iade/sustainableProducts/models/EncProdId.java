package pt.iade.sustainableProducts.models;


import java.io.Serializable;

public class EncProdId implements Serializable {
    private static final long serialVersionUID = 3103463164387407729L;
    private int enc_id;
    private int prod_id;

    public EncProdId(){}

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == EncProdId.class && ((EncProdId) obj).enc_id == enc_id
                && ((EncProdId ) obj).prod_id == prod_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getEnc_id() {
        return enc_id;
    }

    
    public int getProd_id(){
        return prod_id;
    }


    

}
