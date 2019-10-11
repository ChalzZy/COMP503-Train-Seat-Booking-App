/**
 * Returns all the attributes that a train journey would have.
 * Includes things such as source city, destination city and departure time.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;

/**
 *	Attributes of a TrainJourney
 */
public class TrainJourney {
	private String journeyNumber;
	private String sourceCity;
	private String destCity;
	private String departureTime;
	private FloorGrid seating;
	
	/*
	 * Constructor
	 */
	public TrainJourney(String journeyNumber, String sourceCity, String destCity, String departureTime, FloorGrid seating) {
		this.journeyNumber = journeyNumber;
		this.sourceCity = sourceCity;
		this.destCity = destCity;
		this.departureTime = departureTime;
		this.seating = seating;
	}
	
	/**
	 * @return The Journey Number (E.g. 001)
	 */
	public String getJourneyNumber() {
		return journeyNumber;
	}
	
	/**
	 * @return Gets source city (E.g. Auckland)
	 */
	public String getSourceCity() {
		return sourceCity;
	}
	
	/**
	 * @param sourceCity Sets the source city
	 */
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	
	/**
	 * @return Gets the destination city (E.g. Auckland)
	 */
	public String getDestCity() {
		return destCity;
	}
	
	/**
	 * @param destCity Sets the destination city
	 */
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	
	/**
	 * @return Prints the 2D array of seats
	 */
	public FloorGrid getSeating() {
		return seating;
	}
	
	/**
	 * @param seating Sets the 2D array of seats
	 */
	public void setSeating(FloorGrid seating) {
		this.seating = seating;
	}
	
	/**
	 * @return Gets the departure time of the train
	 */
	public String getTime() {
		return departureTime;
	}
	
	/**
	 * @return Sets the departure time of the train.
	 */
	public void setTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Description of the train journey
	 */
	@Override
	public String toString() {
		return getJourneyNumber()+": Src City: " +getSourceCity()+ " | Dst City: " +getDestCity()+ " | Dpt Time: " +getTime();
	}
}
