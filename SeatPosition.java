/**
 * This method returns the row and column of a seat.
 * 
 * @author Charles 18012390
 * @version 1.0
 */
package trainSeatBookingApp;

public class SeatPosition {
	private int row;
	private char column;
	
	/**
	 * Seat position of the seat. (e.g. [1A])
	 * 
	 * @param row 		Row of the seat [1 _]
	 * @param column	Column of the seat [_ A]
	 */
	public SeatPosition(int row, char column) {
		this.row = row; // e.g. [1_]
		this.column = column; // e.g. [_A]
	}
	
	/**
	 * @return row of the seat
	 */
	public int getRow() {
		return row + 1;
	}
	
	/**
	 * @return column of the seat
	 */
	public char getColumn() {
		return column;
	}
}
