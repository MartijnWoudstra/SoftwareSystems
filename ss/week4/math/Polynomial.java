package ss.week4.math;

public class Polynomial implements Function, Integrandable{

	private LinearProduct[] numbers;
	
	public Polynomial(double[] args) {
		numbers = new LinearProduct[args.length];
		for (int i = 0; i < args.length; i++) {
			numbers[i] = new LinearProduct(new Exponent((int)args[i]), new Constant(i + 2));
		}
	}
	
	@Override
	public double apply(int numb) {
		double ans = 0;
		for (int i = 0; i < numbers.length; i++) {
			ans += (numbers[i]).apply(numb);
		}
		return ans;
	}

	@Override
	public Function derivative() {
		Function a = new Constant(0);
		for(int i = 0; i < numbers.length; i++) {
			a = new Sum(a, numbers[i].derivative());
		}
		return a;
	}

	@Override
	public String toString() {
		String a = "";
		for(int i = 0; i < numbers.length; i++){
			a = a + " " + numbers[i].toString();
			if(i + 1 != numbers.length){
				a = a + " +";
			}
		}
		return a;
	}

	@Override
	public Function intergrand() {
		Function a = new Constant(0);
		for(int i = 0; i < numbers.length; i++){
			a = new Sum(numbers[i].intergrand(), a);
		}
		return a;
	}
}
