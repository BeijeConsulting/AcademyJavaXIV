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
	
	public ListaServizio addListaServizio(ListaServizio listSer) {
		return listaServizioRepository.save(listSer);
	}
	
	public void removeListaServizio(Integer listaSerId) {
		listaServizioRepository.deleteById(listaSerId);
	}
	
	public boolean updateListaServizio(ListaServizio listSer, Integer listSerId) {
		if(listSer == null)
			return false;
		
		ListaServizio oldListSer = listaServizioRepository.findById(listSerId).get();
		if(listSer.getId() == oldListSer.getId())
			return false;
		
		listaServizioRepository.save(listSer);
		return true;
	}
	
}
