package ar.com.ada.api.pooflixmongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Episodio;
import ar.com.ada.api.pooflixmongo.entities.Serie;
import ar.com.ada.api.pooflixmongo.entities.Temporada;
import ar.com.ada.api.pooflixmongo.repositories.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public void crearSerie(Serie serie) {
        grabar(serie);
    }

    public void grabar(Serie serie) {
        serieRepository.save(serie);
    }

    public List<Serie> obtenerSeries() {
        return serieRepository.findAll();
    }

    public Serie obtenerPorId(ObjectId serieId) {
        return serieRepository.findBy_id(serieId);
    }

      

}
