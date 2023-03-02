
package PracticaExamenDiseno.demo.repository;

import PracticaExamenDiseno.demo.entity.Concierto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernando
 */

@Repository
public interface ConciertoRepository extends CrudRepository<Concierto,Long>{
    
}
