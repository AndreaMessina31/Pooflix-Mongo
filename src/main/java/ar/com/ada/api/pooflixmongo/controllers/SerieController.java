package ar.com.ada.api.pooflixmongo.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.pooflixmongo.entities.Serie;
import ar.com.ada.api.pooflixmongo.models.request.*;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.SerieService;

@RestController
public class SerieController {

    @Autowired
    SerieService serieService;

    @PostMapping("/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody SerieRequest sR) {

        Serie serie = new Serie();
        serie.setTiempoVisto(sR.tiempoVisto);
        serie.setTitulo(sR.titulo);
        serieService.crearSerie(serie);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = serie.get_id();// .toHexString();
        gR.mensaje = "Serie creada con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> listarSeries() {
        return ResponseEntity.ok(serieService.obtenerSeries());

    } 

    @GetMapping("/series{_id}")
    public ResponseEntity<Serie> ObtenerSerieporId(@PathVariable ObjectId serieId ){

        Serie serie = serieService.obtenerPorId(serieId);
        if (serie == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(serie);
    }
}
