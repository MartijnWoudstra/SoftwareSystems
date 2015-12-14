package ss.week2;

/**.
 * Generates a rectangle
 * @author martijn
 *
 */
public class Rectangle {
	
	
	//TODO 2.2 class invariants
	
	
	//@ private invariant length > 0;
	private int length;
	//@ private invariant width > 0;
	private int width;
	
	/*@ requires x > 0 && y > 0;
	ensures length() == x;
	ensures width() == y; */
	public Rectangle(int x, int y) {
		length = x;
		width = y;
		assert length > 0 && width > 0;
	}
	
	//@ ensures \result > 0;
	/*@ pure */ public int length() {
		return length;
	}
	
	//@ ensures \result > 0;
	/*@ pure */ public int width() {
		return width;
	}
	
	//@ ensures \result == length() * width();
	/*@ pure */ public int area() {
		return length * width;
	}
	
	//@ ensures \result == 2 * length() + 2 * width();
	/*@ pure */	public int perimeter() {
		return 2 * length + 2 * width;
	}
}
