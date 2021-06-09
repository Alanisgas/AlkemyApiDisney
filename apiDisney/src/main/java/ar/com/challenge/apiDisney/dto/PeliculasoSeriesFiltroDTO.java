package ar.com.challenge.apiDisney.dto;

public class PeliculasoSeriesFiltroDTO {

    private String imagen;
    private String titulo;
    private String fechade_creacion;

    public PeliculasoSeriesFiltroDTO() {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechade_creacion = fechade_creacion;
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

    public String getFechade_creacion() {
        return fechade_creacion;
    }

    public void setFechade_creacion(String fechade_creacion) {
        this.fechade_creacion = fechade_creacion;
    }
}
