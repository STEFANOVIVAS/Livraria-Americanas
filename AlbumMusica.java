import java.util.ArrayList;
import java.util.List;

public class AlbumMusica extends Produto{

    private List<String> generos=new ArrayList<>();
    private List<String> musicos=new ArrayList<>();
    private List<String> selos= new ArrayList<>();

    public AlbumMusica(Long id, String nome,Double preco,List<String> generos, List<String> musicos, List<String> selos ) {
        super(id,nome,preco);
        this.generos = generos;
        this.musicos = musicos;
        this.selos = selos;

    }

    public List<String> getGeneros() {
        return generos;
    }

    public void addGeneros(String genero) {

        this.generos.add(genero)  ;
    }

    public void removeGeneros(String genero){
        this.generos.remove(genero);
    }

    public List<String> getMusicos() {
        return musicos;
    }

    public void addMusicos(String musico) {
        this.musicos.add(musico);
    }

    public List<String> getSelos() {
        return selos;
    }

    public void addSelos(String selo) {
        this.selos.add(selo);
    }
}
