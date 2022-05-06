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
	
	public Servizio addServizio(String urlImg, String nome) {
		Servizio servizio = new Servizio();
		servizio.setNome(nome);
		servizio.setUrlImg(urlImg);
		return servizioRepository.save(servizio);
	}
	
	public void removeServizio(Integer servizioId) {
		servizioRepository.deleteById(servizioId);
		
	}
	
	public Servizio updateServizio(Servizio servizio, Integer servizioId) {
		Servizio oldServizio = servizioRepository.findById(servizioId).get();
		if(servizio.getNome() != null && servizio.getNome() != "")
			oldServizio.setNome(servizio.getNome());
		if(servizio.getUrlImg() != null && servizio.getUrlImg() != "")
			oldServizio.setUrlImg(servizio.getUrlImg());
		
		return servizioRepository.save(oldServizio);
	}
	
	
	
}
