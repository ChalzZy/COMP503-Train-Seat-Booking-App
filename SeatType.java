/**
 * Enumeration class that returns whether a seat is a window, aisle or middle seat.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;

public enum SeatType {
	WINDOW, AISLE, MIDDLE;

	public String toString() {
		return this.name();
	}
}
