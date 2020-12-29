package pt.iade.sustainableProducts.models;

import java.io.Serializable;

public class VendCatId implements Serializable {

    private static final long serialVersionUID = 3103463164387407729L;
    private int vend_id;
    private int enc_id;

    public VendCatId () {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == VendCatId.class && ((VendCatId ) obj).vend_id == vend_id
                && ((VendCatId ) obj).enc_id == enc_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getVend_id() {
        return vend_id;
    }


    public int getEnc_id() {
        return enc_id;
    }

    
    


}
