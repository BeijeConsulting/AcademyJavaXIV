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
	
	/***
	 * 
	 * @param listSer
	 * @return The new added object ListaServizio or null if the ListaServizio passed has both getAnnuncioId and getStrutturaId initialized
	 */
	public ListaServizio addListaServizio(ListaServizio listSer) {
		if(listSer.getAnnuncioId() != null && listSer.getStrutturaId() != null)
			return null;
		
		return listaServizioRepository.save(listSer);
	}
	
	/***
	 * Removes the ListaServizio in the database with the same id passed
	 * @param listaSerId
	 */
	public void removeListaServizio(int listaSerId) {
		listaServizioRepository.deleteById(listaSerId);
	}
	
	/***
	 * 
	 * @param listSer
	 * @param listSerId
	 * @return false if the paramether listSer passed is null or has both getAnnuncioId and getStrutturaId initialized
	 */
	public boolean updateListaServizio(ListaServizio listSer, Integer listSerId) {
		if(listSer == null)
			return false;
		if(listSer.getAnnuncioId() != null && listSer.getStrutturaId() != null)
			return false;
		
		ListaServizio oldListSer = listaServizioRepository.findById(listSerId).get();
		oldListSer.setAnnuncioId(listSer.getAnnuncioId());
		oldListSer.setStrutturaId(listSer.getStrutturaId());
		listaServizioRepository.save(listSer);
		return true;
	}
	
}
