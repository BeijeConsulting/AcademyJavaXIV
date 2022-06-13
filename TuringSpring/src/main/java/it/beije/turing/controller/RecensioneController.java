package it.beije.turing.controller;

import it.beije.turing.beans.Recensione;
import it.beije.turing.service.ServiceRecensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecensioneController {

    @Autowired
    private ServiceRecensione serviceRecensione;

    @GetMapping(value = "/reviews")
    public List<Recensione> reviews() {
        System.out.println("GET /reviews " + this.toString());
        List<Recensione> recensioni = serviceRecensione.getAllRecensione();
        return recensioni;
    }

    @GetMapping(value = "/review/{id}")
    public Recensione review(@PathVariable(name = "id") Integer id) {
        System.out.println("GET /review/" + id);

        return serviceRecensione.findRecensione(id);
    }

    @PostMapping(value = "/review")
    public Recensione review(@RequestBody Recensione recensione) {
        System.out.println("POST /review -> " + recensione);

        if (recensione.getTesto() != null) {
			serviceRecensione.creaRecensione(recensione);
        }
        return recensione;
    }

    @PutMapping(value = "/review/{id}")
    public Recensione review(@PathVariable(name = "id") Integer id, @RequestBody Recensione recensione) {
        System.out.println("PUT /review/ " + id + " -> " + recensione);

        if (recensione.getId().compareTo(id) == 0) {
            serviceRecensione.updateRecensione(recensione, id);
        }
        return recensione;
    }

    @DeleteMapping(value = "/review/{id}")
    public void delReview(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE /review/" + id);
        serviceRecensione.rimuoviRecensione(id);
    }

}
