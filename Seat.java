/**
 * 
 * This method has all the attributes you'd expect a seat to have.
 * It includes attributes such as the type of seat, the seat position and checks if it's reserved.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;

public class Seat {
	private SeatType seatType;			// WINDOW, AISLE or MIDDLE
	private boolean firstClass;			// First class?: YES or NO
	private boolean reserved;			// Reserved?: YES or NO
	private SeatPosition seatPosition;	// Position of seat in the grid
	
	/**
	 * Constructor which uses the seats properties.
	 * 
	 * @param seatPosition	The seats position
	 * @param seatType		The type of the seat (Window, Aisle or Middle)
	 * @param firstClass	Whether the class is first class or not
	 */
	public Seat(SeatPosition seatPosition, SeatType seatType, boolean firstClass) {
		this.seatPosition = seatPosition;
		this.seatType = seatType;
		this.firstClass = firstClass;
	}
	
	/**
	 * @return The seat type (Window, Aisle or Middle)
	 */
	public SeatType getSeatType() {
		return seatType;
	}
	
	/**
	 * @return True if the seat is first class
	 */
	public boolean isFirstClass() {
		return firstClass;
	}
	
	/**
	 * @return True is the seat is booked/reserved
	 */
	public boolean isReserved() {
		return reserved;
	}
	
	/**
	 * Books the seat.
	 * 
	 * @param reserved Books the seat
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	/**
	 * @return Position of the seat
	 */
	public SeatPosition getSeatPosition() {
		return seatPosition;
	}
	
	/**
	 * @return a description of the seat. (Class, reserved and position)
	 */
	public String toDescription() {
		if (reserved) {
			if (firstClass == false) { // First class RESERVED
				return "First class "+seatType.toString()+" seat at: "+toDescription()+"is reserved.";
			}
			else { // Economy class RESERVED
				return "Economy class "+seatType.toString()+" seat at: "+toDescription()+"is reserved.";
			}
		}
		else {
			if (firstClass == true) { // First class NOT BOOKED
				return "First class "+seatType.toString()+" seat at: "+toDescription()+"is not booked.";
			}
			else { // Economy class NOT BOOKED
				return "Economy class "+seatType.toString()+" seat at: "+toDescription()+"is not booked.";
			}
		}

	}
	
	/**
	 * @return string representation of the seat. (E.g. [W _])
	 */
	public String toString() {
		if (isFirstClass()) {
			return ("[" + seatType.toString().charAt(0) + (reserved ? " X " : " _ ") + "]");
		}
		return ("[" + Character.toLowerCase(seatType.toString().charAt(0)) + (reserved ? " X " : " _ ") + "]");
	}
	
	/**
	 * Used for testing this method (Disabled unless needed)
	 */
	//	public static void main(String[] args) {
	//		Seat seat = new Seat(new SeatPosition(8, 'a'), SeatType.MIDDLE, false);
	//		
	//		System.out.println(seat);
	//	}
}


