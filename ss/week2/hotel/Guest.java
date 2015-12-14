package ss.week2.hotel;

/**.
 * Information about a guest, with possibilities to check-in and check-out
 * 
 * @author Martijn
 * @version 0.0.1
 */
public class Guest {

	private String guestName;
	private Room room;

	/**.
	 * Constructor for <code>Guest</code> Sets the name of the guest to given
	 * parameter
	 * 
	 * @param name
	 *            name of the guest
	 */
	/*@ requires name != null; */
	public Guest(String name) {
		guestName = name;
	}

	/**.
	 * Returns the room of the <code>Guest</code>
	 * 
	 * @return Room room
	 */
	/*@ pure */
	public Room getRoom() {
		return room;
	}

	/**.
	 * returns the name of the <code>Guest</code>
	 * 
	 * @return String name
	 */
	public String getName() {
		return guestName;
	}
	
	/*@ requires getRoom() != null && r.getGuest() != null; */
	public boolean checkin(Room r) {
		r.setGuest(this);
		room = r;
		return true;
	}

	/**.
	 * Checks the <code>Guest</code> out of the <code>Room</code> If the
	 * <code>Room</code> was already empty, returns false otherwise sets
	 * <code>Guest</code> of the <code>Room</code> to null, and the
	 * <code>Room</code> to null
	 * 
	 * @return Boolean true or false
	 */
	/*@ requires getRoom() != null; */
	public boolean checkout() {
		room.getSafe().deactivate();
		room.setGuest(null);
		room = null;
		return true;
	}
	
	/**.
	 * ToString method to print the room and name of the guest in a nice format
	 * @return String toString
	 */
	/*@ requires getRoom() != null && getRoom().getGuest() != null;
	 	ensures \result != null;*/
	public String toString() {
		return "Room: " + getRoom() + " for Guest: " + getRoom().getGuest();
	}
}