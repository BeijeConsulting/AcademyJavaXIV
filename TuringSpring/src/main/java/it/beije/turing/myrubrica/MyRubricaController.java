package it.beije.turing.myrubrica;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyRubricaController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String mostraTutti(Model model){



        return "mostra";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(Model model){

        return "insert";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam(name = "nome") String nome,
                         @RequestParam(name = "cognome") String cognome,
                         @RequestParam(name = "categoria_email[]") List<String> cat_email,
                         @RequestParam(name = "email[]") List<String> email,
                         @RequestParam(name = "categoria_telefono[]") List<String> cat_tel,
                         @RequestParam(name = "telefono[]") List<String> tel,
                         @RequestParam(name = "note") String note){


        System.out.println( "Nome: "+nome+
                            "Cognome: "+cognome+
                            "list_Categorie email: " +cat_email+
                            "list_ Email: "+email+" "+
                            "list_Categorie telefono: " +cat_tel+
                            "list_ tel: "+tel+
                            "Note " +note);
        return "insert";
    }
}
