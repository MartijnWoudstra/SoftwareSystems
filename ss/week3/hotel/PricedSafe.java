package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	
	private double safePrice;
	
	public PricedSafe(double price) {
		safePrice = price;
	}

	@Override
	public double getAmount() {
		return safePrice;
	}
	
	@Override
    public String toString(){
    	return "Price for safe ";
    }
}
