package ar.com.challenge.apiDisney.Services;

import ar.com.challenge.apiDisney.Repository.GeneroRepository;
import ar.com.challenge.apiDisney.Repository.PeliculasoSeriesRepository;
import ar.com.challenge.apiDisney.dto.GeneroDto;
import ar.com.challenge.apiDisney.dto.PeliculaoSerieSimpleDto;
import ar.com.challenge.apiDisney.models.Genero;
import ar.com.challenge.apiDisney.models.PeliculasoSeries;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private PeliculasoSeriesRepository peliculasoSeriesRepository;


    public ArrayList<Genero> obtenerGenero(){

        return (ArrayList<Genero>) generoRepository.findAll();
    }

    public  Genero guardarGenero(GeneroDto generoDto){
        Genero gen=toEntity(generoDto);

        for (PeliculasoSeries g: gen.getPeliculasoSeries()){
            PeliculasoSeries peliculaSave= new PeliculasoSeries();
            PeliculasoSeries peliculasoSeries = peliculasoSeriesRepository.findById(g.getId_PeliculaSerie()).orElse(null);
            if(peliculasoSeries== null){
                peliculaSave= peliculasoSeriesRepository.save(g);
                g.setId_PeliculaSerie(peliculaSave.getId_PeliculaSerie());
            }else{
                g.setId_PeliculaSerie(peliculaSave.getId_PeliculaSerie());
            }

        }


        return generoRepository.save(gen);
    }
    public  String eliminarGenero(Integer idGenero){
        generoRepository.deleteById(idGenero);
        return  "ok";
    }

    public Genero getGenero(Integer id){
        return generoRepository.findById(id).get();
    }

    public Genero updateGenero(GeneroDto generoDto){
        Genero generoOriginal= generoRepository.findById(generoDto.getId()).orElse(null);
        generoOriginal.setNombre(generoDto.getNombre());
        generoOriginal.setImagen(generoDto.getImagen());
        return generoRepository.save(generoOriginal);
    }

    public  Genero toEntity(GeneroDto generoDto){
        Genero genero = new Genero();
        genero.setNombre(generoDto.getNombre());
        genero.setImagen(generoDto.getImagen());
        ArrayList<PeliculasoSeries> peliculasoSeries=new ArrayList<PeliculasoSeries>();
                for (PeliculaoSerieSimpleDto itemP: generoDto.getPeliculaoSerieDto()){
                    PeliculasoSeries pelsel=  new PeliculasoSeries();
                    pelsel.setId_PeliculaSerie(itemP.getId());
                    pelsel.setTitulo(itemP.getTitulo());
                    pelsel.setImagen(itemP.getImagen());
                    pelsel.setCalificacion(itemP.getCalificacion());
                    pelsel.setFechaDeCreacion(itemP.getFechadeCreacion());

                    peliculasoSeries.add(pelsel);
                }
                genero.setPeliculasoSeries(peliculasoSeries);
        return  genero;
    }

}

