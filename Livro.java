import java.util.ArrayList;
import java.util.List;

public class Livro extends Produto{
    private List<String> generos=new ArrayList<>();
    private String escritor;
    private String editora;

    public Livro(Long id, String nome, Double preco, List<String> generos, String escritor, String editora) {
        super(id, nome, preco);
        this.generos = generos;
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
}
