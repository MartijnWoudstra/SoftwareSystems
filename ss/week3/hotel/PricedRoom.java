package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	
	private double priceRoom;
	private double priceSafe;
	
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, new PricedSafe(safePrice));
		priceRoom = roomPrice;
		priceSafe = safePrice;
	}

	@Override
	public double getAmount() {
		return priceRoom;
	}
	
	@Override
    public String toString() {
    	return "Price per night per room";
    }
}
