public class Brinquedo extends Produto{
    private String tipoBrinquedo;
    private Categoria tipo;

    public Brinquedo(String nome, Double preco, String tipoBrinquedo) {
        super(nome, preco);
        this.setTipo(Categoria.BRINQUEDO);
        this.tipoBrinquedo = tipoBrinquedo;
    }


    @Override
    public Categoria getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(Categoria tipo) {
        this.tipo = tipo;
    }

    public String getTipoBrinquedo() {
        return tipoBrinquedo;
    }

    public void setTipoBrinquedo(String tipoBrinquedo) {
        this.tipoBrinquedo = tipoBrinquedo;
    }


    @Override
    public String toString() {
        return "Brinquedo{" +
                super.toString() +
                ", tipo=" + tipo +
                ", tipoBrinquedo='" + tipoBrinquedo + '\'' +
                "} ";
    }
}
