package ereditarieta;

public class Shark extends Fish{

	private int numberOfFins = 8;
	
	public Shark(int age){
		super(age);
		this.size = 4;
	}
	
	public void displaySharkDetails() {
		System.out.println("anni " + getAge());
		System.out.println("size " + size);
		System.out.println("fins" + numberOfFins);
	}
	
	public  void main(String[] args) {
		Shark shark = new Shark(15);
		
		displaySharkDetails();
		
	}
	 

}
