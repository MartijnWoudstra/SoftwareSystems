package ss.week4.math;

public class Sum implements Function, Integrandable {
	
	private Function func1;
	private Function func2;
	
	public Sum(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}

	@Override
	public double apply(int numb) {
		return func1.apply(numb) + func2.apply(numb);
	}

	@Override
	public Function derivative() {
		return new Sum(func1.derivative(), func2.derivative());
	}

	@Override
	public String toString() {
		return "" + func1.toString() + " + " + func2.toString();
	}

	@Override
	public Function intergrand() {
		Function a = null;
		if(func1 instanceof Integrandable && func2 instanceof Integrandable){
			Integrandable i1 = (Integrandable)func1;
			Integrandable i2 = (Integrandable)func2;
			a = new Sum((Function)i1.intergrand(), (Function)i2.intergrand());
		}
		return a;
	}
}