package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.ListaServizio;
import it.beije.turing.repository.ListaServizioRepository;

@Service
public class ListaServizioService {
	@Autowired
	private ListaServizioRepository listaServizioRepository;
	
	public List<ListaServizio> getAllListaServizio(){
		return listaServizioRepository.findAll();
	}
}
