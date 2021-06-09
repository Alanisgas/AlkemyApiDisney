package ar.com.challenge.apiDisney.dto;

import java.util.ArrayList;

public class PersonajeDetalleDto {
    private Integer id_Personaje;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private ArrayList<PeliculaoSerieSimpleDto> pelicula_o_Serie;

    public Integer getId_Personaje() {
        return id_Personaje;
    }

    public void setId_Personaje(Integer id_Personaje) {
        this.id_Personaje = id_Personaje;
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

    public ArrayList<PeliculaoSerieSimpleDto> getPelicula_o_Serie() {
        return pelicula_o_Serie;
    }

    public void setPelicula_o_Serie(ArrayList<PeliculaoSerieSimpleDto> pelicula_o_Serie) {
        this.pelicula_o_Serie = pelicula_o_Serie;
    }
}
