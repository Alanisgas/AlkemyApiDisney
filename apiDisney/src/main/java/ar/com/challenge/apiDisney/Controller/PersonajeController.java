package ar.com.challenge.apiDisney.Controller;

import ar.com.challenge.apiDisney.Services.PersonajeService;
import ar.com.challenge.apiDisney.dto.PersonajeDetalleDto;
import ar.com.challenge.apiDisney.dto.PersonajeDto;
import ar.com.challenge.apiDisney.dto.PersonajeFiltroDTO;
import ar.com.challenge.apiDisney.models.Personaje;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/personaje")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    @Operation(summary = "trae peliculas")
    @GetMapping("/personajes-caracteristicas")
    public ArrayList<PersonajeFiltroDTO> obtenerLista(){return personajeService.obtenerPersonajes();}

    @Operation(summary = "Trae personaje con las peliculas o series relacionadas")
    @GetMapping("/personajes-detalles")
    public ArrayList<PersonajeDetalleDto> detalleLista(){return personajeService.obtenerPersonajesDetalle();}

    @Operation(summary = "trae personaje por id")
    @GetMapping("/{id}")
    public  ResponseEntity<?> getPersonajeIds(@PathVariable("id") Integer idPersonaje){
        PersonajeDto personajeTraer = personajeService.getPersonajeId(idPersonaje);
        return new ResponseEntity<PersonajeDto>(personajeTraer, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> guardarPersonaje(@RequestBody PersonajeDto personaje){
        return new ResponseEntity(this.personajeService.guardarPersonaje(personaje), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity eliminarPersonaje(@RequestParam Integer idPersonaje){
        return new ResponseEntity(this.personajeService.eliminarPersonaje(idPersonaje), HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<PersonajeDto> updatePersonaje(@RequestBody PersonajeDto personaje){
            Personaje personajeActualizar = personajeService.updatePersonaje(personaje);
        return new ResponseEntity(this.personajeService.updatePersonaje(personaje), HttpStatus.CREATED);
    }
    @GetMapping("/nombre/{nombre}")
    public ArrayList<Personaje> personajeNombres(@PathVariable("nombre") String personajeNombre){
        ArrayList<Personaje> personajexNombre = personajeService.obtenerPeronajeXNombre(personajeNombre);
        return personajexNombre;
    }
    @GetMapping("/edad/{edad}")
    public ArrayList<Personaje> peronajeXEdad(@PathVariable("edad") Integer personajeEdad){
        ArrayList<Personaje> personajexedad= personajeService.obtenerPersonajeXEdad(personajeEdad);
        return personajexedad;
    }
    @GetMapping("/idMovie/{idMovie}")
    public ArrayList<Personaje> personajeMovieID(@PathVariable( value = "idMovie") Integer personajeMovie){
        ArrayList<Personaje> personajeMovieId = personajeService.ObtenerIdMovie(personajeMovie);
        return personajeMovieId;
    }
}
