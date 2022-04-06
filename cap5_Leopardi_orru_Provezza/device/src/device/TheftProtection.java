package device;

public class TheftProtection extends Household implements Video, Audio, Camera {
	private int cameraQuality;
	private boolean audio;
	
	public void isDeviceBroken(boolean isBroken) {
		if(isBroken) {
			System.out.println("This device is broken. ");
		} else {
			System.out.println("This device isn't broken. ");
		}
	}
	
	public void useCase(String s) {
		System.out.println("This device is helping you from house thieves. ");
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
}
