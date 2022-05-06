package it.beije.turing.controller;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.service.StrutturaImmaginiService;
import it.beije.turing.service.StrutturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StrutturaImmaginiController {

    @Autowired
    private StrutturaImmaginiService strutturaImmaginiService;

    @RequestMapping(value = "/showAllStruttureImmagini", method = RequestMethod.GET)
    public String showAllStruttureImmagini(Model model) {
        System.out.println("HELLO");
        List<StrutturaImmagini> strutturasImmagini=strutturaImmaginiService.getAllStrutturaImmagini();
        strutturasImmagini.forEach(System.out::println);
        model.addAttribute("strutturaImmagini",strutturasImmagini);
        return "mostrastruttureimmagini";
    }

    @RequestMapping(value = "/addStructureImmagePost", method = RequestMethod.POST)
    public String addImmagePost(Model model, @RequestParam(name = "strutturaId") Struttura strutturaId,  @RequestParam(name = "immagineId") Immagine immagineId) {
        strutturaImmaginiService.addStructureImage(strutturaId, immagineId);
        return "inserisciStrutturaImmagini";
    }

    @RequestMapping(value = "/addStructureImmagePost", method = RequestMethod.GET)
    public String addStructureImmagePost() {
        return "inserisciStrutturaImmagini";
    }

    @RequestMapping(value = "/delateImmageStructurePost", method = RequestMethod.POST)
    public String delateImmageStructurePost(Model model, @RequestParam(name = "imageId") int imageId) {
        strutturaImmaginiService.delateImageStructure(imageId);
        return "eliminaStrutturaImmagini";
    }

    @RequestMapping(value = "/delateImmageStructurePost", method = RequestMethod.GET)
    public String delateImmageStructurePost() {
        return "eliminaStrutturaImmagini";
    }

    @RequestMapping(value = "/updateStrutturaImmagine", method = RequestMethod.GET)
    public String updateStrutturaImmagine() {
        return "modificaStrutturaImmagini";
    }

    @RequestMapping(value = "/updateStrutturaImmagine", method = RequestMethod.POST)
    public String updateImmagine(Model model, @RequestParam(value = "idStrutturaImmagine") Integer idStrutturaImmagine, @RequestParam(value = "strutturaId") String strutturaId, @RequestParam(value = "immagineId") String immagineId) {
        //boolean result = strutturaImmaginiService.updateStrutturaImmagine(idStrutturaImmagine, strutturaId, immagineId);
        //model.addAttribute("risultato", result);
        return "modificaStrutturaImmagini";
    }
}
