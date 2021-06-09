package ar.com.challenge.apiDisney.Controller;


import ar.com.challenge.apiDisney.Services.PeliculaoSerieService;

import ar.com.challenge.apiDisney.dto.PeliculaoSerieSimpleDto;
import ar.com.challenge.apiDisney.dto.PeliculasoSeriesFiltroDTO;
import ar.com.challenge.apiDisney.models.PeliculasoSeries;
import ar.com.challenge.apiDisney.models.Personaje;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/peliculas-o-series")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PeliculaoSerieController {
    @Autowired
    PeliculaoSerieService peliculaoSerieService;

    @Operation(summary = "trae listado de peliculas")
    @GetMapping("/movie")
    public ArrayList<PeliculasoSeriesFiltroDTO> obtenerLista() {
        return peliculaoSerieService.obtenerPersonajeSerie();
    }

    @Operation(summary = "trae pelicula por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPelSerieId(@PathVariable("id") Integer idPelSerie) {
        PeliculaoSerieSimpleDto peliSerieTraer = peliculaoSerieService.getPeliSerieID(idPelSerie);
        return new ResponseEntity<PeliculaoSerieSimpleDto>(peliSerieTraer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarPeliculaoSerie(@RequestBody PeliculaoSerieSimpleDto peliculaoSerieDtoDto) {
        return new ResponseEntity(this.peliculaoSerieService.guardarPeliculaoSerie(peliculaoSerieDtoDto), HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity eliminarPeliculaoserie(@RequestParam Integer idPelse) {
        return new ResponseEntity(this.peliculaoSerieService.eliminarPeliculaoSerie(idPelse), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<PeliculaoSerieSimpleDto> updateGenero(@RequestBody PeliculaoSerieSimpleDto pelSe) {
        PeliculasoSeries generoActualizar = peliculaoSerieService.updatePelSe(pelSe);
        return new ResponseEntity(this.peliculaoSerieService.updatePelSe(pelSe), HttpStatus.CREATED);

    }

    @GetMapping("/nombrepeli/{titulo}")
    public ArrayList<PeliculasoSeries> peliculaNombres(@PathVariable("titulo") String peliculaXNombre) {
        ArrayList<PeliculasoSeries> xNombre = peliculaoSerieService.obtenerPeliculaXNombre(peliculaXNombre);
        return xNombre;
    }

    @GetMapping("/orderPelicula/{ascDes}")
    public ArrayList<PeliculasoSeries> pelAscDes(@PathVariable("ascDes") String asenden) {
        ArrayList<PeliculasoSeries> des = peliculaoSerieService.obtenerPeliculaoSerieAscDes(asenden);
        return des;
    }

    @GetMapping("/genero/{idGenero}")
    public ArrayList<PeliculasoSeries> idGenero(@PathVariable("idGenero") Integer idgenero) {
        ArrayList<PeliculasoSeries> idgen = peliculaoSerieService.ObtenerIdGenero(idgenero);
        return idgen;
    }

}
