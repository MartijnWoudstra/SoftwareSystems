package ss.week1.hotel;

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
	public Guest(String name) {
		guestName = name;
	}

	/**.
	 * Returns the room of the <code>Guest</code>
	 * 
	 * @return Room room
	 */
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

	/**.
	 * Checks the <code>Guest</code> into the <code>Room</code>. If the user has
	 * a <code>Room</code>, or the <code>Room</code> is booked, returns false.
	 * Otherwise sets the <code>Guest</code> of the <code>Room</code> to the
	 * current instance, and returns true
	 * 
	 * @param r
	 *            Room
	 * @return Boolean True or False
	 */
	public boolean checkin(Room r) {
		if (getRoom() == null && r.getGuest() == null) {
			r.setGuest(this);
			room = r;
			return true;
		}
		return false;
	}

	/**.
	 * Checks the <code>Guest</code> out of the <code>Room</code> If the
	 * <code>Room</code> was already empty, returns false otherwise sets
	 * <code>Guest</code> of the <code>Room</code> to null, and the
	 * <code>Room</code> to null
	 * 
	 * @return Boolean true or false
	 */
	public boolean checkout() {
		if (getRoom() == null) {
			return false;
		}
		room.setGuest(null);
		room = null;
		return true;
	}
	
	/**.
	 * ToString method to print the room and name of the guest in a nice format
	 * @return String toString
	 */
	public String toString() {
		return "Room: " + room + " for Guest: " + guestName;
	}
}