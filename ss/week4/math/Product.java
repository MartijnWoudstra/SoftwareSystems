package ss.week4.math;

public class Product implements Function{

	private Function func1;
	private Function func2;
	
	public Product(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}
	
	@Override
	public double apply(int numb) {
		return func1.apply(numb) * func2.apply(numb);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(func1.derivative(), func2), 
				new Product(func1, func2.derivative()));
	}

	@Override
	public String toString() {
		return "(" + func1.toString() + ") * (" + func2.toString() + ")"; 
	}
}