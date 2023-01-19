public class Brinquedo extends Produto{
    private String tipoBrinquedo;
    private static final String tipo="Brinquedo";

    public Brinquedo(String nome, Double preco, String tipoBrinquedo) {
        super(nome, preco);
        this.tipoBrinquedo = tipoBrinquedo;
    }



    public String getTipoBrinquedo() {
        return tipoBrinquedo;
    }

    public void setTipoBrinquedo(String tipoBrinquedo) {
        this.tipoBrinquedo = tipoBrinquedo;
    }
    public String getTipo(){
        return tipo;
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
