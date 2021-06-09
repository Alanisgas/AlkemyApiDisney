package ar.com.challenge.apiDisney.Repository;

import ar.com.challenge.apiDisney.models.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje,Integer> {

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(Integer edad);
    @Query( value = "SELECT* FROM personaje p INNER JOIN pelicula_serie_personaje ps ON ps.personaje_id=p.id_personaje WHERE ps.peliculaso_serie_id=?1", nativeQuery = true)
     List<Personaje> findByMovieId(Integer id);
}
