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
	
	public List<Messaggio> annuncioId(Integer annuncioId){
		return messaggioRepository.findByAnnuncioId(annuncioId);
	}
	
	
	public Messaggio CreateMessaggio(String testo, 
			 String dataOra){
		
		Messaggio messaggio = new Messaggio();
		
		if(testo != null && dataOra != null) { 
			messaggio.setTesto(testo);
			messaggio.setDataOra(dataOra);
			
			return messaggioRepository.saveAndFlush(messaggio);
		}
		
		return null;
	}
	
	
	
	
	
	public void DeleteMessaggio(Integer messaggioId) {
		messaggioRepository.deleteById(messaggioId);
		}
	

}


