package ar.com.challenge.apiDisney.dto;

import ar.com.challenge.apiDisney.models.PeliculasoSeries;

import java.util.ArrayList;
import java.util.List;

public class PersonajeDto {
    private Integer id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;

    private ArrayList<PeliculaoSerieSimpleDto> peliculasoSeries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }



    public ArrayList<PeliculaoSerieSimpleDto> getPeliculasoSeries() {
        return peliculasoSeries;
    }

    public void setPeliculasoSeries(ArrayList<PeliculaoSerieSimpleDto> peliculasoSeries) {
        this.peliculasoSeries = peliculasoSeries;
    }
}
