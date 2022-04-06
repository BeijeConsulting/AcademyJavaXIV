package device;

public interface Microphone {
	
	public boolean isMicOn();
	
	public default void setSensibility(int sens) {
		System.out.println("the sensibility is set to " + sens);
		
	}
	
	
}
