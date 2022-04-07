package device;

public class Reflex extends Entertainment implements Camera, TouchScreen, Microphone {
	public boolean cameraOn;
	public boolean micOn;
	public int cameraQuality;
	
	
	public Reflex(boolean cameraOn, boolean micOn, int cameraQuality) {
		super();
		this.cameraOn = cameraOn;
		this.micOn = micOn;
		this.cameraQuality = cameraQuality;
	}

	public void hasBattery() {
		this.battery = true;
	}

	@Override
	public void displayInfo(String s) {
		System.out.println(s + "is printed");
	}

	@Override
	public boolean isMicOn() {
		
		return this.micOn;
	}

	@Override
	public boolean turnOnMic() {
		if(this.micOn) {
			System.out.println("the mic is ON");
		} else {
			this.micOn = true;
			System.out.println("noe the mic is ON");
		}
		return true;
	}

	@Override
	public boolean turnOffMic() {
		if(!this.micOn) {
			System.out.println("the mic is OFF");
		} else {
			this.micOn = false;
			System.out.println("noe the mic is OFF");
		}
		return true;
	}

	@Override
	public void hasTouchscreen() {
		System.out.println("the camera has touchScreen");

	}

	@Override
	public void cameraQuality() {
		System.out.println("camera quality: " + this.cameraQuality);

	}

	@Override
	public void changeQuality(int cameraQuality) {
		this.cameraQuality = cameraQuality;
	}

	@Override
	public void mediaType() {
		System.out.println("you are watching videos or photos");
		
	}

}
