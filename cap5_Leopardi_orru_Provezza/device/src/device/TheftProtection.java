package device;

public class TheftProtection extends Household implements Video, Audio, Camera {
	private int cameraQuality;
	
	public void isDeviceBroken(boolean isBroken) {
		if(isBroken) {
			System.out.println("This device is broken. ");
		} else {
			System.out.println("This device isn't broken. ");
		}
	}
	
	public void useCase(String s) {
		System.out.println("This device is helping you from house thieves. ");
	}
	
	public void cameraQuality() {
		System.out.println("The quality camera of this device is: " +cameraQuality+ "p");
	}
	
	public void changeQuality(int cameraQuality) {
		this.cameraQuality = cameraQuality;
	}
}
