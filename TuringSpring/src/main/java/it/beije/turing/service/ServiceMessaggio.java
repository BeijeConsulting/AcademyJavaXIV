package it.beije.turing.service;

import java.util.List;
import it.beije.turing.beans.Messaggio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.repository.MessaggioRepository;

@Service
public class ServiceMessaggio {
	@Autowired
	private MessaggioRepository messaggioRepository;
	
	public List<Messaggio> getAll(){
		return messaggioRepository.findAll();
	}
	
	
	public List<Messaggio> getByReceiverId(Integer receiverId){
		return messaggioRepository.findByReceiverId(receiverId);
	}
	
	
	
	
	
	
	
	
	
	

}
