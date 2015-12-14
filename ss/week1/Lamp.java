package ss.week1;

public class Lamp {
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MED = 2;
	public static final int HIGH = 3;
	
	private int light;
	
	public Lamp() { 
		light = OFF;
	}
	
	public int light() {
		return light;
	}
	
	public void change() {
		light = (light + 1) % 4;
	}
}