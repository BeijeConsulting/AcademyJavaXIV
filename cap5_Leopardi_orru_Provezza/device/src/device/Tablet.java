package device;

public class Tablet extends Utility implements TouchScreen, Video, Microphone, Audio, Camera{

	boolean audioOn = false;
	boolean micOn = false;
	int cameraQuality = 720;
	
	public Tablet (boolean audioOn, boolean micOn, int cameraQuality) {
		this.audioOn = audioOn;
		this.micOn = micOn;
		this.battery = true;
	}
	
	@Override
	public void displayInfo(String s) {
		System.out.println("On the tablet screen, you can read: "+s+".");
		
	}


	@Override
	public void cameraQuality() {
		System.out.println("The camera quality is set to: "+cameraQuality);
		
	}

	@Override
	public void changeQuality(int q) {
		this.cameraQuality = q;
		System.out.println("The camera quality is now set to: "+q);
		
	}

	@Override
	public boolean isAudioOn() {
		return this.audioOn;
	}

	@Override
	public boolean turnOnAudio() {
		this.audioOn = true;
		System.out.println("The audio is now on");
		return audioOn;
	}

	@Override
	public boolean turnOffAudio() {
		this.audioOn = false;
		System.out.println("The audio is now off");
		return audioOn;
	}

	@Override
	public boolean hasAudio() {
		return true;
	}

	@Override
	public boolean isMicOn() {
		return this.micOn;
	}

	@Override
	public boolean turnOnMic() {
		this.micOn = true;
		System.out.println("The microphone is now on");
		return micOn;
	}

	@Override
	public boolean turnOffMic() {
		this.micOn = false;
		System.out.println("The microphone is now off");
		return micOn;
	}

	@Override
	public void playVideo(String s) {
		System.out.println("Your are watching "+s+" on this tablet.");
		
	}

	@Override
	public void hasTouchscreen() {
		System.out.println("This tablet has a IPS touchscreen");
		
	}

	@Override
	public void useCase(String s) {
		System.out.println("You are using this tablet to: "+s+".");
		
	}

}
