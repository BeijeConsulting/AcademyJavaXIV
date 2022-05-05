package it.beije.turing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.PeriodoPrenotato;
import it.beije.turing.repository.PeriodoPrenotatoRepository;

@Service
public class FirstService {
	
	@Autowired
	private PeriodoPrenotatoRepository periodoPrenotatoRepository;
	
	public List<PeriodoPrenotato>  getPeriodiPrenotati() {
		return (List<PeriodoPrenotato>) periodoPrenotatoRepository.findAll();
	}
	
	public PeriodoPrenotato newPeriodoPrenotato(PeriodoPrenotato periodoPrenotato, Integer periodoPrenotatoId) {
		
		PeriodoPrenotato periodoPrenotatoDB = periodoPrenotatoRepository.findById(periodoPrenotatoId).get();
		
		if (Objects.nonNull(periodoPrenotato.getDataInizio()) && !"".equalsIgnoreCase(periodoPrenotato.getDataInizio().toString())) {
			periodoPrenotatoDB.setDataInizio(periodoPrenotato.getDataInizio());
		}
		
		if (Objects.nonNull(periodoPrenotato.getDataFine()) && !"".equalsIgnoreCase(periodoPrenotato.getDataFine().toString())) {
			periodoPrenotatoDB.setDataFine(periodoPrenotato.getDataFine());
		}
		
		if (Objects.nonNull(periodoPrenotato.getStatoPagamento()) && !"".equalsIgnoreCase(periodoPrenotato.getStatoPagamento())) {
			periodoPrenotatoDB.setStatoPagamento(periodoPrenotato.getStatoPagamento());
		}
		
		if (Objects.nonNull(periodoPrenotato.getStatoAccettazione()) && !"".equalsIgnoreCase(periodoPrenotato.getStatoAccettazione())) {
			periodoPrenotatoDB.setStatoAccettazione(periodoPrenotato.getStatoAccettazione());
		}
		
		return periodoPrenotatoRepository.save(periodoPrenotatoDB);
	}
	
	public PeriodoPrenotato updatePeriodoPrenotato(PeriodoPrenotato periodoPrenotato) {
		return periodoPrenotatoRepository.save(periodoPrenotato);
	}
	
	public void deletePeriodoPrenotato(Integer id) {
		periodoPrenotatoRepository.deleteById(id);
	}
}
