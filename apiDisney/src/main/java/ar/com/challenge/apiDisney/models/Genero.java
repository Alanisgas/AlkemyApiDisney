package ar.com.challenge.apiDisney.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genero")
public class Genero {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;
    private String nombre;
    private String imagen;
    @OneToMany
    @JoinColumn(name ="id")
    private List<PeliculasoSeries> peliculasoSeries;

    public Genero(Integer id, String nombre, String imagen, List peliculasoSeries) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculasoSeries = peliculasoSeries;
    }

    public Genero() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<PeliculasoSeries> getPeliculasoSeries() {
        return peliculasoSeries;
    }

    public void setPeliculasoSeries(List<PeliculasoSeries> peliculasoSeries) {
        this.peliculasoSeries = peliculasoSeries;
    }
}
