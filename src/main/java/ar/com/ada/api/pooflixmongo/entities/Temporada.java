package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;
import org.bson.types.ObjectId;

public class Temporada {

    private ObjectId _id;
    private Integer numero;
    private List<Episodio> episodios = new ArrayList<>();

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
