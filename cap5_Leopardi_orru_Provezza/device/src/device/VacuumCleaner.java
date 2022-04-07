package device;

public class VacuumCleaner extends Household implements Motor{
	
	boolean motorOn = false;
	
	public VacuumCleaner (boolean motorOn) {
		this.motorOn = motorOn;
	}
	
	@Override
	public void turnOnMotor(boolean motorOn) {
		if(motorOn) {
			System.out.println("The vacuum cleaner is already on");
		} else {
			this.motorOn = true;
			System.out.println("The vacuum cleaner turns on");
		}
		
	}

	@Override
	public void turnOffMotor(boolean motorOn) {
		if (motorOn) {
			this.motorOn = false;
			System.out.println("The vacuum cleaner stops");
		} else {
			System.out.println("The vacuum cleaner is already off");
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
	public void useCase(String s) {
		System.out.println("You are using the vacuum cleaner to: "+s+".");
		
	}

	@Override
	public void isDeviceBroken(boolean isBroken) {
		if (isBroken) {
			System.out.println("The vacuum cleaner is broken!");
		} else {
			System.out.println("The vacuum cleaner is working fine!");
		}
		
		
	}

}
