package device;

public class Stereo extends Entertainment implements Screen, Audio{
	public boolean audioOn = false;
	
	public Stereo(boolean audioOn) {
		super();
		this.audioOn = audioOn;
		this.battery = false;
	}

	@Override
	public boolean isAudioOn() {
		return this.audioOn;
	}

	@Override
	public boolean turnOnAudio() {
		if(this.audioOn) {
			System.out.println("the audio is ON");
		} else {
		this.audioOn = true;
		System.out.println("the audio now is ON");
		}
		return true;
	}

	@Override
	public boolean turnOffAudio() {
		if(!this.audioOn) {
			System.out.println("the audio is OFF");
		}
		else {
		this.audioOn = false;
		System.out.println("the audio now is OFF");
		}
		
		return true;
	}

	@Override
	public boolean hasAudio() {
		return true;
	}

	@Override
	public void displayInfo(String s) {
		System.out.println("display info: " + s);
		
	}

	@Override
	public void mediaType() {
		System.out.println("listening music");
		
	}
	
	
	

}
