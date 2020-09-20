package ar.com.ada.api.pooflixmongo.controllers;

import java.util.*;
import org.bson.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.pooflixmongo.entities.Pelicula;
import ar.com.ada.api.pooflixmongo.models.request.PeliculaRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.PeliculaService;

@RestController
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public ResponseEntity<GenericResponse> crearPelicula(@RequestBody PeliculaRequest pR) {

        Pelicula pelicula = new Pelicula();
        pelicula.setTiempoVisto(pR.tiempoVisto);
        pelicula.setTitulo(pR.titulo);
        peliculaService.crearPelicula(pelicula);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = pelicula.get_id();// .toHexString();
        gR.mensaje = "Pelicula creada con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        return ResponseEntity.ok(peliculaService.obtenerPeliculas());

    }

    @GetMapping("/peliculas{_id}")
    public ResponseEntity<Pelicula> ObtenerPeliculaporId(@PathVariable ObjectId peliculaId) {

        Pelicula pelicula = peliculaService.obtenerPorId(peliculaId);
        if (pelicula == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pelicula);

    }
}