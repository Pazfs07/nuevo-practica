
package PracticaExamenDiseno.demo.controller;

import PracticaExamenDiseno.demo.entity.Artista;
import PracticaExamenDiseno.demo.entity.Concierto;
import PracticaExamenDiseno.demo.service.IArtistaService;
import PracticaExamenDiseno.demo.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamenController {

    @Autowired
    private IConciertoService conciertoService;

    @Autowired
    private IArtistaService artistaService;

    @GetMapping("/concierto")
    public String index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcert();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("conciertos", listaConcierto);
        return "conciertos";
    }

    @GetMapping("/conciertoN")
    public String crearConcierto(Model model) {
        List<Artista> listaArtistas = artistaService.listArtist();
        model.addAttribute("concierto", new Concierto());
        model.addAttribute("artistas", listaArtistas);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Concierto concierto){
        conciertoService.saveConcert(concierto);
        return "redirect:/concierto";
    }
    
    @GetMapping("/editConcierto/{id}")
    public String editarConcierto(@PathVariable("id") Long idConcierto, Model model){
        Concierto concierto = conciertoService.getConcertById(idConcierto);
        List<Artista> listaArtistas = artistaService.listArtist();
        model.addAttribute("concierto", concierto);
        model.addAttribute("artistas", listaArtistas);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarConcierto(@PathVariable("id") Long idConcierto){
        conciertoService.delete(idConcierto);
        return "redirect:/concierto";
    }
    
}