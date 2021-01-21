package pt.iade.sustainableProducts.models;

import java.io.Serializable;

public class VendEncId implements Serializable {

    private static final long serialVersionUID = 3103463164387407729L;
    private int vend_id;
    private int enc_id;

    public VendEncId () {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == VendEncId.class && ((VendEncId ) obj).vend_id == vend_id
                && ((VendEncId ) obj).enc_id == enc_id;

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
