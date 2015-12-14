package ss.week3.hotel;

import java.io.PrintStream;

import ss.week3.Format;

public class Bill {
	
	private PrintStream stream;
	private double sum;
	
	public static interface Item {
		
		double getAmount();
		String toString();
	}
	
	public Bill(PrintStream theOutStream) {
		stream = theOutStream;
	}
	
	public void close() {
		stream.close();
	}
	
	public double getSum() {
		return sum;
	}
	
	public void newItem(Item item) {
		sum = sum + item.getAmount();
		stream.println(Format.printLine(item.toString(), item.getAmount()));
	}
}
