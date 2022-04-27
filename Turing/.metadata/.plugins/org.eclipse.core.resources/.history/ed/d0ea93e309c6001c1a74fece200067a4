package it.beije.turing.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EcommerceManager
{
	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Utente newUtente = new Utente();
		entityManager.persist(newUtente);
		
		//entityTransaction.commit();
		
		Login newLogin = new Login();
		newLogin.setId_utente(newUtente.getId());
		newLogin.setEmail("email@email.email");
		newLogin.setPassword("Password");
		entityManager.persist(newLogin);
		
		//entityTransaction.commit();
		
		Anagrafica newAnagrafica = new Anagrafica();
		newAnagrafica.setId_utente(newUtente.getId());
		newAnagrafica.setNome("NomeUtente");
		newAnagrafica.setCognome("CognomeUtente");
		newAnagrafica.setTelefono("TelefonoUtente");
		newAnagrafica.setCitta("CittaNascitaUtente");
		newAnagrafica.setData("DataNascitaUtente");
		entityManager.persist(newAnagrafica);
		
		//entityTransaction.commit();
		
		Fatturazione newFatturazione = new Fatturazione();
		newFatturazione.setId_utente(newUtente.getId());
		entityManager.persist(newFatturazione);
		
		//entityTransaction.commit();
		
		Indirizzo newIndirizzo = new Indirizzo();
		newIndirizzo.setId_fatturazione(newFatturazione.getId());
		newIndirizzo.setCitta("CittaFatturazione");
		newIndirizzo.setVia("ViaFatturazione");
		newIndirizzo.setCap("CapFatturazione");
		newIndirizzo.setProvincia("ProvinciaFatturazione");
		newIndirizzo.setNumero("NumeroFatturazione");
		entityManager.persist(newIndirizzo);
		
		
		Prodotto newProdotto = new Prodotto();
		newProdotto.setCodice("CodiceProdotto1");
		newProdotto.setNome("NomeProdotto1");
		newProdotto.setImmagine("ImmagineProdotto1");
		newProdotto.setPrezzo("1");
		newProdotto.setDescrizione("DescrizioneProdotto1");

		entityManager.persist(newProdotto);
		
		Prodotto newProdotto2 = new Prodotto();
		newProdotto2.setCodice("CodiceProdotto2");
		newProdotto2.setNome("NomeProdotto2");
		newProdotto2.setImmagine("ImmagineProdotto2");
		newProdotto2.setPrezzo("2");
		newProdotto2.setDescrizione("DescrizioneProdotto2");

		entityManager.persist(newProdotto2);
		
		
		Carrello newCarrello = new Carrello();
		newCarrello.setId_utente(newUtente.getId());
		newCarrello.setTotale("");
		entityManager.persist(newCarrello);
		
		
		Contenuto newContenuto = new Contenuto();
		newContenuto.setId_carrello(newCarrello.getId());
		newContenuto.setId_prodotto(newProdotto.getId());
		newContenuto.setQuantita("1");
		entityManager.persist(newContenuto);
		
		Contenuto newContenuto2 = new Contenuto();
		newContenuto2.setId_carrello(newCarrello.getId());
		newContenuto2.setId_prodotto(newProdotto2.getId());
		newContenuto2.setQuantita("2");
		entityManager.persist(newContenuto2);
		
		int totale = Integer.parseInt(newProdotto.getPrezzo()) * Integer.parseInt(newContenuto.getQuantita()) + Integer.parseInt(newProdotto2.getPrezzo()) * Integer.parseInt(newContenuto2.getQuantita());
		
		
		newCarrello.setTotale("" + totale);
		entityManager.persist(newCarrello);
		
		
		Ordine newOrdine = new Ordine();
		newOrdine.setId_carrello(newCarrello.getId());
		newOrdine.setId_utente(newUtente.getId());
		newOrdine.setNumero("NumeroOrdine");
		newOrdine.setTotale(newCarrello.getTotale());
		newOrdine.setData("DataOrdine");
		entityManager.persist(newOrdine);
		
		
		entityTransaction.commit();
		
		System.out.println("FATTO");
	}
}