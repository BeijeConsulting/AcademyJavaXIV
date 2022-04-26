package it.beije.ecommerce;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.turing.rubrica.Contatto;

public class ECommerceManagerErcole {
	public static User LogIn(EntityManager entityManager) {
		User u = new User();
		Scanner s = new Scanner(System.in);
		String email = null;
		while(email == null || email.isEmpty()) {
			System.out.println("Inserire email: ");
			email = s.nextLine();
		}
		String password = null;
		while(password == null || password.isEmpty()) {
			System.out.println("Inserire password: ");
			password = s.nextLine();
		}
		Query query = entityManager.createQuery("SELECT u FROM user as u where u.email = "+email+" AND u.password = "+password+"");
		
		List<User> users = query.getResultList();
        if(users == null || users.size() != 1) {
        	System.out.println("email o password errati!");
        	return null;
        }
        u = users.get(0);
		return u;
	}
	public static User AddUser(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
		User u = new User();
		Scanner s = new Scanner(System.in);
		String nome_utente = null;
		while(nome_utente == null || nome_utente.isEmpty()) {
			System.out.println("Inserire nome Utente: ");
			nome_utente = s.nextLine();
		}
		String email = null;
		while(email == null || email.isEmpty()) {
			System.out.println("Inserire email: ");
			email = s.nextLine();
			Query query = entityManager.createQuery("SELECT u FROM user as u where u.email = "+email);
			List<User> users = query.getResultList();
	        if(users != null || users.size() != 0) {
	        	System.out.println("email già inserita! Inserire una nuova email");
	        	email = null;
	        	continue;
	        }
	        break;
		}
		String password = null;
		while(password == null || password.isEmpty()) {
			System.out.println("Inserire password: ");
			password = s.nextLine();
		}
		System.out.println("Inserire Carta di credito: ");
		String creditCard = s.nextLine();
		u.setNomeUtente(nome_utente);
		u.setEmail(email);
		u.setPassword(password);
		u.setCreditCard(creditCard);
		entityManager.persist(u);
		
		entityTransaction.commit();
		return u;
	}
	
	public static boolean ChangePassword(EntityManager entityManager, User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
		
        User u = entityManager.find(User.class, user.getId());
        if(u == null) {
        	System.out.println("utente inesistente");
        }
		Scanner s = new Scanner(System.in);
		String oldPassword = null;
		while(oldPassword == null || oldPassword.isEmpty()) {
			System.out.println("Inserire vecchia password: ");
			oldPassword = s.nextLine();
		}
		if(!oldPassword.equals(u.getPassword())) {
			System.out.println("Password errata! Quitting...");
			return false;
		}
		String newPassword = null;
		while(newPassword == null || newPassword.isEmpty()) {
			System.out.println("Inserire nuova password: ");
			newPassword = s.nextLine();
			if(newPassword.equals(oldPassword)) {
				System.out.println("La nuova password non può essere uguale alla precedente!");
				newPassword = null;
				continue;
			}
			break;
		}
		u.setPassword(newPassword);
		entityManager.persist(u);
		
		entityTransaction.commit();
		System.out.println("La password è stata modificata!");
		return true;
	}
}
