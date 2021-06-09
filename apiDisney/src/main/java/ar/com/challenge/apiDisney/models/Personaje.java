package ar.com.challenge.apiDisney.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="personaje")
public class Personaje extends Object {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id_Personaje;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name ="pelicula_serie_personaje",joinColumns =  @JoinColumn(name = "personaje_id"),inverseJoinColumns = @JoinColumn(name = "peliculaso_serie_id"))
    @JsonIgnoreProperties({"personajes_asociados"})
    private List<PeliculasoSeries> peliculasoSeries;

    public Personaje(Integer id_Personaje, String imagen, String nombre, Integer edad, Integer peso, List<PeliculasoSeries> peliculasoSeries) {
        this.id_Personaje = id_Personaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
       this.peliculasoSeries = peliculasoSeries;
    }

    public Integer getId_Personaje() {
        return id_Personaje;
    }

    public void setId_Personaje(Integer id_Personaje) {
        this.id_Personaje = id_Personaje;
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

    public List<PeliculasoSeries> getPeliculasoSeries() {
        return peliculasoSeries;
    }

    public void setPeliculasoSeries(List<PeliculasoSeries> peliculasoSeries) {
        this.peliculasoSeries = peliculasoSeries;
    }

    public Personaje() {
    }
}
