package device;

public class WashingMachine extends Household implements Screen, Motor{

	boolean motorOn = false;
	
	public WashingMachine (boolean motorOn) {
		this.motorOn = motorOn;
	}
	
	@Override
	public void turnOnMotor(boolean motorOn) {
		if(motorOn) {
			System.out.println("The washing machine is already washing");
		} else {
			this.motorOn = true;
			System.out.println("The vacuum cleaner starts washing");
		}
		
	}

	@Override
	public void turnOffMotor(boolean motorOn) {
		if (motorOn) {
			this.motorOn = false;
			System.out.println("The washing machine stops washing");
		} else {
			System.out.println("The washing machine is already off");
		}
		
	}

	@Override
	public boolean isMotorOn() {
		return motorOn;
		
	}


	@Override
	public void wattMotor(int w) {
		System.out.println("The washing machine is now operating at "+w+"W.");
		
	}

	@Override
	public void changePower(int p) {
		this.wattMotor(p);
		
	}

	@Override
	public void displayInfo(String s) {
		System.out.println("The screen on the washing machine reads: "+s+".");
		
	}

	@Override
	public void useCase(String s) {
		System.out.println("You are using the washing machine to: "+s+".");
		
	}

	@Override
	public void isDeviceBroken(boolean isBroken) {
		if (isBroken) {
			System.out.println("The washing machine is broken!");
		} else {
			System.out.println("The washing machine is working fine!");
		}
		
		
	}
}
