package it.beije.turing.controller;

import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.service.ServiceFotoAnnuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class FotoAnnuncioController {

    @Autowired
    private ServiceFotoAnnuncio service;

    //@RequestMapping(value = "/elenco_rest", method = RequestMethod.GET)
    @GetMapping(value = "/foto_annunci")
    public List<FotoAnnuncio> contacts() {
        System.out.println("GET /foto_annunci " + this.toString());

        List<FotoAnnuncio> list = service.getFotoAnnuncio();
        for (FotoAnnuncio a:list) {
            System.out.println(a);
        }


        return list;
    }

    @GetMapping(value = "/foto_annuncio/{id}")
    public Optional<FotoAnnuncio> contact(@PathVariable(name = "id") Integer id) {
        System.out.println("GET /foto_annuncio/" + id);

        return service.getFotoAnnuncioById(id);
    }

    @PostMapping(value = "/foto_annuncio")
    public FotoAnnuncio contact(@RequestBody FotoAnnuncio fotoAnnuncio) {
        System.out.println("POST /foto_annuncio -> " + fotoAnnuncio);

        if (fotoAnnuncio.getAnnuncio() != null || fotoAnnuncio.getImmagineId() != null) {
            service.newFotoAnnuncio(fotoAnnuncio);
        }

        return fotoAnnuncio;
    }

    @PutMapping(value = "/foto_annuncio/{id}")
    public FotoAnnuncio contact(@PathVariable(name = "id") Integer id, @RequestBody FotoAnnuncio fotoAnnuncio) {
        System.out.println("PUT /foto_annuncio/ " + id + " -> " + fotoAnnuncio);

        if (fotoAnnuncio.getId().compareTo(id) == 0) {
            service.updateFotoAnnuncio(fotoAnnuncio,id);
        }

        return fotoAnnuncio;
    }

    @DeleteMapping(value = "/foto_annuncio/{id}")
    public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE /foto_annuncio/" + id);

        service.deleteFotoAnnuncio(id);

        Map map = new HashMap<String, Boolean>();
        map.put("esito", Boolean.TRUE);

        return map;
    }

}
