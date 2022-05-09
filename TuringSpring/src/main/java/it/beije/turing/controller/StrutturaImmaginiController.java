package it.beije.turing.controller;

import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.service.StrutturaImmaginiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StrutturaImmaginiController {

    @Autowired
    private StrutturaImmaginiService strutturaImmaginiService;

    @GetMapping(value = "/structureImages")
    public List<StrutturaImmagini> showAllStrutturaImmagini() {
        List<StrutturaImmagini> strutturaImmaginis = strutturaImmaginiService.getAllStrutturaImmagini();
        strutturaImmaginis.forEach(System.out::println);
        return strutturaImmaginis;
    }

    @GetMapping(value = "/structuraImages/{id}")
    public StrutturaImmagini showStrutturaImmagine(@PathVariable(name = "id") Integer id) {
        return strutturaImmaginiService.findStrutturaImmagini(id);
    }

    @PostMapping(value = "/structuraImages")
    public StrutturaImmagini insertStrutturaImmagine(@RequestBody StrutturaImmagini strutturaImmagini) {

        if (strutturaImmagini.getStruttura() != null || strutturaImmagini.getImmagine()!=null) {
            strutturaImmaginiService.insertStrutturaImmagini(strutturaImmagini);
        }

        return strutturaImmagini;
    }

    @PutMapping(value = "/structuraImages/{id}")
    public StrutturaImmagini updateStrutturaImmagini(@PathVariable(name = "id") Integer id, @RequestBody StrutturaImmagini strutturaImmagini) {
        if (strutturaImmagini.getId().compareTo(id) == 0) {
            strutturaImmaginiService.updateStrutturaImmagini(id, strutturaImmagini);
        }
        return strutturaImmagini;
    }

    @DeleteMapping(value = "/structuraImages/{id}")
    public Map<String, Boolean> delStrutturaImmagini(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE /contact/" + id);

        strutturaImmaginiService.deleteStrutturaImmagini(id);

        Map map = new HashMap<String, Boolean>();
        map.put("esito", Boolean.TRUE);

        return map;
    }
}
