import java.util.ArrayList;
import java.util.List;

public class Livro extends Produto{
    private List<String> generos=new ArrayList<>();
    private String escritor;
    private String editora;
    private String tipo;

    public Livro(String nome, Double preco, String genero, String escritor, String editora) {
        super(nome, preco);
        this.setTipo("Livro");
        this.addGeneros(genero);
        this.escritor = escritor;
        this.editora = editora;
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

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                super.toString() +
                ", tipo=" + tipo +
                ", generos=" + generos +
                ", escritor='" + escritor + '\'' +
                ", editora='" + editora + '\'' +
                "} " ;
    }
}
