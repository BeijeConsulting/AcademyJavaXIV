package device;

public abstract class Device {
	public boolean battery = false;
	
	public boolean isOn = false;
	
	public void turnOn() {
		this.isOn = true;
		System.out.println("The device is on");
	}
	
	public void turnOff() {
		this.isOn = false;
		System.out.println("The device is off");
	}
}
