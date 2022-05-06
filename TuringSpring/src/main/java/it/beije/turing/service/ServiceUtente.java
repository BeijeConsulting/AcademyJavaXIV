package it.beije.turing.service;

import it.beije.turing.beans.Utente;
import it.beije.turing.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceUtente {
	
	@Autowired
	private UtenteRepository utenteRepository;

    public Utente creaUtente(String fname,
                             String lname,
                             String email,
                             String password) {

        if (fname.isEmpty() ||
            lname.isEmpty() ||
            email.isEmpty() ||
            password.isEmpty()
        ) return null;
        else {

            Utente newUtente = new Utente();
            newUtente.setNome(fname);
            newUtente.setCognome(lname);
            newUtente.setEmail(email);
            newUtente.setPassword(password);

            utenteRepository.saveAndFlush(newUtente);
            return newUtente;
        }
    }

    public Utente getUtenteById(Integer id) {
        return utenteRepository.findById(id).get();
    }

    public Utente getUtenteByEmail(String email) {
        return utenteRepository.findDistinctByEmail(email);
    }

    public Utente modificaUtente(String id, String fname, String lname, String email, String password) {

        Utente utente = getUtenteById(Integer.valueOf(id));
        if (utente == null) return null;
        else {

            if (!utente.getNome().equals(fname)) {
                utente.setNome(fname);
            }
            if (!utente.getCognome().equals(lname)) {
                utente.setCognome(lname);
            }
            if (!utente.getEmail().equals(email)) {
                utente.setEmail(email);
            }
            if (!utente.getPassword().equals(password)) {
                utente.setPassword(password);
            }

            utenteRepository.saveAndFlush(utente);

            return utente;
        }

    }

    public void deleteUtente(Utente utente) {
        utenteRepository.delete(utente);
    }

}
