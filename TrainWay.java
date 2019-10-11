/**
 * TrainWay is a child class of TrainOperator
 * TrainWay checks seats and reserved first and economy class seats.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;

public class TrainWay extends TrainOperator {

	/*
	 * Name of the train operator
	 */
	public TrainWay(String name) {
		super.setOperatorName(name);
	}
	
	/*
	 * Reserves a first class seat
	 */
	@Override
	public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType) {
		FloorGrid seating = aJourney.getSeating();
		Seat seat = seating.queryAvailableFirstClassSeat(aType);
		if(seat == null) {
			seat = seating.queryAvailableEconomySeat(SeatType.WINDOW);
			if(seat == null || seat.getSeatType() != SeatType.WINDOW) {
				return null;
			}
		}
		seat.setReserved(true);
		return seat;
	}
	
	/*
	 * Reserved a economy class seat
	 */
	@Override
	public Seat reserveEconomy(TrainJourney aJourney, SeatType aType) {
		FloorGrid seating = aJourney.getSeating();
		Seat seat = seating.queryAvailableEconomySeat(aType);
		if(seat == null || seat.getSeatType() != aType) {
			seat = seating.queryAvailableFirstClassSeat(SeatType.WINDOW);
			if(seat == null || seat.getSeatType() != SeatType.WINDOW) {
				return null;
			}
		}
		seat.setReserved(true);
		return seat;
	}
}
