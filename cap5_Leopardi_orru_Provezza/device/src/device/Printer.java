package device;

public class Printer extends Work implements TouchScreen, Motor{
	private boolean motor;
	private int watMotor;
	
	public void hasTouchscreen() {
		System.out.println("Use touch screen to choose the different modes.");
	}
	
	public void displayInfo(String s) {
		System.out.println("The display is showing this info: " +s);
	}
	
	public void turnOnMotor(boolean x) {
		this.motor = true;
		System.out.println("The motor of this device is on. ");
	}
	
	public void turnOffMotor(boolean x) {
		this.motor = true;
		System.out.println("The microphone of this device is on. ");
	}
	
	public boolean isMotorOn() {
		if(this.motor) {
			System.out.println("The microphone of this device is off. ");
		} else {
			System.out.println("The microphone of this device is on. ");
		}
		return motor;
	}
	
	public void wattMotor(int w) {
		System.out.println("The motor's watt power of this device is " +this.watMotor+ "w");
	}
	
	public void changePower(int p) {
		System.out.println("The power can't change");
	}
	
	public Printer() {
		this.motor = false;
		this.watMotor = 720;
	}
	
	public Printer(int watMotor) {
		this();
		this.watMotor = watMotor;
	}
	
	public Printer(boolean motor) {
		this();
		this.motor = motor;
	}
	
	public Printer(int watMotor, boolean motor) {
		this.watMotor = watMotor;
		this.motor = motor;
	}
}
