import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto{
    private String distribuidora;
    private List<String> generos=new ArrayList<>();
    private String estudio;

    public Jogo(Long id, String nome, Double preco, String distribuidora, List<String> generos, String estudio) {
        super(id, nome, preco);
        this.distribuidora = distribuidora;
        this.generos = generos;
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
}
