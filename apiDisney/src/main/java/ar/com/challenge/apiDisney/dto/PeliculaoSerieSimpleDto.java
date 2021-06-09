package ar.com.challenge.apiDisney.dto;

import java.util.HashSet;
import java.util.Set;

public class PeliculaoSerieSimpleDto {
    private Integer id;
    private String imagen;
    private String titulo;
    private String fechadeCreacion;
    private Integer calificacion;



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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechadeCreacion() {
        return fechadeCreacion;
    }

    public void setFechadeCreacion(String fechadeCreacion) {
        this.fechadeCreacion = fechadeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }


}

