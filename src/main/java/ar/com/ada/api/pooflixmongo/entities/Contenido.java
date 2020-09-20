package ar.com.ada.api.pooflixmongo.entities;
import java.util.*;


public class Contenido {

    private String titulo;
    private List<String> premios= new ArrayList<>();
    private Double tiempoVisto;
    private List<Genero> generos= new ArrayList<>();
    private List<Actor> actores= new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getPremios() {
        return premios;
    }

    public void setPremios(List<String> premios) {
        this.premios = premios;
    }

    public Double getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(Double tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    //TODO
    // agregarle luego el director al crear contenido de tipo serie o pelicula
    
}
