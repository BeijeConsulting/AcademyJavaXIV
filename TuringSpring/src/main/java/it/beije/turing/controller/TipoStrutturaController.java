package it.beije.turing.controller;


import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.service.TipoStrutturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TipoStrutturaController {
    @Autowired
    private TipoStrutturaService tipoStrutturaService;

    @GetMapping(value = "/showAllTipoStruttura")
    public List<TipoStruttura> showAllTipoStrutture() {
        List<TipoStruttura> tipoStrutturas=tipoStrutturaService.getAllTipoStruttura();
        return tipoStrutturas;
    }

   /* @RequestMapping(value = "/insertTipoStruttura",method = RequestMethod.GET)
    public String insertNewTipoStruttura(){
        return "inserttipostruttura";
    }*/

    @PostMapping(value = "/insertTipoStruttura")
    public TipoStruttura insertNewTipoStruttura(@RequestBody TipoStruttura tipo){
        TipoStruttura ntipo=tipoStrutturaService.insertNewTipoStruttura(tipo);
        return ntipo;
    }

   /* @RequestMapping(value = "/deleteTipoStruttura",method = RequestMethod.GET)
    public String deleteTipoStruttura(){
        return "deletetipostruttura";
    }*/

    @DeleteMapping(value = "/deleteTipoStruttura/{id}")
    public Map<String, Boolean> deleteTipoStruttura(@PathVariable(name = "id") Integer id){
        boolean execute=tipoStrutturaService.deleteTipoStruttura(id);
        Map map = new HashMap<String, Boolean>();
        map.put("esito", execute);
        return map;
    }
  /*  @RequestMapping(value = "/updateTipoStruttura",method = RequestMethod.GET)
    public String updateTipoStruttura(){
        return "updatetipostruttura";
    }*/

    @PutMapping(value = "/updateTipoStruttura/{id}")
    public TipoStruttura updateTipoStruttura(@PathVariable(name = "id") Integer id, @RequestBody TipoStruttura tipoStruttura){

        TipoStruttura execute= tipoStrutturaService.updateTipoStruttura(id,tipoStruttura);

        return execute;
    }

   /* @RequestMapping(value = "/searchTipoStruttura",method = RequestMethod.GET)
    public String searchTipoStruttura(){
        return "searchtipostruttura";
    }*/

    @GetMapping (value = "/searchTipoStruttura/search/{str}")
    public List<TipoStruttura> searchTipoStruttura( @PathVariable(name = "str") String tipoStruttura){
        List<TipoStruttura> execute= tipoStrutturaService.searchTipoStruttura(tipoStruttura);
        return execute;
    }
}
