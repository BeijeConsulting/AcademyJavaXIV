package it.beije.turing.controller;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.service.StrutturaService;
import it.beije.turing.service.TipoStrutturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StrutturaController {

    @Autowired
    private StrutturaService strutturaService;
    @Autowired
    private TipoStrutturaService tipoStrutturaService;


    @RequestMapping(value = "/showAllStrutture", method = RequestMethod.GET)
    public String showAllStrutture(Model model) {
        List<Struttura> strutturas= strutturaService.getAllStruttura();
        model.addAttribute("strutture",strutturas);
        return "mostrastrutture";
    }

    @RequestMapping(value = "/insertStruttura",method = RequestMethod.GET)
    public String insertNewStruttura(Model model){
        model.addAttribute("listatipostruttura", tipoStrutturaService.getAllTipoStruttura());
        return "insertstruttura";
    }
    @RequestMapping(value = "/insertStruttura",method = RequestMethod.POST)
    public String insertNewStruttura(Model model, @RequestParam(value = "descrizione") String descrizione, @RequestParam(value = "tipo-strutture") Integer idTipoStrutture, @RequestParam(value = "id_indirizzo") Integer id_indirizzo, @RequestParam(value = "id_utente" ,required = false) Integer id_utente){

        System.out.println( "Descrizione: " +descrizione+
                            "\ntipo-strutture: "+idTipoStrutture+
                            "\nid indirizzo: "+id_indirizzo+
                            "\nid_utente: "+id_utente);

        strutturaService.insertNewTipoStruttura(descrizione,idTipoStrutture,null,null);
        model.addAttribute("listatipostruttura",tipoStrutturaService.getAllTipoStruttura());

        return "insertstruttura";
    }


    @RequestMapping(value = "/deleteStruttura",method = RequestMethod.GET)
    public String deleteStruttura(){
        return "deletestruttura";
    }

    @RequestMapping(value = "/deleteStruttura",method = RequestMethod.POST)
    public String deleteStruttura(Model model, @RequestParam(value = "id_struttura") Integer idStruttura){
        boolean execute=strutturaService.deleteStruttura(idStruttura);
        model.addAttribute("risultato", execute);
        return "deletestruttura";
    }
}
