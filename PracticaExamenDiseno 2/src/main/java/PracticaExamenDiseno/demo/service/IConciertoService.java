
package PracticaExamenDiseno.demo.service;

import PracticaExamenDiseno.demo.entity.Concierto;
import java.util.List;

/**
 *
 * @author Fernando
 */
public interface IConciertoService {
    public List<Concierto> getAllConcert();
    public Concierto getConcertById (long id);
    public void saveConcert (Concierto concierto);
    public void delete (long id);
}
