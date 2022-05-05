package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.Carta;
import it.beije.turing.repository.CartaRepository;

@Service
public class ServiceCarta {
	@Autowired
    private CartaRepository cartaRepository;

	public List<Carta> getAll(){
		return cartaRepository.findAll();
	}
	
	public List<Carta> getByUtenteId(Integer utente_id){
		return cartaRepository.findByUtenteId(utente_id);
	}
	
	public Carta addCarta(Carta carta) {
		if(cartaRepository.existsById(carta.getId())) {
			return null;
		}
		cartaRepository.saveAndFlush(carta);
		return carta;
	}
	
	public Carta removeCarta(Carta carta) {
		if(!cartaRepository.existsById(carta.getId())) {
			return null;
		}
		cartaRepository.delete(carta);
		return carta;
	}
}
