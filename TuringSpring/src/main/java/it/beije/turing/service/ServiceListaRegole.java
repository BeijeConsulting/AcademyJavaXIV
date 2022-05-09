package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.turing.beans.ListaRegole;
import it.beije.turing.repository.ListaRegoleRepository;

public class ServiceListaRegole 
{
	@Autowired
	private ListaRegoleRepository listaRegoleRepository;

	/**
     * Restituisce una lista di tutte le regole collegate agli annunci
     * @return lista di lista regole
     */
	public List<ListaRegole> getListaRegole()
	{
		return listaRegoleRepository.findAll();
	}
	
	/**
     * Inserisce un nuovo valore lista regole
     * @param newListaRegole nuovo lista regole da inserire
     * @return Oggetto lista regole inserito
     */
	public ListaRegole newListaRegole(ListaRegole newListaRegole)
	{
		return listaRegoleRepository.save(newListaRegole);
	}
	
	/**
     * Modifica un lista regole tramite l' ID di riferimento
     * @param newListaRegole nuovo lista regole da inserire
     * @param listaRegoleId id del lista regole da modificare
     * @return Oggetto lista regole inserito
     */
	public ListaRegole updateListaRegole(ListaRegole newListaRegole, Integer listaRegoleId)
	{
		ListaRegole oldListaRegole = listaRegoleRepository.findById(listaRegoleId).get();
		
		if (newListaRegole.getCompletamento() != null && !newListaRegole.getCompletamento().equals("") && !newListaRegole.getCompletamento().equalsIgnoreCase(oldListaRegole.getCompletamento())) oldListaRegole.setCompletamento(newListaRegole.getCompletamento());
		
		return listaRegoleRepository.save(oldListaRegole);
	}
	
	/**
     * Cancella un lista regole tramite l' ID di riferimento
     * @param listaRegoleId id dell' oggetto lista regole da cancellare
     */
	public void deleteListaRegole(Integer listaRegoleId)
	{
		listaRegoleRepository.deleteById(listaRegoleId);
	}
}
