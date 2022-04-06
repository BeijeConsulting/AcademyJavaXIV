package device;

public abstract class Household extends Device{
	public boolean isBroken;
	public abstract void useCase(String s);		//will print "this device is helping you wash dishes//remove dust
	public abstract void isDeviceBroken(boolean isBroken);		//will print "*device name* is *isBroken*"
}
