package device;

public class DishWasher extends Household implements Screen, Motor{
	
	boolean motorOn = false;
	
	public DishWasher (boolean motorOn) {
		this.motorOn = motorOn;
	}
	@Override
	public void turnOnMotor(boolean motorOn) {
		if(motorOn) {
			System.out.println("The dishwasher is already washing");
		} else {
			this.motorOn = true;
			System.out.println("The dishwasher starts washing");
		}
		
	}

	@Override
	public void turnOffMotor(boolean motorOn) {
		if (motorOn) {
			this.motorOn = false;
			System.out.println("The dishwasher stops washing");
		} else {
			System.out.println("The dishwasher is not washing");
		}
		
	}

	@Override
	public boolean isMotorOn() {
		return motorOn;
		
	}

	@Override
	public void wattMotor(int w) {
		System.out.println("The dishwasher is now operating at "+w+"W.");
		
	}

	@Override
	public void changePower(int p) {
		this.wattMotor(p);
		
	}

	@Override
	public void displayInfo(String s) {
		System.out.println("The screen on the dishwasher reads: "+s+".");
		
	}

	@Override
	public void useCase(String s) {
		System.out.println("You are using the dishwasher to: "+s+".");
		
	}

	@Override
	public void isDeviceBroken(boolean isBroken) {
		if (isBroken) {
			System.out.println("The dishwasher is broken!");
		} else {
			System.out.println("The dishwasher is working fine!");
		}
		
		
	}

}
