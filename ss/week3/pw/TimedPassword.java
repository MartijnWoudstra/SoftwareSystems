package ss.week3.pw;

public class TimedPassword extends Password {
	private long validTime;
	private long setTime;
	private boolean isExpired;
	private String INITPASS;
	
	public TimedPassword(long expireTime) {
		validTime = expireTime;
		setTime = System.currentTimeMillis();
		isExpired = false;
		INITPASS = super.toString();
	}
	
	public TimedPassword() {
		setTime = System.currentTimeMillis();
		isExpired = false;
	}
	
	public boolean isExpired() {
		if ((System.currentTimeMillis() - setTime) / 1000 > validTime) {
			isExpired = true;
		}
		return isExpired;
	}
	
	@Override
	public boolean setWord(String old, String neww) { 
		boolean result = false;
		if (super.setWord(old, neww)){
			isExpired = false;
			setTime = System.currentTimeMillis();
			result = true;
		}
		System.out.println(result);
		return result;
	}
}
