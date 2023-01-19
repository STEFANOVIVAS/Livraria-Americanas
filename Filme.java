import java.util.ArrayList;
import java.util.List;

public class Filme extends Produto{
    private List<String> diretores=new ArrayList<>();
    private List<String> generos=new ArrayList<>();
    private String estudio;
    private List<String> produtores= new ArrayList<>();

    public Filme(Long id, String nome, Double preco, List<String> diretores, List<String> generos, String estudio, List<String> produtores) {
        super(id, nome, preco);
        this.diretores = diretores;
        this.generos = generos;
        this.estudio = estudio;
        this.produtores = produtores;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void addDiretores(String diretor) {
        this.diretores.add(diretor);
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

    public List<String> getProdutores() {
        return produtores;
    }

    public void addProdutores(String produtor) {
        this.produtores.add(produtor);
    }
}
