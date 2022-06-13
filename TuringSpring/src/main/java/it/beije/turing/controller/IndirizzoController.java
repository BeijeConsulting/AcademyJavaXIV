package it.beije.turing.controller;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.repository.IndirizzoRepository;
import it.beije.turing.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@RestController
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @GetMapping(value = "/show_all_indirizzi")
    public List<Indirizzo> showAllIndirizzi() {

        List<Indirizzo> indirizzoList = indirizzoService.getAllIndirizzi();

        return indirizzoList;
    }

    @PostMapping(value = "/insert_indirizzo")
    public Indirizzo insertNewIndirizzi(@RequestBody Indirizzo indirizzo) {

        if(indirizzo != null) {
            indirizzo = indirizzoService.insertNewIndirizzo(indirizzo);
        }

        return indirizzo;
    }

    @PutMapping(value = "/update_indirizzo/{id}")
    public Indirizzo contact(@PathVariable(name = "id") Integer id, @RequestBody Indirizzo indirizzo) {

        if (indirizzo.getId().compareTo(id) == 0) {
            indirizzoService.updateIndirizzo(id, indirizzo);
        }

        return indirizzo;
    }

    @DeleteMapping(value = "/delete_indirizzo/{id}")
    public void contact(@PathVariable(name = "id") Integer id) {

            indirizzoService.deleteIndirizzo(id);

        return;
    }
}
