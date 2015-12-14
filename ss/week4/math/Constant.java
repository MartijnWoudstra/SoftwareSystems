package ss.week4.math;

public class Constant implements Function, Integrandable {

	private double myConstant;
	
	public Constant(double constant) {
		myConstant = constant;
	}
	
	@Override
	public double apply(int numb) {
		return myConstant;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}

	@Override
	public String toString() {
		return "" + myConstant;
	}

	@Override
	public Function intergrand() {
		return new LinearProduct(new Exponent(1), new Constant(myConstant));
	}
}