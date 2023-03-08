
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    //New code/ Revisar 
    @Controller
    @RequestMapping("/conciertos")
    public class ExamenController {

        private final IConciertoService conciertoService;
        private final IArtistaService artistaService;

        public ExamenController(IConciertoService conciertoService, IArtistaService artistaService) {
            this.conciertoService = conciertoService;
            this.artistaService = artistaService;
        }

        @RequestMapping(method = RequestMethod.GET)
        public String listarConciertos(Model model) {
            List<Concierto> conciertos = conciertoService.getAllConcert();
            model.addAttribute("titulo", "Tabla Conciertos");
            model.addAttribute("conciertos", conciertos);
            return "conciertos";
        }

        @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
        public String crearConcierto(Model model) {
            List<Artista> artistas = artistaService.listArtist();
            model.addAttribute("concierto", new Concierto());
            model.addAttribute("artistas", artistas);
            return "crear";
        }

        @RequestMapping(value = "/guardar", method = RequestMethod.POST)
        public String guardarConcierto(@ModelAttribute Concierto concierto) {
            conciertoService.saveConcert(concierto);
            return "redirect:/conciertos";
        }
    }
}