package ss.week3.pw;

public interface Checker {

	public final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final String ALPHABETANDNUMBERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**.
	 * Checks whether password is hard enough to be a secure password
	 * @param password Password to check
	 * @return Boolean true if hard enough, otherwise false
	 */
	boolean acceptable(String password);
	
	public String generatePassword();
}
