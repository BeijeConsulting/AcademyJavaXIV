package device;

public interface Audio {
	public boolean isAudioOn();
	
	public boolean hasAudio();
	
	public default void setVolume(int volume) {
		System.out.println("the volume is set to " + volume);
	}
	
	
}
