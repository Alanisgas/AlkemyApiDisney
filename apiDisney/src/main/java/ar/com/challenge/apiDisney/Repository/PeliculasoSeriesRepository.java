package ar.com.challenge.apiDisney.Repository;

import ar.com.challenge.apiDisney.models.PeliculasoSeries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PeliculasoSeriesRepository extends CrudRepository<PeliculasoSeries, Integer> {

    List<PeliculasoSeries> findByTitulo(String titulo);

    @Query( value ="SELECT* FROM peliculaso_series pe  WHERE pe.id=?1", nativeQuery = true)
    List <PeliculasoSeries> findByIdGenero(Integer id);

    @Query( value = "SELECT* FROM peliculaso_series ps ORDER BY ps.id_pelicula_serie =?1", nativeQuery = true)
    List<PeliculasoSeries>  findbyAscDes (String valor);

}
