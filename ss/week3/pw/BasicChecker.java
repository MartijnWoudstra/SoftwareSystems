package ss.week3.pw;

import java.util.Random;

public class BasicChecker implements Checker {

	public static String INITPASS;
	
	public static void main(String[] args){
		BasicChecker c = new BasicChecker();
		System.out.println(c.generatePassword());
	}

	@Override
	public boolean acceptable(String password) {
		boolean ans = false;
		if (password.length() >= 6 && !password.contains(" ")) {
			ans = true;
		}
		return ans;
	}

	@Override
	public String generatePassword() {
		Random rand = new Random();
		String ans = "";
		boolean accept = false;
		while (!accept) {
			for (int i = 0; i < rand.nextInt(20); i++) {
				ans = ans + ALPHABET.charAt(rand.nextInt(ALPHABET.length() - 1));
			}
			if (acceptable(ans)) {
				accept = true;
			}
		}
		INITPASS = ans;
		return ans;
	}
}