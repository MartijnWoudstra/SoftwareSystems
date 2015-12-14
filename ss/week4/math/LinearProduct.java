package ss.week4.math;

public class LinearProduct extends Product implements Integrandable{

	private Function func1;
	private Constant constant;
	
	public LinearProduct(Function f1, Constant c) {
		super(f1, c);
		func1 = f1;
		constant = c;
	}

	@Override
	public Function derivative() {
		return new LinearProduct(func1.derivative(), constant);
	}

	@Override
	public Function intergrand() {
		Function a = null;
		if(func1 instanceof Integrandable){
			Integrandable i1 = (Integrandable)func1;
			a = new Product(constant, (Function)i1.intergrand());
		}
		return a;
	} 
}
