package device;

public class Cordless extends Work implements Screen, Microphone, Audio{
	private boolean audio;
	private boolean microphone;
	
	public void displayInfo(String s) {
		System.out.println("The display is showing this info: " +s);
	}
	
	public boolean isMicOn() {
		if(this.microphone) {
			System.out.println("The microphone of this device is off. ");
		} else {
			System.out.println("The microphone of this device is on. ");
		}
		return microphone;
	}
	
	public boolean turnOnMic() {
		this.microphone = true;
		System.out.println("The microphone of this device is on. ");
		return microphone;
	}
	
	public boolean turnOffMic() {
		this.microphone = true;
		System.out.println("The microphone of this device is on. ");
		return microphone;
	}
	
	public boolean isAudioOn() {
		if(this.audio) {
			System.out.println("The audio of this device is off. ");
		} else {
			System.out.println("The audio of this device is on. ");
		}
		return audio;
	}
	
	public boolean turnOnAudio() {
		this.audio = true;
		System.out.println("The audio of this device is on. ");
		return audio;
	}
	
	public boolean turnOffAudio() {
		this.audio = false;
		System.out.println("The audio of this device is off. ");
		return audio;
	}
	
	public boolean hasAudio() {
		System.out.println("This device has audio.");
		return true;
	}
	
	public Cordless() {
		super.battery = true;
		this.audio = false;
		this.microphone = false;
	}
	
	public Cordless(boolean microphone, boolean audio) {
		this();
		this.microphone = microphone;
		this.audio = audio;
	}
}
