package it.beije.turing.service;

import java.util.List;
import it.beije.turing.beans.Messaggio;

import org.springframework.stereotype.Service;

import it.beije.turing.repository.MessaggioRepository;

@Service
public class ServiceMessaggio {
	private MessaggioRepository messaggioRepository;
	
	public List<Messaggio> getAll(){
		return messaggioRepository.findAll();
	}
	
	
	public List<Messaggio> getbyUtenteId(Integer utente_id){
		return messaggioRepository.findByUtendeId(utente_id);
	}
	
	
	
	
	
	
	
	
	
	

}
