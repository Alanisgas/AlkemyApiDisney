package ar.com.challenge.apiDisney.dto;

import java.util.ArrayList;

public class GeneroDto {
    private Integer id;
    private String nombre;
    private String imagen;

    private ArrayList<PeliculaoSerieSimpleDto> peliculaoSerieDto;

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

    public ArrayList<PeliculaoSerieSimpleDto> getPeliculaoSerieDto() {
        return peliculaoSerieDto;
    }

    public void setPeliculaoSerieDto(ArrayList<PeliculaoSerieSimpleDto> peliculaoSerieDto) {
        this.peliculaoSerieDto = peliculaoSerieDto;
    }
}
