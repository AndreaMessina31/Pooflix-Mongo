package ar.com.ada.api.pooflixmongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Pelicula;
import ar.com.ada.api.pooflixmongo.repositories.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;


    public void crearPelicula(Pelicula pelicula) {
        grabar(pelicula);
    }

    public void grabar(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula obtenerPorId(ObjectId peliculaId) {
        return peliculaRepository.findBy_id(peliculaId);
    }

    
}
