package pt.iade.sustainableProducts.models;

import java.io.Serializable;

public class CarrinhoId implements Serializable {
    private static final long serialVersionUID = 3103463164387407729L;
    private int Enc_id;
    private int prod_id;

    public CarrinhoId() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == CarrinhoId.class && ((CarrinhoId) obj).Enc_id == Enc_id
                && ((CarrinhoId) obj).prod_id == prod_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getEnc_id() {
        return Enc_id;
    }

    public void setEnc_id(int enc_id) {
        Enc_id = enc_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

  
    
}
