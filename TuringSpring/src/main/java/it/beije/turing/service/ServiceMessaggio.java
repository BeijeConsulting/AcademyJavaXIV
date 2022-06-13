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
	
	public List<Messaggio> getBySenderId(Integer senderId){
		return messaggioRepository.findBySenderId(senderId);
	}
	
	public List<Messaggio> getByAnnuncioId(Integer annuncioId){
		return messaggioRepository.findByAnnuncioId(annuncioId);
	}
	
	public Messaggio getByMessaggioId(Integer messaggioId){
		return messaggioRepository.findById(messaggioId).get();
	}
	
	
	public Messaggio createMessaggio(Messaggio messaggio){
		
		
			
			return messaggioRepository.saveAndFlush(messaggio);
		
		
	
	}
	

	
	public void deleteMessaggio(Messaggio messaggio) {
		if(messaggioRepository.existsById(messaggio.getId()))
		
		messaggioRepository.delete(messaggio);
	
	}
	

}


