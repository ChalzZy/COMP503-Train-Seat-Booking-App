/*
 * This method allows enables the program to get the seat to the left or right of the chosen seat.
 * This method also enables the program to find the last seat position.
 * 
 * @author Charles 18012390
 * @version 1.0
 */
package trainSeatBookingApp;

public abstract class FloorGrid {
	protected Seat[][] seats;
	protected int nRow; // row11
	protected int nColumns; //col
	protected int nFirstClassRows;
	
	abstract protected void initialiseFloorGrid(); 
	 
	/**
	 * @return the last column
	 */
	public char lastSeatPosition() { // last column
		return (char)(nColumns+65);
	}
	
	/**
	 * @return the last row
	 */
	public int lastSeatRow() { // last row
		return nRow;
	}
	
	/**
	 * @param aSeat The chosen seat
	 * @return The seat left of the the chosen seat
	 */
	public Seat getLeft(Seat aSeat) {
		int seatRow = aSeat.getSeatPosition().getRow();
		int seatCol = (int)aSeat.getSeatPosition().getColumn()-65;
		if (seatCol <= 0) {
			return null;
		}
		else {
			return seats[seatRow][seatCol-1];
		}
	}
	
	/**
	 * @param aSeat The chosen seat
	 * @return The seat right of the chosen seat
	 */
	public Seat getRight(Seat aSeat) {
		int seatRow = aSeat.getSeatPosition().getRow();
		int seatCol = (int)aSeat.getSeatPosition().getColumn()-65;
		if (seatCol >= nRow-1) {
			return null;
		}
		else {
			return seats[seatRow][seatCol+1];
		}
	}
	
	/**
	 * Grid representation
	 */
	public String toString() {
		String returnValue = "";
		char ASCII = 'A';
		returnValue+="    "+ASCII++;
		for (int i = 1; i < nColumns; ++i) {
			returnValue+="     "+ASCII++;	
		}
		returnValue+="\n";
		for (int i = 0; i < nRow; ++i) {
			if(i<9) {
				returnValue+=" ";
			}
			returnValue+=i+1+" ";
			for(int j = 0; j < nColumns; ++j) {
				returnValue+=seats[i][j];
			}
			returnValue += "\n";
		}
		return returnValue;
	}
	
	/**
	 * @param aType Chosen seat
	 * @return Whether the seat is booked or not
	 */
	public Seat queryAvailableEconomySeat(SeatType aType) {
		Seat bookedSeat = null;
		for (int i = nFirstClassRows; i < nRow; ++i) {
			for (int j = 0; j < nColumns; ++j) {
				Seat seat = seats[i][j];
				if(!seat.isReserved()) {
					bookedSeat = seat;
					if(seat.getSeatType() == aType) {
						return seat;
					}
				}
			}
		}
		
		return bookedSeat;
	}
	
	/**
	 * @param aType Chosen seat
	 * @return Whether the seat is booked or not
	 */
	public Seat queryAvailableFirstClassSeat(SeatType aType) {
		Seat bookedSeat = null;
		for (int i = 0; i < nFirstClassRows; ++i) {
			for (int j = 0; j < nColumns; ++j) {
				Seat seat = seats[i][j];
				if(!seat.isReserved()) {
					bookedSeat = seat;
					if(seat.getSeatType() == aType) {
						return seat;
					}
				}
			}
		}
		return bookedSeat;
	}
	
	/**
	 * 
	 * @param seatRow Row of seat
	 * @param seatPosition Column of seat
	 * @return Position of seat in array
	 */
	public Seat getSeat(int seatRow, char seatPosition) {
		return seats[seatRow][(int)seatPosition-65];
	}
}
