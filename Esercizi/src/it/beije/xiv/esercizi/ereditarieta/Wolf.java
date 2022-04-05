package ereditarieta;

public  class Wolf extends Canine{
	
	@Override
	public double getAverageWeight() {
		return super.getAverageWeight() + 20;
	}
	
	@Override
	protected int getAvgWeight() {
		return super.getAvgWeight() + 60;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println((new Canine().getAverageWeight()));
		System.out.println(new Wolf().getAverageWeight());
		System.out.println(new Wolf().getAvgWeight());
	}

}
