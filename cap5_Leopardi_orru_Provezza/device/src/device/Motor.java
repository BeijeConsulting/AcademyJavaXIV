package device;

public interface Motor {
	//TODO
	public default void hasMotor() {
		System.out.println("This device has the motor.");
	}
	
	public void turnOnMotor(boolean x);
	
	public void turnOffMotor(boolean x);
	
	public void isMotorOn();
	
	public void wattMotor(int w);
	
	public void changePower(int p);
}
