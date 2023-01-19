public class Brinquedo extends Produto{
    private String tipo;

    public Brinquedo(Long id, String nome, Double preco, String tipo) {
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
