import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto{
    private String distribuidora;
    private List<String> generos=new ArrayList<>();
    private String estudio;
    private static final String tipo="Jogo";

    public Jogo(String nome, Double preco, String distribuidora, String genero, String estudio) {
        super(nome, preco);
        this.distribuidora = distribuidora;
        this.addGeneros(genero);
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void addGeneros(String genero) {
        this.generos.add(genero);
    }
    public void removeGeneros(String genero){
        this.generos.remove(genero);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                super.toString() +
                ", tipo='" + tipo + '\'' +
                ", distribuidora='" + distribuidora + '\'' +
                ", generos=" + generos +
                ", estudio='" + estudio + '\'' +
                "} ";
    }
}
