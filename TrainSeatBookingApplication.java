/**
 * This is the main method.
 * Creates 4 journeys and 2 train operators and books seats depending on user input.
 * 
 * @author Charles
 * @version 1.0
 */
package trainSeatBookingApp;
import java.util.Scanner;

public class TrainSeatBookingApplication {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Initialises different journeys
		//------------------------------------------------------------------------------
		// Journeys for TrainWay
		TrainJourney journey1 = new TrainJourney("001", "Whiterun", "Riften", "11:00", new PetiteFloorGrid());
		TrainJourney journey2 = new TrainJourney("002", "Riften", "Solitude", "13:30", new GrandeFloorGrid());
		// Journeys for TrainSmart
		TrainJourney journey3 = new TrainJourney("003", "", "Riften", "10:00", new PetiteFloorGrid());
		TrainJourney journey4 = new TrainJourney("004", "Whiterun", "Riften", "12:00", new GrandeFloorGrid());
		// Train operators
		TrainOperator trainSmart = new TrainSmart("Ulfric");
		TrainOperator trainWay = new TrainWay("Cicero");
		//------------------------------------------------------------------------------

		
		// Welcome Messages
		//------------------------------------------------------------------------------
			//Welcome user
			welcomeMessage();
			chooseTrainOperator();
		//------------------------------------------------------------------------------

			TrainJourney selectedJourney = null;
			TrainOperator selectedOperator = null;
			SeatType seatType = null;
			boolean seatClass = true; //false = economy, true = first class

			/**
			 * Selects the train operator
			 */
			int chosenTrainOperator = 0;
			boolean loop = true;
			while (loop) {
				System.out.print(">> ");
				chosenTrainOperator = scan.nextInt();
				// TrainSmart Operator
				if (chosenTrainOperator == 1) {
					selectedOperator = trainSmart;
					loop = false;
					System.out.println("--");
					System.out.println("#TRAINSMART#: Avaiable lines today | Operator: " + trainSmart.getOperatorName());
					System.out.println("--");
					System.out.println("Petite Train (1) " + journey3.toString()); // petite
					System.out.println("Grande Train (2) " + journey4.toString()); // grande
					System.out.println();
					int chosenCompany = 0;
					boolean loop1 = true;
					while (loop1) {
						System.out.print(">> ");
						chosenCompany = scan.nextInt();
						if (chosenCompany == 1) {
							selectedJourney = journey3;
							loop1 = false;
						} else if (chosenCompany == 2) {
							selectedJourney = journey4;
							loop1 = false;
						} else {
							System.out.println("Incorrect input. Please choose either the petite train (1) or the grande train (2)");
						}
					}
				// TrainWay Operator
				} else if (chosenTrainOperator == 2) {
					selectedOperator = trainWay;
					loop = false;
					System.out.println("--");
					System.out.println("#TRAINWAY#: Avaiable lines today | Operator: " + trainWay.getOperatorName());
					System.out.println("--");
					System.out.println("Petite Train (1) " + journey1.toString()); // petite
					System.out.println("Grande Train (2) " + journey2.toString()); // grande
					int chosenCompany = 0;
					boolean loop1 = true;
					while (loop1) {
						System.out.print(">> ");
						chosenCompany = scan.nextInt();
						if (chosenCompany == 1) {
							selectedJourney = journey1;
							loop1 = false;
						} else if (chosenCompany == 2) {
							selectedJourney = journey2;
							loop1 = false;
						} else {
							System.out.println("Incorrect input. Please choose either the petite train (1) or the grande train (2)");
						}
					}
				} else {
					System.out.println("Incorrect input, enter either 1 or 2");
				}

				boolean finished = false;
				while(!finished) {
				//Print out grid
				System.out.println(selectedJourney.getSeating());

				//Get preferred seat information
				System.out.println("(1) First Class");
				System.out.println("(2) Economy Class");
				int firstOrEcon = 0;
				boolean loop2 = true;
				while (loop2) {
					System.out.print(">> ");
					firstOrEcon = scan.nextInt();
					if (firstOrEcon == 1) {
						seatClass = true;
						loop2 = false;
					} else if (firstOrEcon == 2) {
						seatClass = false;
						loop2 = false;
					} else {
						System.out.println("Incorrect input. Please choose either first class or economy seats");
					}
				}
				// Prompts for WINDOW, AISLE or MIDDLE
				System.out.println("(1) Window");
				System.out.println("(2) Aisle");
				System.out.println("(3) Middle");
				int chosenSeat = 0;
				boolean loop3 = true;
				while (loop3) {
					System.out.print(">> ");
					chosenSeat = scan.nextInt();
					if (chosenSeat == 1) {
						seatType = SeatType.WINDOW;
						loop3 = false;
					} else if (chosenSeat == 2) {
						seatType = SeatType.AISLE;
						loop3 = false;
					} else if (chosenSeat == 3) {
						seatType = SeatType.MIDDLE;
						loop3 = false;
					} else {
						System.out.println("Incorrect input. Please choose either a window, aisle or middle seat");
					}
				}

				Seat seat;
				if (seatClass) {
					//first class
					seat = selectedOperator.reserveFirstClass(selectedJourney, seatType);
				} else {
					//economy class
					seat = selectedOperator.reserveEconomy(selectedJourney, seatType);
				}

				if (seat == null) {
					System.out.println("Booking could not be made.");
				} else {
					System.out.println("Seat Booked: " + seat.toString());
				}
					// prints out the grid
					System.out.println(selectedJourney.getSeating());
					// Make another booking?
					System.out.println("Would you like to make another booking?");
					System.out.println("(1) Yes");
					System.out.println("(2) No");
					int anotherBooking = 0;
					boolean loop4 = true;
					while (loop4) {
						System.out.print(">> ");
						anotherBooking = scan.nextInt();
						if (anotherBooking == 1) {
							finished = false;
							loop4 = false;
						} else if(anotherBooking == 2){
							System.out.println(selectedJourney.getSeating());
							finished = true;
							loop4 = false;
						}else {
							System.out.println("Incorrect input. Please choose either a window, aisle or middle seat");
						}
					}
			}
		}
			scan.close(); // Close memory leak
	}
	
	/**
	 * Welcome Message text
	 */
	public static void welcomeMessage() {
		System.out.println("##--------------------------------------------------------##");
		System.out.println("    Welcome, please choose your desired operator & trip.");
		System.out.println("##--------------------------------------------------------##");
		System.out.println();
	}
	
	/**
	 * Train Operator text
	 */
	public static void chooseTrainOperator() {
		System.out.println("Which train operator would you like?");
		System.out.println("Press 1 for TrainSmart or 2 for TrainWay");
		System.out.println("--");
		System.out.println("(1) TrainSmart");
		System.out.println("(2) TrainWay");
		System.out.println("--");
	}
}
