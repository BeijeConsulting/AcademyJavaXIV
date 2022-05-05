package it.beije.turing.controller;


import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.service.TipoStrutturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TipoStrutturaController {
    @Autowired
    private TipoStrutturaService tipoStrutturaService;



    @RequestMapping(value = "/showAllTipoStruttura", method = RequestMethod.GET)
    public String showAllTipoStrutture(Model model) {
        List<TipoStruttura> tipoStrutturas=tipoStrutturaService.getAllTipoStruttura();
      //  tipoStrutturas.forEach(System.out::println);
        model.addAttribute("tipostrutture",tipoStrutturas);
        return "mostratipostruttura";
    }


    @RequestMapping(value = "/insertTipoStruttura",method = RequestMethod.GET)
    public String insertNewTipoStruttura(){
        return "inserttipostruttura";
    }

    @RequestMapping(value = "/insertTipoStruttura",method = RequestMethod.POST)
    public String insertNewTipoStruttura(Model model, @RequestParam(value = "tipo") String tipo){
        boolean execute=tipoStrutturaService.insertNewTipoStruttura(tipo);
        model.addAttribute("risultato", execute);
        return "inserttipostruttura";
    }

    @RequestMapping(value = "/deleteTipoStruttura",method = RequestMethod.GET)
    public String deleteTipoStruttura(){
        return "deletetipostruttura";
    }

    @RequestMapping(value = "/deleteTipoStruttura",method = RequestMethod.POST)
    public String deleteTipoStruttura(Model model, @RequestParam(value = "id_tipo") Integer idtipo){
        boolean execute=tipoStrutturaService.deleteTipoStruttura(idtipo);
        model.addAttribute("risultato", execute);
        return "deletetipostruttura";
    }
    @RequestMapping(value = "/updateTipoStruttura",method = RequestMethod.GET)
    public String updateTipoStruttura(){
        return "updatetipostruttura";
    }

    @RequestMapping(value = "/updateTipoStruttura",method = RequestMethod.POST)
    public String updateTipoStruttura(Model model, @RequestParam(value = "id_tipo") Integer idtipo,@RequestParam(value = "tipo") String tipo){
        boolean execute= tipoStrutturaService.updateTipoStruttura(idtipo,tipo);
        model.addAttribute("risultato", execute);
        return "updatetipostruttura";
    }

    @RequestMapping(value = "/searchTipoStruttura",method = RequestMethod.GET)
    public String searchTipoStruttura(){
        return "searchtipostruttura";
    }

    @RequestMapping(value = "/searchTipoStruttura",method = RequestMethod.POST)
    public String searchTipoStruttura(Model model,@RequestParam(value = "tipo") String tipo){
        List<TipoStruttura> execute= tipoStrutturaService.searchTipoStruttura(tipo);
        model.addAttribute("lista", execute);
        return "searchtipostruttura";
    }
}
