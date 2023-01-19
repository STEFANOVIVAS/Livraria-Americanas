import java.util.ArrayList;
import java.util.List;

public class AlbumMusica extends Produto{

    private List<String> generos=new ArrayList<>();
    private List<String> musicos=new ArrayList<>();
    private List<String> selos= new ArrayList<>();
    private static final String tipo="Albúm";

    public AlbumMusica(String nome,Double preco, String genero, String musico, String selo ) {
        super(nome,preco);
        this.addGeneros(genero);
        this.addMusicos(musico);
        this.addSelos(selo);

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

    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "AlbumMusica{" +
                super.toString() +
                ", tipo=" + tipo +
                ", generos=" + generos +
                ", musicos=" + musicos +
                ", selos=" + selos +
                '}';
    }
}
