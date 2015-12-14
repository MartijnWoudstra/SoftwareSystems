package ss.week4.math;

public class Exponent implements Function, Integrandable{

	private int exponent;
	
	public Exponent(int e) {
		exponent = e;
	}
	
	@Override
	public double apply(int numb) {
		return Math.pow(numb, exponent);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Exponent(exponent - 1), new Constant(exponent));
	}

	@Override
	public String toString() {
		return "x^" + exponent; 
	}

	@Override
	public Function intergrand() {
		double d = (1 * 1.0  / (exponent * 1.0 + 1 * 1.0));
		return new LinearProduct(new Exponent(exponent + 1), new Constant(d));
	}
}