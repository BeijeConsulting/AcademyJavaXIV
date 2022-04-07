package device;

public class CompanyPc extends Work implements Video, Microphone, Audio, Camera {
	private int cameraQuality;
	private boolean audio;
	private boolean microphone;
	
	public void playVideo(String s) {
		System.out.println("Playing " +s);
	}
	
	public void displayInfo(String s) {
		System.out.println("The display is showing this " +s);
	}
	
	public boolean isMicOn() {
		if(this.microphone) {
			System.out.println("The microphone of this device is on. ");
		} else {
			System.out.println("The microphone of this device is off. ");
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
	
	public void cameraQuality() {
		System.out.println("The quality camera of this device is: " +cameraQuality+ "p");
	}
	
	public void changeQuality(int cameraQuality) {
		this.cameraQuality = cameraQuality;
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
	
	public CompanyPc() {
		super.battery = true;
		this.audio = false;
		this.cameraQuality = 720;
		this.microphone = false;
	}
	
	public CompanyPc(int cameraQuality) {
		this();
		this.cameraQuality = cameraQuality;
	}
	
	public CompanyPc(int cameraQuality, boolean audio) {
		this();
		this.cameraQuality = cameraQuality;
		this.audio = audio;
	}
	
	public CompanyPc(boolean microphone, int cameraQuality) {
		this();
		this.cameraQuality = cameraQuality;
		this.microphone = microphone;
	}
	
	public CompanyPc(boolean microphone, boolean audio) {
		this();
		this.microphone = microphone;
		this.audio = audio;
	}
	
	public CompanyPc(int cameraQuality, boolean audio, boolean microphone) {
		this();
		this.audio = audio;
		this.cameraQuality = cameraQuality;
		this.microphone = microphone;
	}
}
