package device;

public interface Camera {
	//TODO
	public default void hasCamera() {
		System.out.println("This device has the camera.");
	}
	
	public void isCameraOn(boolean x);
	
	public void cameraQuality();
	
	public void changeQuality(int cameraQuality);
	
}
