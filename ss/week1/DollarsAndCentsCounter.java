package ss.week1;

/**.
 * Counter for money
 * Possible to add money, reset, and get the value
 * @author martijn
 * @version 0.0.1
 */
public class DollarsAndCentsCounter {

	private int dollars;
	private int cents;
	
	/**.
	 * Constructor for DollarsAndCentsCounter
	 * Sets the values to initial value of 0
	 */
	public DollarsAndCentsCounter() {
		dollars = 0;
		cents = 0;
	}
	
	//@ requires hours > 0 && rate > 0;
	//@ ensures \result > 0;
	public int pay(int hours, int rate) {
		int max = 40;
		return hours > max ? (max * rate + ((hours - max) * rate)) : hours * rate;
	}
	
	public void add(int newDollars, int newCents) {
		if (newCents + cents > 99) {
			cents = (newCents + cents) % 100;
			dollars += (cents + newCents) / 100;
		} else {
			cents = newCents + cents; 
		}
		dollars = dollars + newDollars;
	}
	
	/**.
	 * Returns the current value of dollars
	 * @return int Dollars
	 */
	public int dollars() {
		return dollars;
	}
	
	/**.
	 * Returns the current value of cents
	 * @return int Cents
	 */
	public int cents() {
		return cents;
	}
	
	/**.
	 * Resets the counter.
	 * Both dollars and cents are set to 0. 
	 */
	public void reset() {
		dollars = 0;
		cents = 0;
	}
}