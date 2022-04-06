package device;

public interface Camera {
	//TODO
	public default void hasCamera() {
		System.out.println("This device has the camera.");
	}
	public void turnOnCamera(boolean x);
	
	public void turnOffCamera(boolean x);
	
	public void isCameraOn(boolean x);
	
	public void cameraQuality(int q);
	
	public void changeQuality(int q);
	
}