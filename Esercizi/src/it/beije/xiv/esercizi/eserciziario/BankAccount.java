package it.beije.xiv.esercizi.eserciziario;

public class BankAccount {
	private double balance;
	
	public BankAccount() {
		this(0.0);
	}
	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		balance -= amount;
	}
	public void addInterest(double rate) {
		balance = balance + ((balance * rate) / 100);
	}
	public static void main(String[] args) {
		BankAccount harrysChecking = new BankAccount();
		harrysChecking.deposit(1000);
		harrysChecking.withdraw(500);
		harrysChecking.withdraw(400);
		System.out.println(harrysChecking.getBalance());
		BankAccount momsSaving = new BankAccount(1000);
		momsSaving.addInterest(10); //Interessi al 10%
		System.out.println("Dollars: " + momsSaving.getBalance());
	}

}
