package it.beije.turing.controller;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.service.IndirizzoService;
import it.beije.turing.service.StrutturaService;
import it.beije.turing.service.TipoStrutturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StrutturaController {

    @Autowired
    private StrutturaService strutturaService;
 /*   @Autowired
    private TipoStrutturaService tipoStrutturaService;
    @Autowired
    private IndirizzoService indirizzoService;
*/
    @GetMapping(value = "/showAllStrutture")
    public List<Struttura> showAllStrutture() {
        List<Struttura> strutturas= strutturaService.getAllStruttura();
        return strutturas;
    }

   /* @RequestMapping(value = "/insertStruttura",method = RequestMethod.GET)
    public String insertNewStruttura(Model model){
        model.addAttribute("listatipostruttura", tipoStrutturaService.getAllTipoStruttura());
        model.addAttribute("lista_indirizzio",indirizzoService.getAllIndirizzi());
        return "insertstruttura";
    }*/

    @PostMapping(value = "/insertStruttura")
    public Struttura insertNewStruttura(@RequestBody Struttura struttura){

       Struttura struttura_new= strutturaService.insertNewTipoStruttura(struttura);

        return struttura_new;
    }

    /*
    @RequestMapping(value = "/deleteStruttura",method = RequestMethod.GET)
    public String deleteStruttura(){
        return "deletestruttura";
    }*/

    @DeleteMapping(value = "/deleteStruttura/{id}")
    public Map<String, Boolean> deleteStruttura(@PathVariable(name = "id") Integer idStruttura){
        boolean execute=strutturaService.deleteStruttura(idStruttura);
        Map map = new HashMap<String, Boolean>();
        map.put("esito", execute);
        return map;
    }

    /*@RequestMapping(value = "/updateStruttura",method = RequestMethod.GET)
    public String updateStruttura(Model model){
        model.addAttribute("lista_strutture", strutturaService.getAllStruttura());
        return "updatestruttura";
    }*/

   /* @RequestMapping(value = "/loadStruttura",method = RequestMethod.POST)
    public String loadStruttura(Model model,@RequestParam(value = "id_struttura") Integer idStruttura){
        System.out.println(idStruttura);

        model.addAttribute("lista_strutture", strutturaService.getAllStruttura());
        model.addAttribute("struttura", strutturaService.findStrutturaById(idStruttura));
        model.addAttribute("listatipostruttura",tipoStrutturaService.getAllTipoStruttura());
        model.addAttribute("lista_indirizzio_u",indirizzoService.getAllIndirizzi());
        return "updatestruttura";
    }*/


    @PutMapping(value = "/updateStruttura/{id}")
    public Struttura updateStruttura( @PathVariable(name = "id") Integer id_stru, @RequestBody Struttura struttura){
        Struttura s=strutturaService.updateStructure(id_stru,struttura);
        return s;
    }
}
