package ereditarieta;

public class Gorilla extends Animal {
	public Gorilla(int age) {
		super(age, "gorilla");
	}
	
	public Gorilla() {
		super(5);
	} 
	
	
	
	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla(5);
		
		Animal dog = new Animal(2, "dog");
		
		System.out.println("nome " + dog.getName() + " anni " + dog.getAge());
		System.out.println("nome " + gorilla.getName() + " anni " +gorilla.getAge());
		
		
		
		
		
	}
}
