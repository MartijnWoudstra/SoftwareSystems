package ss.week3.hotel;

import java.io.PrintStream;

import ss.week1.Password;

public class Hotel {

	private String name;
	private Password pw;
	public final int NUM_OF_ROOMS = 2;
	private PricedRoom[] rooms = new PricedRoom[NUM_OF_ROOMS];
	private int priceSafe = 10;
	private int priceRoom = 20;
	

	/*
	 * @ requires hotelName != null; ensures getPassword() != null &&
	 * getPassword().toString() == getPassword().INITIAL;
	 */
	public Hotel(String hotelName) {
		name = hotelName;
		pw = new Password();
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = new PricedRoom(i + 100, priceRoom, priceSafe);
		}
	}

	/**
	 * . Checks in a guest. This requires the correct hotelpassword. If the
	 * password is wrong, the guest is not checked in. Also doesnt check in, if
	 * there is no free room. If the checkin can continue, the guest object is
	 * created. Also, the guest is checked in, and the room booked to their
	 * name.
	 * 
	 * @param password
	 *            Hotelpassword
	 * @param guestName
	 *            Name of the guest
	 * @return null if the checking failed, otherwise the Room of the guest.
	 */
	/* @ requires password != null && guestName != null; */
	public Room checkIn(String password, String guestName) {
		Room r = null;
		if (password.equals(getPassword().toString())) {
			r = getFreeRoom();
			if (r != null) {
				Guest g = new Guest(guestName);
				g.checkin(r);
			}
		}
		return r;
	}

	/**
	 * . Checks out the guest. If the guest doesnt have the room, nothing
	 * happens. The room is set to empty, the safe is deactivated, and the guest
	 * doesnt have a room anymore.
	 * 
	 * @param guestName
	 *            Name of the guest
	 * @return true if successfull, otherwise false
	 */
	/* @ requires guestName != null; */
	public boolean checkOut(String guestName) {
		boolean ans = false;
		Room r = getRoom(guestName); // NULLABLE
		if (r != null) {
			Guest g = r.getGuest(); // NULLABLE
			if (g != null) {
				g.checkout();
				ans = true;
			}
		}
		return ans;
	}

	/**
	 * . Finds the free rooms.
	 * 
	 * @return Room if there is a free room, otherwise false.
	 */
	public Room getFreeRoom() {
		Room r = null;
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getGuest() == null) {
				r = rooms[i];
			}
		}
		return r;
	}

	/**
	 * . Gets the room for the guest. If the guest doesnt have a room, returns
	 * null
	 * 
	 * @param guestName
	 *            Name of the guest
	 * @return Room if the guest has a room, otherwise false.
	 */
	/* @ requires guestName != null; */
	public Room getRoom(String guestName) {
		Room r = null;
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getGuest() != null) {
				if (rooms[i].getGuest().getName().equals(guestName)) {
					r = rooms[i];
				}
			}
		}
		assert guestName == null;
		return r;
	}

	/**
	 * . Returns the password object for the hote;
	 * 
	 * @return Password object
	 */
	/* @ pure */
	public Password getPassword() {
		return pw;
	}

	/**
	 * . To string method for Hotel.
	 */
	/* @ pure */
	public String toString() {
		String output = "";
		Room r = null;
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null && rooms[i].getGuest() != null 
							&& rooms[i].getGuest().getName() != null) {
				r = rooms[i];
				output = output + "On room " + r.getNumber() + 
								" " + r.getGuest().getName() + " has checked in /n";
			}
		}
		return output;
	}

	public String getBill(String gName, int nights, PrintStream printStream) {
		String ans = null;
		if (getRoom(gName) != null) {
			Bill bill = new Bill(printStream);
			if (getRoom(gName) instanceof PricedRoom) {
				PricedRoom r = (PricedRoom) getRoom(gName);
				for (int i = 0; i < nights; i++) {
					bill.newItem(r);
					ans = gName;
				}
			}
			if (getRoom(gName).getSafe() != null && 
							getRoom(gName).getSafe() instanceof PricedSafe) {
				PricedSafe s = (PricedSafe) getRoom(gName).getSafe();
				for (int i = 0; i < nights; i++) {
					bill.newItem(s);
				}
			}
			String text = "The sum of the bill is: ";
			System.out.printf("%s %" + (50 - text.length()) + ".2f", text, bill.getSum(), nights);
			bill.close();
		}
		return ans;
	}

	public static void main(String[] args) {
		Hotel h = new Hotel("t");
		h.checkIn(h.getPassword().toString(), "thom");
		h.getBill("thom", 4, System.out);
	}
}
