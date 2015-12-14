package ss.week4.math;

public class Homework {

	public static void init(){
		Constant c = new Constant(3);
		p(c.toString(), Double.toString(c.apply(8)));
		Exponent e = new Exponent(3);
		p(e.toString(), Double.toString(e.apply(8)));
		Sum s = new Sum(c, c);
		p(s.toString(), Double.toString(s.apply(8)));
		Product p = new Product(s, s);
		p(p.toString(), Double.toString(p.apply(8)));
		LinearProduct l = new LinearProduct(e, c);
		p(l.toString(), Double.toString(l.apply(8)));
		double[] d = {1.0, 2.0, 3.0};
		Polynomial po = new Polynomial(d);
		p(po.toString(), Double.toString(po.apply(8)));
	}
	
	public static void p(String s, String s2){
		System.out.println("f(x) = " + s + ", f(8) =  " + s2);
	}
	public static void main(String[] args){
		init();
	}
}
