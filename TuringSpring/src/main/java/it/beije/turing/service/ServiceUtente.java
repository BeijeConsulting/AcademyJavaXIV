package it.beije.turing.service;

import it.beije.turing.beans.Utente;
import it.beije.turing.repository.UtenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceUtente {
	
	@Autowired
	private UtenteRepository utenteRepository;

    public Utente createUser(Utente user) {
        System.out.println(user);

        if (user.getNome().isEmpty() ||
            user.getCognome().isEmpty() ||
            user.getPassword().isEmpty() ||
            user.getEmail().isEmpty()
        ) return null;
        else {

            utenteRepository.saveAndFlush(user);
            return user;
        }
    }

    public List<Utente> getUsers() {
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(Integer id) {
        return utenteRepository.findById(id).get();
    }

    public Utente getUtenteByEmail(String email) {
        return utenteRepository.findDistinctByEmail(email);
    }

    public Utente modificaUtente(Integer id, Utente user) {

        Utente old = getUtenteById(id);

        if (old != null) {
            BeanUtils.copyProperties(user, old);
            utenteRepository.saveAndFlush(user);

            return old;
        }

        return null;

    }

    public void deleteUtente(Integer id) {
        utenteRepository.deleteById(id);
    }

}
