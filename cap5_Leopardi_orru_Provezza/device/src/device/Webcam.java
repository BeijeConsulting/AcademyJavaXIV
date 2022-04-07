package device;

public class Webcam extends Work implements Microphone, Camera{
	private int cameraQuality;
	private boolean microphone;
	
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
	
	public void cameraQuality() {
		System.out.println("The quality camera of this device is: " +cameraQuality+ "p");
	}
	
	public void changeQuality(int cameraQuality) {
		this.cameraQuality = cameraQuality;
	}
	
	public Webcam() {
		this.microphone = false;
		this.cameraQuality = 720;
	}
	
	public Webcam(int cameraQuality) {
		this();
		this.cameraQuality = cameraQuality;
	}
	
	public Webcam(boolean microphone) {
		this();
		this.microphone = microphone;
	}
	
	public Webcam(int cameraQuality, boolean microphone) {
		this.cameraQuality = cameraQuality;
		this.microphone = microphone;
	}
}
