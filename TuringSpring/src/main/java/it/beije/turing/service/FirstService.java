package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.beans.Regola;
import it.beije.turing.repository.FotoAnnuncioRepository;
import it.beije.turing.repository.RegolaRepository;

//import it.beije.turing.example.Contatto;
//import it.beije.turing.repository.ContattoRepository;


@Service
public class FirstService {

@Autowired
RegolaRepository regolaRepository;

 public List<Regola> getRegola()
 {
	return regolaRepository.findAll();
 }

 public Regola newRegola(Regola regola)
 {
	 return regolaRepository.save(regola);
 }
 
 public Regola updateRegola(Regola regola)
 {
	 Regola tmp = regolaRepository.findById(regola.getId()).get();
	 if(regola.getTitolo()!=null&&!"".equals(regola.getTitolo()))
	 {
		 tmp.setTitolo(regola.getTitolo());
	 }
	 if(regola.getDescrizione()!=null&&!"".equals(regola.getDescrizione()))
	 {
		 tmp.setDescrizione(regola.getDescrizione());
	 }
	 return regolaRepository.save(tmp);
 }
 
 public void deleteRegola(Regola regola)
 {
	 regolaRepository.deleteById(regola.getId());
 }

 
 @Autowired
 FotoAnnuncioRepository fotoAnnuncioRepository;

  public List<FotoAnnuncio> getFotoAnnuncio()
  {
 	return fotoAnnuncioRepository.findAll();
  }

  public FotoAnnuncio newFotoAnnuncio(FotoAnnuncio fotoAnnuncio)
  {
 	 return fotoAnnuncioRepository.save(fotoAnnuncio);
  }
  
  public void deleteFotoAnnuncio(FotoAnnuncio fotoAnnuncio)
  {
 	 regolaRepository.deleteById(fotoAnnuncio.getId());
  }
}
