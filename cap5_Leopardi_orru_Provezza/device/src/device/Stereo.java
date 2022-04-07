package device;

public class Stereo extends Device implements Screen, Audio{
	
	public void hasBattery
	
	
	@Override
	public boolean isAudioOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnOnAudio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnOffAudio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAudio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayInfo(String s) {
		System.out.println("display info: " + s);
		
	}
	

}
