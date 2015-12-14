package ss.week3;

public class Format {

	public static String printLine(String text, double amount){
//		System.out.printf("%s %" + (50 - text.length()) + ".2f\n", text, amount);
		return String.format("%s %" + (50 - text.length()) + ".2f", text, amount);
	}
	
	public static void main(String[] args){
		System.out.println(printLine("hello", 12.2));
	}
}