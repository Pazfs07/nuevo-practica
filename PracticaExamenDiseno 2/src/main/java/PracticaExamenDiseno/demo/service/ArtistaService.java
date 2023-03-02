
package PracticaExamenDiseno.demo.service;

import PracticaExamenDiseno.demo.entity.Artista;
import PracticaExamenDiseno.demo.repository.ArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernando
 */

@Service
public class ArtistaService implements IArtistaService{
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> listArtist() {
        return (List<Artista>)artistaRepository.findAll();
    }
    
}
