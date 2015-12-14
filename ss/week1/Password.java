package ss.week1;

/**
 * Class to handle old and new passwords. This class can compare, set a new
 * password, and check for a accpetable password.
 * 
 * @author martijn
 * @version 0.0.1
 */
public class Password {

	public static final String INITIAL = "PassWord";
	private static String password;

	/**
	 * Constructor for Password Sets the variable password to the initial
	 * password.
	 */
	public Password() {
		password = INITIAL;
	}

	/**
	 * Checks if a password is acceptable Unacceptable passwords are passwords
	 * with less than 6 characters or containing a space.
	 * 
	 * @param suggestion
	 *            The new wanted password
	 * @return Boolean true if acceptable otherwise false
	 */
	public boolean acceptable(String suggestion) {
		return !(suggestion.length() < 6 || suggestion.contains(" "));
	}

	/**.
	 * Test if the password entered is the correct password
	 * 
	 * @param test
	 *            Password
	 * @return Boolean True if correct, otherwise False
	 */
	public boolean testWord(String test) {
		return test.equals(password);
	}

	/**.
	 * Resets the current password. 
	 * Only possible if the entered oldpass is correct to the current one,
	 * and the newpass comforts all requirements
	 * 
	 * @param oldpass old password
	 * @param newpass new password
	 * @return Boolean True if succeeded, otherwise False. 
	 */
	public boolean setWord(String oldpass, String newpass) {
		boolean ans = false;
		if (testWord(oldpass) && acceptable(newpass)) {
			password = newpass;
			ans = true;
		}
		return ans;
	}
	
	public String toString() {
		return password;
	}
}