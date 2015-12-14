package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Safe;

public class SafeTest {

	Safe safe;
	String password;
	String wrongPassword;
	
	/**.
	 * Create a safe instance
	 */
	@Before
	public void setUp() throws Exception {
		safe = new Safe();
		password = safe.getPassword().toString();
		wrongPassword = "NotThePassword";
	}
	
	/**.
	 * Test if the safe is closed and inactive from the start
	 */
	@Test
	public void initialization() {
		assertEquals(safe.isActive(), false);
		assertEquals(safe.isOpen(), false);
	}

	/**.
	 * Checks if the password is the initial password
	 */
	@Test
	public void correctPassword() {
		assertEquals(password, safe.getPassword().toString());
	}
	
	/**.
	 * Checks if the safe stays closed and deactivated with wrong password
	 */
	@Test
	public void wrongPassword() {
		safe.activate(wrongPassword);
		safe.open(wrongPassword);
		assertEquals(safe.isActive(), false);
		assertEquals(safe.isOpen(), false);
	}
	
	/**.
	 * Checks whether the safe can be activated and opened
	 * with the correct password
	 */
	@Test
	public void activateAndOpen() {
		safe.activate(password);
		assertEquals(safe.isActive(), true);
		safe.open(password);
		assertEquals(safe.isOpen(), true);
	}
	
	/**.
	 * Checks if the safe closes when closing,
	 * deactivates when deactivating,
	 * and closes when deactivating
	 */
	@Test
	public void closeAndDeactivate() {
		safe.close();
		assertEquals(safe.isOpen(), false);
		safe.deactivate();
		assertEquals(safe.isActive(), false);
		safe.activate(password);
		safe.open(password);
		safe.deactivate();
		assertEquals(safe.isOpen(), false);
	}
}
