package it.beije.turing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	
//	public List<Carta> getByUtenteId(Integer utenteId) {
//		return cartaRepository.findByUtenteId(utenteId);
//	}
	
	public Carta addCarta(Carta carta) {
		if(cartaRepository.existsById(carta.getId())) {
			return null;
		}
		Carta c = cartaRepository.saveAndFlush(carta);
		return c;
	}

	public Carta removeCarta(Carta carta) {
		if(!cartaRepository.existsById(carta.getId())) {
			return null;
		}
		cartaRepository.delete(carta);
		return carta;
	}
	
	public Carta findCarta(Integer id) {
		Optional<Carta> c = cartaRepository.findById(id);
		return c.isPresent() ? c.get() : null; 
	}
	
	public Carta updateCarta(Integer IdCarta, Carta carta) {
		Carta old = findCarta(IdCarta);
		
		if(old != null) {
			BeanUtils.copyProperties(carta, old);
			old = cartaRepository.saveAndFlush(old);
			
			return old;
		}
		
		return null;
	}
}
