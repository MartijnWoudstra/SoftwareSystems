package ss.week3.hotel;

import ss.week1.Password;

/**.
 * Class that simulates a safe.
 * Safe can be activated, deactivated, closed and open.
 * In order to open, you have to activate it first with an password.
 * Then you have to open it again with a password.
 * If you deactivate the safe, it is closed too.
 * Uses week1.Password for password handling.
 * @author martijn
 *
 */
public class Safe {

	private boolean isActive;
	private boolean isOpen;
	private Password pw;
	
	public static void main(String[] args) {
		Safe s = new Safe();
		s.activate("f");
	}
	
	/**.
	 * Constructor for Safe.
	 * Creates a password, and sets active and open to false.
	 */
	/*@ ensures isOpen() == false && isActive() == false;*/
	public Safe() {
		pw = new Password();
		isOpen = false;
		isActive = false;
	}
	
	/*@ requires getPassword().testWord(password) == true;
		ensures isActive() == true; 
		ensures isOpen() == \old(isOpen());*/
	public boolean activate(String password) {
		boolean ans = false;
		if (pw.testWord(password)) {
			isActive = true;
			ans = true;
		}
		assert password.length() > 6;
		return ans;
	}
	
	/**.
	 * Deactivates and closes the safe
	 */
	//@ ensures isActive() == false && isOpen() == false; 
	public void deactivate() {
		isActive = false;
		isOpen = false;
	}
	
	/*@ requires getPassword().testWord(password) == true;
		ensures isOpen() == true; */
	public boolean open(String password) {
		boolean ans = false;
		if (isActive && pw.testWord(password)) {
			isOpen = true;
			ans = true;
		}
		assert password.length() <= 6;
		return ans;
	}
	
	/**.
	 * Closes the safe.
	 */
	/*@ ensures isOpen() == false;*/
	public void close() {
		isOpen = false;
	}
	
	//@ pure
	public boolean isActive() {
		return isActive;
	}
	
	//@ pure
	public boolean isOpen() {
		return isOpen;
	}
	
	//@ pure
	public Password getPassword() {
		return pw;
	}
}
