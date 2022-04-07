package device;

public class Tv extends Entertainment implements  Video, Audio{
	boolean audioOn = false;
	
	public Tv(boolean audioOn) {
		super();
		this.audioOn = audioOn;
		this.battery = false;
	}
		
	@Override
	public boolean isAudioOn() {
		return this.audioOn;
	}

	@Override
	public boolean hasAudio() {
		return true;
	}

	@Override
	public boolean turnOnAudio() {
		this.audioOn = true;
		System.out.println("audio set to ON");
		return this.audioOn;
	}

	@Override
	public boolean turnOffAudio() {
		this.audioOn = false;
		System.out.println("audio set to OFF");
		return true;
	}

	@Override
	public void displayInfo(String s) {
		System.out.println( "the display is showing this info: " + s);
		
	}

	@Override
	public void playVideo(String s) {
		System.out.println("tv is palying " + s);
		
	}

	@Override
	public void mediaType() {
		System.out.println("you are watching video");
		
	}
	
	

	
	
	

}
