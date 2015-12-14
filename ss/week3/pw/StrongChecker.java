package ss.week3.pw;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongChecker extends BasicChecker {
	
	public static void main(String[] args) {
		StrongChecker c = new StrongChecker();
		System.out.println(c.generatePassword());
	}
	
	Pattern pattern = Pattern.compile("^[a-zA-Z].{1,}\\d$");

	@Override
	public boolean acceptable(String password) {
		Matcher m = pattern.matcher(password);
		boolean ans = false;
		if (super.acceptable(password) && m.matches()) {
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
			for (int i = 0; i < rand.nextInt(40); i++) {
				ans = ans + ALPHABETANDNUMBERS.charAt(
						rand.nextInt(ALPHABETANDNUMBERS.length() - 1));
			}
			ans = ans + rand.nextInt(10);
			if (acceptable(ans)) {
				accept = true;
			}
		}
		return ans;
	}
}
