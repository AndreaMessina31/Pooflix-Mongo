package ar.com.ada.api.pooflixmongo.controllers;
import java.util.List;
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

}
