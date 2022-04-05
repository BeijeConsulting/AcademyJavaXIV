package ereditarieta;

//hide static methods
public class Panda extends Bear{
	
	public static void eat() {
		System.out.println("panda is chewing");
	}
	
	public static void main(String[] args) {
		Panda.eat();
	}
}
