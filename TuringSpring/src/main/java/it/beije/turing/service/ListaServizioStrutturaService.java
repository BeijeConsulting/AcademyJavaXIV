package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.turing.beans.ListaServizioStruttura;
import it.beije.turing.repository.ListaServizioStrutturaRepository;

@Service
public class ListaServizioStrutturaService {
	@Autowired
	private ListaServizioStrutturaRepository listRep;
	
	public List<ListaServizioStruttura> getAllListaServizioStruttura(){
		return listRep.findAll();
	}
	
	public ListaServizioStruttura addListaServizioStruttura(ListaServizioStruttura listSerStr) {
		return listRep.save(listSerStr);
	}
	
	public void removeListaServizio(Integer listaSerStrId) {
		listRep.deleteById(listaSerStrId);
	}
	
	public boolean updateListaServizioStruttura(ListaServizioStruttura listSerStr, Integer listSerStrId) {
		if(listSerStr == null)
			return false;
		
		ListaServizioStruttura oldListSer = listRep.findById(listSerStrId).get();
		if(listSerStr.getId() == oldListSer.getId())
			return false;
		
		listRep.save(listSerStr);
		return true;
	}
	
}
