package device;

public class NintendoSwitch extends Entertainment implements TouchScreen, Video, Microphone, Audio{
	public boolean audioOn;
	public boolean micOn;
	
	

	public NintendoSwitch(boolean audioOn, boolean micOn) {
		super();
		this.audioOn = audioOn;
		this.micOn = micOn;
		this.battery = true;
	}
	

	@Override
	public void displayInfo(String s) {
		System.out.println(s + " is printed");
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
	public void playVideo(String s) {
		System.out.println(s + " is printed");
		
	}

	@Override
	public void hasTouchscreen() {
		System.out.println("playing game on touchscreen");
		
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
	public void mediaType() {
		System.out.println("playing games");
		
	}
	
	
	
}
