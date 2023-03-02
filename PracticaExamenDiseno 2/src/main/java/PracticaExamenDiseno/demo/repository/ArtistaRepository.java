
package PracticaExamenDiseno.demo.repository;

import PracticaExamenDiseno.demo.entity.Artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernando
 */

@Repository
public interface ArtistaRepository extends CrudRepository<Artista,Long> {
    
}
