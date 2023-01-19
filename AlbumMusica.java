import java.util.ArrayList;
import java.util.List;

public class AlbumMusica extends Produto{

    private List<String> generos=new ArrayList<>();
    private List<String> musicos=new ArrayList<>();
    private List<String> selos= new ArrayList<>();
    private String tipo;

    public AlbumMusica(String nome,Double preco, String genero, String musico, String selo ) {
        super(nome,preco);
        this.setTipo("Albúm");
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
        return "AlbumMusica{" +
                super.toString() +
                ", tipo=" + tipo +
                ", generos=" + generos +
                ", musicos=" + musicos +
                ", selos=" + selos +
                '}';
    }
}
