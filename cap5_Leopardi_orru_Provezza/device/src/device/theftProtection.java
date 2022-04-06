package device;

public class theftProtection extends Household implements Video, Audio, Camera {
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
}
