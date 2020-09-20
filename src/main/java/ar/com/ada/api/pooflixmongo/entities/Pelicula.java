package ar.com.ada.api.pooflixmongo.entities;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pelicula")
public class Pelicula extends Contenido {

    private ObjectId _id;
    private Boolean filmadaEnImax;

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Boolean getFilmadaEnImax() {
        return filmadaEnImax;
    }

    public void setFilmadaEnImax(Boolean filmadaEnImax) {
        this.filmadaEnImax = filmadaEnImax;
    }

    
}
