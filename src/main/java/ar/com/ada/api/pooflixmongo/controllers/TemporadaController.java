package ar.com.ada.api.pooflixmongo.controllers;
import java.util.*;
import org.bson.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.pooflixmongo.entities.Temporada;
import ar.com.ada.api.pooflixmongo.models.request.TemporadaRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.TemporadaService;

@RestController
public class TemporadaController {
   
    @Autowired
    TemporadaService temporadaService;

    @PostMapping("/temporadas")
    public ResponseEntity<GenericResponse> crearTemporada(@RequestBody TemporadaRequest tR) {

        Temporada temporada = new Temporada();
        temporada.setNumero(tR.numero);
        temporadaService.crearTemporada(temporada);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = temporada.get_id();// .toHexString();
        gR.mensaje = "Temporada creada con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/temporadas")
    public ResponseEntity<List<Temporada>> listarTemporadas() {
        return ResponseEntity.ok(temporadaService.obtenerTemporadas());

    } 

    @GetMapping("/temporadas{_id}")
    public ResponseEntity<Temporada> ObtenerTemporadaporId(@PathVariable ObjectId temporadaId) {

        Temporada temporada = temporadaService.obtenerPorId(temporadaId);
        if (temporada == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(temporada);

    }
}
 


