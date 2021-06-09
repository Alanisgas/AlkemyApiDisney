package ar.com.challenge.apiDisney.Services;

import ar.com.challenge.apiDisney.Repository.PeliculasoSeriesRepository;
import ar.com.challenge.apiDisney.Repository.PersonajeRepository;
import ar.com.challenge.apiDisney.dto.*;

import ar.com.challenge.apiDisney.models.PeliculasoSeries;
import ar.com.challenge.apiDisney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonajeService {
    @Autowired
    private PeliculasoSeriesRepository peliculaoSerieRepository;
    @Autowired
    private PersonajeRepository personajeRepository;




    public ArrayList<PersonajeFiltroDTO> obtenerPersonajes() {
        return toListDTO((ArrayList<Personaje>) personajeRepository.findAll());
    }
    public ArrayList<PersonajeDetalleDto> obtenerPersonajesDetalle() {
        return toListdetalleDTO((ArrayList<Personaje>) personajeRepository.findAll());
    }

    public Personaje guardarPersonaje(PersonajeDto personajeDto) {
        Personaje person= toEntity(personajeDto);

        for (PeliculasoSeries s: person.getPeliculasoSeries()){
            PeliculasoSeries pelicula= new PeliculasoSeries();
         PeliculasoSeries peliculasoSeries = peliculaoSerieRepository.findById(s.getId_PeliculaSerie()).orElse(null);
           if (peliculasoSeries==null) {

                pelicula= peliculaoSerieRepository.save(s);
               s.setId_PeliculaSerie(pelicula.getId_PeliculaSerie());
            }else {
               s.setId_PeliculaSerie(peliculasoSeries.getId_PeliculaSerie());
           }


        }
        return personajeRepository.save(person);
    }

    public String eliminarPersonaje(Integer idPersonaje) {
        personajeRepository.deleteById(idPersonaje);
        return "ok";
    }

    public PersonajeDto getPersonajeId(Integer id) {

        return toDto(personajeRepository.findById(id).get());
    }
    public ArrayList<Personaje> obtenerPeronajeXNombre(String nombre){
        return (ArrayList<Personaje>) personajeRepository.findByNombre(nombre);
    }
    public ArrayList<Personaje> obtenerPersonajeXEdad(Integer edad)
    {
       return (ArrayList<Personaje>) personajeRepository.findByEdad(edad);
    }
    public ArrayList<Personaje> ObtenerIdMovie(Integer id){
        return (ArrayList<Personaje>) personajeRepository.findByMovieId(id);
    }

    public Personaje updatePersonaje(PersonajeDto personaje) {
        Personaje personajeOriginal = personajeRepository.findById(personaje.getId()).orElse(null);
        personajeOriginal.setNombre(personaje.getNombre());
        personajeOriginal.setImagen(personaje.getImagen());
        personajeOriginal.setPeso(personaje.getPeso());
        personajeOriginal.setEdad(personaje.getEdad());
     //  personajeOriginal.setPeliculasoSeries(peliculaoSerieService.toEntityList(personaje.getPeliculasoSeries()));


        for (PeliculasoSeries s: personajeOriginal.getPeliculasoSeries()){
            peliculaoSerieRepository.findById(s.getId_PeliculaSerie()).orElse(peliculaoSerieRepository.save(s));
        }
        return personajeRepository.save(personajeOriginal);

    }

    public Personaje toEntity(PersonajeDto personajeDto) {
        Personaje personajes = new Personaje();
        personajes.setNombre(personajeDto.getNombre());
        personajes.setEdad(personajeDto.getEdad());
        personajes.setId_Personaje(personajeDto.getId());
        personajes.setPeso(personajeDto.getPeso());
        personajes.setImagen(personajeDto.getImagen());
        ArrayList<PeliculasoSeries> peliculaoSerieList= new ArrayList<PeliculasoSeries>();

        for (PeliculaoSerieSimpleDto itemP: personajeDto.getPeliculasoSeries()){
            PeliculasoSeries peliculaoSerie=new PeliculasoSeries();
            peliculaoSerie.setId_PeliculaSerie(itemP.getId());
            peliculaoSerie.setTitulo(itemP.getTitulo());
            peliculaoSerie.setImagen(itemP.getImagen());
            peliculaoSerie.setCalificacion(itemP.getCalificacion());
            peliculaoSerie.setFechaDeCreacion(itemP.getFechadeCreacion());

            peliculaoSerieList.add(peliculaoSerie);
        }

        personajes.setPeliculasoSeries(peliculaoSerieList);
        return  personajes;
    }

    public PersonajeDto toDto(Personaje personaje){
        PersonajeDto personajeDto= new PersonajeDto();
        personajeDto.setId(personaje.getId_Personaje());
        personajeDto.setNombre(personaje.getNombre());
        personajeDto.setEdad((personaje.getEdad()));
        personajeDto.setImagen(personaje.getImagen());
        personajeDto.setPeso(personaje.getPeso());
        ArrayList<PeliculaoSerieSimpleDto> peliculaoSerieDtos= new ArrayList<PeliculaoSerieSimpleDto>();
        PeliculaoSerieSimpleDto peliculaoSerieDto=new PeliculaoSerieSimpleDto();
        for (PeliculasoSeries itemP: personaje.getPeliculasoSeries()){

            peliculaoSerieDto.setId(itemP.getId_PeliculaSerie());
            peliculaoSerieDto.setTitulo(itemP.getImagen());
            peliculaoSerieDto.setImagen(itemP.getImagen());
            peliculaoSerieDto.setCalificacion(itemP.getCalificacion());
            peliculaoSerieDto.setFechadeCreacion(itemP.getFechaDeCreacion());
        }
        peliculaoSerieDtos.add(peliculaoSerieDto);

        return  personajeDto;

    }

    public ArrayList<PersonajeFiltroDTO> toListDTO(ArrayList<Personaje>personajes) {
        ArrayList<PersonajeFiltroDTO> listaDTO = new ArrayList<PersonajeFiltroDTO>();
        for (Personaje item: personajes) {
            PersonajeFiltroDTO dto = new PersonajeFiltroDTO();
            dto.setNombre(item.getNombre());
            dto.setImagen(item.getImagen());

            listaDTO.add(dto);
        }
        return listaDTO;

    }

    public ArrayList<PersonajeDetalleDto> toListdetalleDTO(ArrayList<Personaje>personajes) {
        ArrayList<PersonajeDetalleDto> listaDTO = new ArrayList<PersonajeDetalleDto>();
        for (Personaje item: personajes) {
            PersonajeDetalleDto dto = new PersonajeDetalleDto();
            dto.setId_Personaje(item.getId_Personaje());
            dto.setNombre(item.getNombre());
            dto.setImagen(item.getImagen());

            dto.setPeso(item.getPeso());
            dto.setEdad(item.getEdad());

            ArrayList<PeliculaoSerieSimpleDto> peliculaoSerieSimpleDtos= new ArrayList<PeliculaoSerieSimpleDto>();
            PeliculaoSerieSimpleDto peliculaoSerieSimpleDto=new PeliculaoSerieSimpleDto();
            for (PeliculasoSeries itemP: item.getPeliculasoSeries()){


                peliculaoSerieSimpleDto.setTitulo(itemP.getImagen());
                peliculaoSerieSimpleDto.setImagen(itemP.getImagen());
                peliculaoSerieSimpleDto.setCalificacion(itemP.getCalificacion());
                peliculaoSerieSimpleDto.setFechadeCreacion(itemP.getFechaDeCreacion());
            }
            peliculaoSerieSimpleDtos.add(peliculaoSerieSimpleDto);

           // dto.setPelicula_o_Serie(peliculaoSerieDtos);
            listaDTO.add(dto);
        }
        return listaDTO;

    }

}
