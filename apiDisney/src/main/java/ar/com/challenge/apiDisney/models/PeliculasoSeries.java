package ar.com.challenge.apiDisney.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="peliculasoSeries")
public class PeliculasoSeries {
    @javax.persistence.Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id_PeliculaSerie;
    private  String imagen;
    private String titulo;
    private  String fechaDeCreacion;
    private  Integer calificacion;


    public PeliculasoSeries() {
    }

    public PeliculasoSeries(Integer id_PeliculaSerie, String imagen, String titulo, String fechaDeCreacion, Integer calificacion, List<Personaje> personajesAsociados) {
        this.id_PeliculaSerie = id_PeliculaSerie;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;

    }

    public Integer getId_PeliculaSerie() {
        return id_PeliculaSerie;
    }

    public void setId_PeliculaSerie(Integer id_PeliculaSerie) {
        this.id_PeliculaSerie = id_PeliculaSerie;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }


}

