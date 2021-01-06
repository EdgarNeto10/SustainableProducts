package pt.iade.sustainableProducts.models;

import java.io.Serializable;

public class CarrProdId implements Serializable {
    private static final long serialVersionUID = 3103463164387407729L;
    private int carr_id;
    private int prod_id;

    public CarrProdId() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == CarrProdId.class && ((CarrProdId) obj).carr_id == carr_id
                && ((CarrProdId) obj).prod_id == prod_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getCarr_id() {
        return carr_id;
    }

    

    public int getProd_id() {
        return prod_id;
    }

      
    
}
