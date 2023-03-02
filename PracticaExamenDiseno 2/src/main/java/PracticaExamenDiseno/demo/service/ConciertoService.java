
package PracticaExamenDiseno.demo.service;

import PracticaExamenDiseno.demo.entity.Concierto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import PracticaExamenDiseno.demo.repository.ConciertoRepository;

/**
 *
 * @author Fernando
 */

@Service
public class ConciertoService implements IConciertoService {
    @Autowired
    private ConciertoRepository conciertoRepository;

    @Override
    public List<Concierto> getAllConcert() {
        return (List<Concierto>)conciertoRepository.findAll();
    }

    @Override
    public Concierto getConcertById(long id) {
        return conciertoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConcert(Concierto concierto) {
        conciertoRepository.save(concierto);
    }

    @Override
    public void delete(long id) {
        conciertoRepository.deleteById(id);
    }
    
}
