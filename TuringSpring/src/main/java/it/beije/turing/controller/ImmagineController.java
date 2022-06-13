package it.beije.turing.controller;

import it.beije.turing.beans.Immagine;
import it.beije.turing.service.ImmagineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImmagineController {

    @Autowired
    private ImmagineService immagineService;

    @GetMapping(value = "/images")
    public List<Immagine> showAllImmagini() {
        List<Immagine> images = immagineService.getAllImmagine();
        images.forEach(System.out::println);
        return images;
    }

    @GetMapping(value = "/image/{id}")
    public Immagine showImmagine(@PathVariable(name = "id") Integer id) {
        System.out.println("GET /contact/" + id);
        return immagineService.findContatto(id);
    }

    @PostMapping(value = "/image")
    public Immagine insertImmagine(@RequestBody Immagine immagine) {
        System.out.println("POST /contact -> " + immagine);

        if (immagine.getUrlImage() != null ) {
            immagineService.insertImmagine(immagine);
        }

        return immagine;
    }


    @PutMapping(value = "/image/{id}")
    public Immagine updateImmagine(@PathVariable(name = "id") Integer id, @RequestBody Immagine immagine) {
        if (immagine.getId().compareTo(id) == 0) {
            immagineService.updateImmagine(id, immagine);
        }
        return immagine;
    }

    @DeleteMapping(value = "/image/{id}")
    public Map<String, Boolean> delImmagine(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE /contact/" + id);

        immagineService.deleteImmagine(id);

        Map map = new HashMap<String, Boolean>();
        map.put("esito", Boolean.TRUE);

        return map;
    }
}
