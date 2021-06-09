package ar.com.challenge.apiDisney.Controller;

import ar.com.challenge.apiDisney.Services.GeneroService;
import ar.com.challenge.apiDisney.dto.GeneroDto;
import ar.com.challenge.apiDisney.dto.PersonajeDto;
import ar.com.challenge.apiDisney.dto.PersonajeFiltroDTO;
import ar.com.challenge.apiDisney.models.Genero;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @Operation(summary = "trae lista de genero")
    @GetMapping
    public ArrayList<Genero> obtenerGenero(){return generoService.obtenerGenero();}

    @Operation(summary = "trae genero por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getGeneroId(@PathVariable("id")Integer idGenero){
        Genero generoTraer = generoService.getGenero(idGenero);
        return  new ResponseEntity<Genero>(generoTraer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarGenero(@RequestBody GeneroDto genero){
        return  new ResponseEntity(this.generoService.guardarGenero(genero),HttpStatus.CREATED);

    }
    @DeleteMapping
    public  ResponseEntity eliminarGenero(@RequestParam Integer idGenero){
        return  new ResponseEntity(this.generoService.eliminarGenero(idGenero), HttpStatus.ACCEPTED);
    }
    @PutMapping
    public  ResponseEntity<GeneroDto> updateGenero(@RequestBody GeneroDto generoDto){
        Genero generoActualizar = generoService.updateGenero(generoDto);
        return  new ResponseEntity(this.generoService.updateGenero(generoDto),HttpStatus.CREATED);
   }

}
