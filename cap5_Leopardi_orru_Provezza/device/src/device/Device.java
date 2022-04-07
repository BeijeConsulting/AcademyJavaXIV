package device;

public abstract class Device {
	public boolean battery = false;
	
	public boolean isOn = false;
	
	public void hasBattery() {
		if (this.battery) {
			System.out.println("This device is battery powered");
		} else {
			System.out.println("This device is not battery powered");
		}
		
	}
	
	public void turnOn() {
		this.isOn = true;
		System.out.println("The device is on");
	}
	
	public void turnOff() {
		this.isOn = false;
		System.out.println("The device is off");
	}
}
