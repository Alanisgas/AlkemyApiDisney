package ar.com.challenge.apiDisney.Services;

import ar.com.challenge.apiDisney.Repository.PeliculasoSeriesRepository;
import ar.com.challenge.apiDisney.Repository.PersonajeRepository;

import ar.com.challenge.apiDisney.dto.PeliculaoSerieSimpleDto;
import ar.com.challenge.apiDisney.dto.PeliculasoSeriesFiltroDTO;
import ar.com.challenge.apiDisney.models.PeliculasoSeries;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PeliculaoSerieService {
    @Autowired
    private PeliculasoSeriesRepository peliculasoSeriesRepository;


    private Object List;
    private Object PersonajeDto;
    private Object ArrayList;

    @JsonIgnoreProperties
    public ArrayList<PeliculasoSeriesFiltroDTO> obtenerPersonajeSerie(){
        return toListDTO((ArrayList<PeliculasoSeries>) peliculasoSeriesRepository.findAll()); }

    public  PeliculasoSeries guardarPeliculaoSerie(PeliculaoSerieSimpleDto peliculaoSerieDto){
        PeliculasoSeries peliculasoSeries= toEntity(peliculaoSerieDto);

        return  peliculasoSeriesRepository.save(peliculasoSeries);}


    public PeliculaoSerieSimpleDto getPeliSerieID(Integer idPeliculaSerie){
        return toDtoId(peliculasoSeriesRepository.findById(idPeliculaSerie).get());
    }

    public  String eliminarPeliculaoSerie(Integer idPelSe){
        peliculasoSeriesRepository.deleteById(idPelSe);
        return "Ok";
    }


    public  PeliculaoSerieSimpleDto toDtoId(PeliculasoSeries peliculasoSeries){
        PeliculaoSerieSimpleDto peliculaoSerieDto= new PeliculaoSerieSimpleDto();
        peliculaoSerieDto.setId(peliculasoSeries.getId_PeliculaSerie());
        peliculaoSerieDto.setImagen(peliculasoSeries.getImagen());
        peliculaoSerieDto.setTitulo(peliculasoSeries.getTitulo());
        peliculaoSerieDto.setFechadeCreacion(peliculasoSeries.getFechaDeCreacion());
        peliculaoSerieDto.setCalificacion(peliculasoSeries.getCalificacion());


        return peliculaoSerieDto;

    }
    public ArrayList<PeliculasoSeries> obtenerPeliculaXNombre(String titulo){
        return (ArrayList<PeliculasoSeries>) peliculasoSeriesRepository.findByTitulo(titulo);
    }
    public ArrayList<PeliculasoSeries> obtenerPeliculaoSerieAscDes (String ascDes)
    {
        return (ArrayList<PeliculasoSeries>) peliculasoSeriesRepository.findbyAscDes(ascDes);
    }
    public ArrayList<PeliculasoSeries> ObtenerIdGenero(Integer idGe){
        return (ArrayList<PeliculasoSeries>) peliculasoSeriesRepository.findByIdGenero(idGe);
    }

    public PeliculasoSeries updatePelSe(PeliculaoSerieSimpleDto peliculaoSerieDto){
        PeliculasoSeries peliculasoSeriesOriginal= peliculasoSeriesRepository.findById(peliculaoSerieDto.getId()).orElse(null);
        peliculasoSeriesOriginal.setTitulo(peliculaoSerieDto.getTitulo());
        peliculasoSeriesOriginal.setCalificacion(peliculaoSerieDto.getCalificacion());
        peliculasoSeriesOriginal.setFechaDeCreacion(peliculaoSerieDto.getFechadeCreacion());
        peliculasoSeriesOriginal.setImagen(peliculaoSerieDto.getImagen());


        return  peliculasoSeriesRepository.save(peliculasoSeriesOriginal);

    }

    public  ArrayList<PeliculasoSeriesFiltroDTO> toListDTO(ArrayList<PeliculasoSeries> peliculasoSeries){
        ArrayList<PeliculasoSeriesFiltroDTO> listaPeliculasDTO= new ArrayList<PeliculasoSeriesFiltroDTO>();
        for (PeliculasoSeries item: peliculasoSeries){
            PeliculasoSeriesFiltroDTO peliculaoSerieDto = new PeliculasoSeriesFiltroDTO();
            peliculaoSerieDto.setImagen(item.getImagen());
            peliculaoSerieDto.setTitulo(item.getTitulo());
            peliculaoSerieDto.setFechade_creacion(item.getFechaDeCreacion());

            listaPeliculasDTO.add(peliculaoSerieDto);
        }

        return  listaPeliculasDTO;
    }

    public PeliculasoSeries toEntity(PeliculaoSerieSimpleDto peliculaoSerieDto){
        PeliculasoSeries peliculasoSeries= new PeliculasoSeries();
        peliculasoSeries.setImagen((peliculaoSerieDto.getImagen()));
        peliculasoSeries.setTitulo(peliculaoSerieDto.getTitulo());
        peliculasoSeries.setCalificacion(peliculaoSerieDto.getCalificacion());
        peliculasoSeries.setFechaDeCreacion(peliculaoSerieDto.getFechadeCreacion());



        return  peliculasoSeries;

    }
    public  ArrayList<PeliculasoSeries> toEntityList(ArrayList<PeliculaoSerieSimpleDto> peliculasoSeries){
        ArrayList<PeliculasoSeries> listaPeliculas= new ArrayList<PeliculasoSeries>();
        for (PeliculaoSerieSimpleDto item: peliculasoSeries){
            PeliculasoSeries pelioSerie = new PeliculasoSeries();
            pelioSerie.setImagen(item.getImagen());
            pelioSerie.setTitulo(item.getTitulo());
            pelioSerie.setCalificacion(item.getCalificacion());
            pelioSerie.setId_PeliculaSerie(item.getId());
            pelioSerie.setFechaDeCreacion(item.getFechadeCreacion());

            listaPeliculas.add(pelioSerie);
        }

        return  listaPeliculas;
    }

}

