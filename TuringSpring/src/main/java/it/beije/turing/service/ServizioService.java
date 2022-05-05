package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.Servizio;
import it.beije.turing.repository.ServizioRepository;

@Service
public class ServizioService {
	@Autowired
	private ServizioRepository servizioRepository;
	
	public List<Servizio> getAllServizio(){
		return servizioRepository.findAll();
	}
}
