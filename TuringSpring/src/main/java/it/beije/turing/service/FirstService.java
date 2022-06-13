//package it.beije.turing.service;
//
//import java.util.Objects;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.fasterxml.jackson.databind.util.BeanUtil;
//
//import it.beije.turing.example.Contatto;
//import it.beije.turing.beans.FotoAnnuncio;
//import it.beije.turing.beans.ListaRegole;
//import it.beije.turing.beans.Annuncio;
//import it.beije.turing.beans.Regola;
//import it.beije.turing.beans.PeriodoPrenotato;
//
//import it.beije.turing.repository.AnnuncioRepository;
//import it.beije.turing.repository.FotoAnnuncioRepository;
//import it.beije.turing.repository.ListaRegoleRepository;
//import it.beije.turing.repository.RegolaRepository;
//import it.beije.turing.repository.PeriodoPrenotatoRepository;
//
//
//@Service
//public class FirstService {
//	
//	
//	
//	public List<Contatto> leggiRubrica() {
//		
//		System.out.println("leggiRubrica..." + this.toString());
//		
////		Contatto c1 = new Contatto();
////		c1.setCognome("Rossi");
////		c1.setNome("Mario");
////		c1.setTelefono("1234566");
////		
////		Contatto c2 = new Contatto();
////		c2.setCognome("Bianchi");
////		c2.setNome("Marco");
////		c2.setTelefono("1234568");
//		
////		List<Contatto> list = new ArrayList<Contatto>();
////		list.add(c1);
////		list.add(c2);
//		
////		List<Contatto> list = contattoRepository.findByCognomeAndNome("Verde", "Piero");
////		List<Contatto> list = contattoRepository.searchByEmail("m.rossi@beije.it");
//		List<Contatto> list = contattoRepository.findAll();
////		for (Contatto c : list) {
////			System.out.println(c);
////		}
//
//		return list;
//	}
//	
//	public Contatto findContatto(Integer id) {
//		Optional<Contatto> c = contattoRepository.findById(id);
//		return c.isPresent() ? c.get() : null; 
//	}
//	
//	public Contatto insertContatto(Contatto contatto) {
//		return contattoRepository.save(contatto);
//	}
//
//	public Contatto updateContatto(Integer id, Contatto contatto) {
//		Contatto old = findContatto(id);
//		
//		if (old != null) {
//			BeanUtils.copyProperties(contatto, old);
//			contattoRepository.save(old);
//			
//			return old;
//		}
//		
//		return null;
//	}
//	
//	public void deleteContatto(Integer id) {
//		contattoRepository.deleteById(id);
//	}
//	
//
//}
//
