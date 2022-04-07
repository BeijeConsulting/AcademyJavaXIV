package it.beije.xiv.esercizi.eserciziario;

import java.util.Scanner;

public class BankWithPassword {
	private double balance;
	private int password;
	
	public BankWithPassword(int password) {
		this(0,password);
	}
	
	public BankWithPassword(double balance, int password) {
		this.balance = balance;
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public int getPassword() {
		return password;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void addInterest(double rate) 
	{ 
		balance = balance + ((balance * rate) / 100); 
	}
	
	public boolean checkPassword(int pass) {
		if(pass == getPassword()) {
			return true;
		}
		return false;
	}
	
	public boolean checkPrelievo(double amount) {
		if(amount <= balance)
			return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Inserire password per il nuovo conto: ");
		BankWithPassword conto1 = new BankWithPassword(in.nextInt());
		System.out.println("Il saldo del conto1 è: " + conto1.getBalance() +"\n"
				+ "la password del conto è: " + conto1.getPassword());
		System.out.print("Inserire password per il nuovo conto: ");
		int tmp = in.nextInt();
		System.out.print("Inserire saldo per il nuovo conto: ");
		BankWithPassword conto2 = new BankWithPassword(in.nextDouble(), tmp);
		System.out.println("Il saldo del conto2 è: " + conto2.getBalance() +"\n"
				+ "la password del conto è: " + conto2.getPassword());
		System.out.println("Prelievo dal conto2:\nInserire la password del conto2: ");
		if(conto2.checkPassword(in.nextInt())) {
			System.out.println("Inserire la somma da prelevare: ");
			double amount = in.nextDouble();
			if(conto2.checkPrelievo(amount)) {
				conto2.withdraw(amount);
			}else {
				System.out.println("Somma non disponibile nel conto");
			}
		}else {
			System.out.println("Password errata. Impossibile effettuare il prelievo.");
		}
		System.out.println("Versamento sul conto 1:\nInserire la password del conto 1");
		if(conto1.checkPassword(in.nextInt())) {
			System.out.println("Inserire la somma da versare:"); 
			conto1.deposit(in.nextDouble());
		}else {
			System.out.println("Password errata. Impossibile effettuare il versamento.");
		}
		System.out.println("Nuovi saldi:\nconto 1: " + conto1.getBalance() + 
				 "\nconto 2: " + conto2.getBalance());
		conto1.addInterest(3); 
		conto2.addInterest(3); 
		System.out.println("Nuovi saldi con interesse applicato del 3%:"); 
		System.out.println("conto 1: " + conto1.getBalance() + "\nconto 2: " + conto2.getBalance()); 
	}

}
