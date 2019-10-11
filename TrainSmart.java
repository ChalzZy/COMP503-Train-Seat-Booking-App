/**
 * TrainSmart is a child class of TrainOperator
 * TrainSmart checks seats and reserved first and economy class seats.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;

public class TrainSmart extends TrainOperator {

	/*
	 * Name of the train operator
	 */
	public TrainSmart(String name) {
		super.setOperatorName(name);
	}
	
	/*
	 * Reserves a first class seat
	 */
	@Override
	public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType) {
		FloorGrid seating = aJourney.getSeating();
		Seat seat = seating.queryAvailableFirstClassSeat(aType);
		if(seat.getSeatType() != aType) {
			seat = seating.queryAvailableEconomySeat(SeatType.WINDOW);
			if(seat.getSeatType() != SeatType.WINDOW) {
				seat = seating.queryAvailableEconomySeat(SeatType.AISLE);
				if(seat.getSeatType() != SeatType.AISLE) {
					return null;
				}
			}
			Seat left = seating.getLeft(seat);
			if(left == null) {
				seating.getRight(seat).setReserved(true);
			}
			else {
				left.setReserved(true);
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
		if(seat != null && seat.getSeatType() == aType) {
			seat.setReserved(true);
			return seat;
		}
		else {
			return null;
		}
	}
}
