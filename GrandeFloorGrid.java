/**
 * Initialises the floor grid. Sets the number of rows, columns and first class rows.
 * 
 * @author Charles 18012390
 * @version 1.0
 */
package trainSeatBookingApp;

public class GrandeFloorGrid extends FloorGrid {

	/**
	 * Number of rows, columns and first class rows
	 */
	public GrandeFloorGrid() {
		super.nRow = 12;
		super.nColumns = 9;
		super.nFirstClassRows = 6;
		initialiseFloorGrid();
	}
	
	/**
	 * Initialises floor grid
	 */
	public void initialiseFloorGrid() {
		seats = new Seat[nRow][nColumns];
		for(int i = 0; i < nRow; ++i) {
			for (int j = 0; j < nColumns; ++j) {
				SeatType type = null;
				if(j == 0 || j == nColumns-1) {
					type = SeatType.WINDOW;
				}
				else if(j == 1 || j == 2 || j == 3 || j == 5 || j == 6) {
					type = SeatType.AISLE;
				}
				else {
					type = SeatType.MIDDLE;

				}
				
				boolean firstClass = false;
				if(i < nFirstClassRows) {
					firstClass = true;
				}
				
				seats[i][j] = new Seat(new SeatPosition(i+1, (char)(j+65)), type, firstClass);
			}
		}
	}
}