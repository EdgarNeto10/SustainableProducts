package pt.iade.sustainableProducts.controllers.results;

public class SimpleResult {
    private String descricao;
    private Object object;

    public SimpleResult(String descricao, Object object) {
        this.descricao = descricao;
        this.object = object;
    }

    public String getDescricao() {
        return descricao;
    }

    public Object getObject() {
        return object;
    }

    
}
