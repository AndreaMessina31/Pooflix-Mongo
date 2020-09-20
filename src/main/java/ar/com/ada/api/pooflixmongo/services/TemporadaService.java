package ar.com.ada.api.pooflixmongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Episodio;
import ar.com.ada.api.pooflixmongo.entities.Serie;
import ar.com.ada.api.pooflixmongo.entities.Temporada;
import ar.com.ada.api.pooflixmongo.repositories.SerieRepository;
import ar.com.ada.api.pooflixmongo.repositories.TemporadaRepository;

@Service
public class TemporadaService {

    @Autowired
    TemporadaRepository temporadaRepository;
    @Autowired
    SerieRepository serieRepository;

    public void crearTemporada(Temporada temporada) {
        grabar(temporada);
    }

    public void grabar(Temporada temporada) {
        temporadaRepository.save(temporada);
    }

    public List<Temporada> obtenerTemporadas() {
        return temporadaRepository.findAll();
    }

    public Temporada obtenerPorId(ObjectId temporadaId) {
        return temporadaRepository.findBy_id(temporadaId);
    }

    public Temporada crearTemporada(ObjectId serieId, ObjectId temporadaId, Integer numero) {

        Serie serie = serieRepository.findBy_id(serieId);

        Temporada temporada = new Temporada();
        temporada.set_id(temporadaId);
        temporada.setNumero(numero);
        serie.getTemporadas().add(temporada);
        serieRepository.save(serie);
        return temporada;

    }
    public Episodio crearEpisodio(ObjectId temporadaId, Integer numero, String nombre, Double duracion) {

        Temporada temporada = obtenerPorId(temporadaId);

        Episodio episodio = new Episodio();
        episodio.setDuracion(duracion);
        episodio.setNombre(nombre);
        episodio.setNumero(numero);
        temporada.getEpisodios().add(episodio);
        grabar(temporada);
        return episodio;

    }

}
