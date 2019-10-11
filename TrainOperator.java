/**
 * Class for the train operator
 * 
 * @author Charles 18012390
 * @version 1.0
 */
package trainSeatBookingApp;

public abstract class TrainOperator {
	private String operatorName;
	
	/**
	 * 
	 * @param aJourney TrainJourney Object
	 * @param aType SeatType (WINDOW, AISLE or MIDDLE)
	 * @return a Seat Class
	 */
	abstract public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType);
	abstract public Seat reserveEconomy(TrainJourney aJourney, SeatType aType);
	
	/**
	 * @return Operator name
	 */ 
	public String getOperatorName() {
		return operatorName;
	}
	
	/**
	 * @param operatorName Pass in operator name
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * String representation of the operator
	 */
	public String toString() {
		return "TrainOperator [operatorName=" + operatorName + "]";
	}
}
