package pt.iade.sustainableProducts.models;

import java.io.Serializable;

public class CatProdId implements Serializable {
    private static final long serialVersionUID = 3103463164387407729L;
    private int cat_id;
    private int prod_id;

    public CatProdId() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == CatProdId.class && ((CatProdId) obj).cat_id == cat_id
                && ((CatProdId) obj).prod_id == prod_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }


  


    
}