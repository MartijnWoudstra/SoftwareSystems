package ss.week2;

public class Lamp {
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MED = 2;
	public static final int HIGH = 3;
	
	private int light;
	
	//@ ensures light() == HIGH;
	public Lamp() { 
		light = OFF;
	}
	
	//@ invariant \result == OFF || \result == LOW || \result = MED || \result == HIGH;
	/*@ pure */
	public int light() {
		return light;
	}
	
	/*@ ensures light() == (\old(light()) + 1) % 4;*/
	public void change() {
		light = (light + 1) % 4;
	}
}