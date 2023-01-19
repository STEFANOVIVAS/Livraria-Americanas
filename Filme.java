import java.util.ArrayList;
import java.util.List;

public class Filme extends Produto{
    private List<String> diretores=new ArrayList<>();
    private List<String> generos=new ArrayList<>();
    private String estudio;
    private List<String> produtores= new ArrayList<>();
    private static final String tipo="Filme";

    public Filme(String nome, Double preco, String diretor, String genero, String estudio, String produtor) {
        super(nome, preco);
        this.addDiretores(diretor);
        this.addGeneros(genero);
        this.estudio = estudio;
        this.addProdutores(produtor);
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

    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Filme{" +
                super.toString() +
                " tipo=" + tipo +
                ", diretores=" + diretores +
                ", generos=" + generos +
                ", estudio='" + estudio + '\'' +
                ", produtores=" + produtores + "}" ;
    }
}
