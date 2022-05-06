package it.beije.turing.controller;

import it.beije.turing.beans.Immagine;
import it.beije.turing.service.ImmagineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ImmagineController {

    @Autowired
    private ImmagineService immagineService;

    @RequestMapping(value = "/showAllImmagini", method = RequestMethod.GET)
    public String showAllImmagini(Model model) {
        List<Immagine> immagines=immagineService.getAllImmagine();
        immagines.forEach(System.out::println);
        model.addAttribute("immagini",immagines);
        return "mostraimmagini";
    }

    @RequestMapping(value = "/addImmagePost", method = RequestMethod.POST)
    public String addImmagePost(Model model, @RequestParam(name = "urlImage") String urlImage) {
        immagineService.addImage(urlImage);
        return "inserisciImmagine";
    }

    @RequestMapping(value = "/addImmagePost", method = RequestMethod.GET)
    public String addImmagePost() {
        return "inserisciImmagine";
    }

    @RequestMapping(value = "/delateImmagePost", method = RequestMethod.POST)
    public String delateImmagePost(Model model, @RequestParam(name = "structureImageId") int structureImageId) {
        immagineService.delateImmagine(structureImageId);
        return "eliminaImmagine";
    }

    @RequestMapping(value = "/delateImmagePost", method = RequestMethod.GET)
    public String delateImmagePost() {
        return "eliminaImmagine";
    }

    @RequestMapping(value = "/updateImmagine",method = RequestMethod.GET)
    public String updateImmagine(){
        return "updatetipostruttura";
    }

    @RequestMapping(value = "/updateImmagine",method = RequestMethod.POST)
    public String updateImmagine(Model model, @RequestParam(value = "idImmagine") Integer idImmagine ,@RequestParam(value = "urlImage") String urlImage){
        boolean result= immagineService.updateTipoStruttura(idImmagine,urlImage);
        model.addAttribute("risultato", result);
        return "updatetipostruttura";
    }
}
