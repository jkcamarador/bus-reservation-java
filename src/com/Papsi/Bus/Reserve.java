package com.Papsi.Bus;

import java.util.Scanner;
import java.util.Date;

public class Reserve extends Bus {

	// Objects
	private Scanner in = new Scanner(System.in);
	private Bus_Type bus_Type = new Bus_Type();
	private Destination destination = new Destination();
	private Transaction transaction = new Transaction();
	private Passenger passenger = new Passenger();

	// Variables
	private String choice, choicedestination, choicebusclass, busClass;
	private int indexBusDestination, indexBusClass, busDisplayCapacity;
	private String tripType;
	private double price;
	private boolean isAllChild;

	public void Start() {
		//display destination table
		destinationTable();
		
		//temporary storages
		 String tlastname[] = new String[55];
		 String tfirstname[] = new String[55];
		 String tmiddleinitial[] = new String[55];
		 String talias[] = new String[55];
		 int tage[] = new int[55];
		 String tcategory[] = new String[55];
		 double tdiscount[] = new double[55];
		 String isAvailedInsurance[] = new String[55];
		 double ttotal[] = new double[55];
		 double tgrandtotal = 0;
		 Date date = java.util.Calendar.getInstance().getTime();
		
		isAllChild = true;
		
		//choosing bus destination and class type
		choicedestination = destination.destination();
		choicebusclass = bus_Type.busClass();

		//assigning the index for the 2d array table from class: bus_Type
		if (choicedestination.equals("a")) {
			indexBusDestination = 0;
		} else if (choicedestination.equals("b")) {
			indexBusDestination = 1;
		} else if (choicedestination.equals("c")) {
			indexBusDestination = 2;
		} else if (choicedestination.equals("d")) {
			indexBusDestination = 3;
		} else if (choicedestination.equals("e")) {
			indexBusDestination = 4;
		} else if (choicedestination.equals("f")) {
			indexBusDestination = 5;
		} else if (choicedestination.equals("g")) {
			indexBusDestination = 6;
		} else if (choicedestination.equals("h")) {
			indexBusDestination = 7;
		} else if (choicedestination.equals("i")) {
			indexBusDestination = 8;
		} else if (choicedestination.equals("j")) {
			indexBusDestination = 9;
		}

		if (choicebusclass.equals("a")) {
			indexBusClass = 3;
			busClass = "Class A";
		} else if (choicebusclass.equals("b")) {
			indexBusClass = 4;
			busClass = "Class B";
		} else if (choicebusclass.equals("c")) {
			indexBusClass = 5;
			busClass = "Class C";
		} else if (choicebusclass.equals("d")) {
			indexBusClass = 6;
			busClass = "Class D";
		}
		
		//storing the bus capacity into a temporary variable
		busDisplayCapacity = bus_Type.getBusCapacity(indexBusDestination, indexBusClass);
		
		//restrictions 
		if (table[indexBusDestination][indexBusClass].equals("No Trip Available")) {
			System.out.println("No Trip Available");
			return;
		}
		if (busDisplayCapacity == 0) {
			System.out.println("Maximum Passengers Alloted");
			return;
		}
		
		//storing price from the array table
		price = Double.parseDouble(table[indexBusDestination][indexBusClass]);
		
		//display details first before continue
		while (true) {
			System.out.print("\nYou have chosen bus " + table[indexBusDestination][0] + "\n" + "Bus "
					+ table[indexBusDestination][0] + " details: \n" + "Class: " + busClass + "\n" + "Origin: "
					+ table[indexBusDestination][1] + "\n" + "Destination: " + table[indexBusDestination][2] + "\n"
					+ "Price: Php " + price + "\n" + "Capacity: " + busDisplayCapacity + "\n"
					+ "Do you want to proceed ? [Y][N]: ");
			choice = in.nextLine().toLowerCase();
			if (choice.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (choice.equals("y")) {
				destination.setOrigin(table[indexBusDestination][1]);
				destination.setDestination(table[indexBusDestination][2]);
				bus_Type.setBusClass(busClass);
				bus_Type.setBusprice(Double.parseDouble(table[indexBusDestination][indexBusClass]));
				break;
			} else if (choice.equals("n")) {
				return;
			} else {
				System.out.println(">> Invalid Input");
				continue;
			}
		}
		
		//assigning the triptype
		tripType = tripType();

		//input the details of passengers and storing it into temporary variable
		int numberOfPassengers = passenger.numberOfPassengers(busDisplayCapacity);
		for (int ct = 0; ct < numberOfPassengers; ct++) {
			tlastname[ct] = passenger.lastName(ct);
			tfirstname[ct] = passenger.firstName(ct);
			tmiddleinitial[ct] = passenger.middleInitial(ct);
			talias[ct] = passenger.alias(ct);
			tage[ct] = passenger.age(ct);
			isAvailedInsurance[ct] = passenger.availInsurance(ct);
		}

		//storing data into temporary variable 
		for (int ct = 0; ct < numberOfPassengers; ct++) {
			if (tage[ct] < 18) {
				tcategory[ct] = "Child";
				tdiscount[ct] = 0;
			} else if (tage[ct] > 17 && tage[ct] < 60) {
				tcategory[ct] = "Adult";
				tdiscount[ct] = 0;
				isAllChild = false;
			} else {
				tcategory[ct] = "Senior";
				tdiscount[ct] = 0.12;
				isAllChild = false;
			}
		}
		
		//age restriction
		if (isAllChild == true) {
			System.out.println("Child cannot travel alone");
			return;
		}
		
		//computing the total and the grand total
		for (int ct = 0; ct < numberOfPassengers; ct++) {
			ttotal[ct] = transaction.process(ct, destination.getOrigin(), price, tripType, isAvailedInsurance[ct],
					tdiscount[ct], busClass);
			tgrandtotal = tgrandtotal + ttotal[ct];
		}
		
		//prompts if the user want to continue
		transaction.proceedToPayment(tgrandtotal);
		if (transaction.isCancelPayment() == true) {
			return;
		}
		//payment details
		double payment = transaction.payment(tgrandtotal);
		if (transaction.isCancelPayment() == true) {
			return;
		}
		
		//process the final touches
		double change = payment - tgrandtotal;
		int random = transaction.getRandom();
		bus_Type.setBusCapacity(indexBusDestination, indexBusClass, numberOfPassengers);
		
		//displaying the receipt
		System.out.print("\n\n       Receipt      \n\n" + "Bus " + table[indexBusDestination][0] + " details: \n"
				+ "Date: " + date + "\n" + "Class: " + busClass + "\n" + "Trip Type: " + tripType + "\n" + "Origin: "
				+ table[indexBusDestination][1] + "\n" + "Destination: " + table[indexBusDestination][2] + "\n"
				+ "Number of Passenger/s: " + numberOfPassengers + "\n" + "Transaction Number: " + random + "\n\n");
		transaction.DisplayTransactions(numberOfPassengers, tlastname, tfirstname, tmiddleinitial, talias, tage,
				tcategory, price, tripType, ttotal, tdiscount);
		System.out.println("\nGrand Total: Php " + transaction.format.format(tgrandtotal));
		System.out.println("Payment: Php " + payment);
		System.out.println("Change: Php " + transaction.format.format(change));
		System.out.println("\n>> Reserved Successfully");
		
		//store the temporary variables into the database and table from bus and bus_type classes
		for (int ct = 0, y = 0; ct < 610; ct++) {
			if (passenger.Table[ct][0] != null) {
				continue;
			} else {
				if (y >= numberOfPassengers) {
					break;
				}
				passenger.Table[ct][0] = tlastname[y];
				passenger.Table[ct][1] = tfirstname[y];
				passenger.Table[ct][2] = tmiddleinitial[y];
				passenger.Table[ct][3] = talias[y];
				passenger.Table[ct][4] = String.valueOf(tage[y]);
				passenger.Table[ct][5] = tcategory[y];
				passenger.Table[ct][6] = String.valueOf(ttotal[y]);
				passenger.Table[ct][7] = String.valueOf(random);
				y++;
			}
		}

		for (int ct = 0; ct < 610; ct++) {
			if (database[ct][0] != null) {
				continue;
			} else {
				database[ct][0] = String.valueOf(random);
				database[ct][1] = bus_Type.getBusClass();
				database[ct][2] = String.valueOf(numberOfPassengers);
				database[ct][3] = tripType;
				database[ct][4] = destination.getOrigin();
				database[ct][5] = destination.getDestination();
				database[ct][6] = String.valueOf(tgrandtotal);
				database[ct][7] = String.valueOf(change);
				database[ct][8] = String.valueOf(date);
				break;
			}
		}

	}
	
	//display the table
	public void destinationTable() {
		System.out.println(
						"\n+---------------+------------+-----------+-------------+-------------+-------------+-------------+\n"
						+ "|  DESTINATION  |    FROM    |    TO     |   CLASS A   |   CLASS B   |   CLASS C   |   CLASS D   |\n"
						+ "+---------------+------------+-----------+-------------+-------------+-------------+-------------+\n"
						+ "|       A       |  Manila    | Ilocos    |  950 pesos  |     N/A     |     N/A     | 1100 pesos  |\n"
						+ "|       B       |  Ilocos    | Manila    |  955 pesos  |     N/A     |     N/A     | 1350 pesos  |\n"
						+ "|       C       |  Manila    | Pampanga  |     N/A     |  400 pesos  |  375 pesos  |  600 pesos  |\n"
						+ "|       D       |  Pampanga  | Manila    |     N/A     |  450 pesos  |  400 pesos  |  700 pesos  |\n"
						+ "|       E       |  Manila    | Zambales  |     N/A     |  390 pesos  |     N/A     |     N/A     |\n"
						+ "|       F       |  Zambales  | Manila    |     N/A     |  430 pesos  |     N/A     |     N/A     |\n"
						+ "|       G       |  Manila    | Baguio    |  785 pesos  |     N/A     |  400 pesos  |  788 pesos  |\n"
						+ "|       H       |  Baguio    | Manila    |  830 pesos  |     N/A     |  430 pesos  |  840 pesos  |\n"
						+ "|       I       |  Manila    | Tugegarao | 1300 pesos  |  975 pesos  |     N/A     |     N/A     |\n"
						+ "|       J       |  Tugegarao | Manila    | 1340 pesos  | 1000 pesos  |     N/A     |     N/A     |\n"
						+ "+---------------+------------+-----------+-------------+-------------+-------------+-------------+");
	}
	
	//display charges
	public void chargesAndServices() {
		System.out.println(
						"\n+-------+-----------+-----------------------------------+--------------------------------------------------------------+\n"
						+ "| CLASS | INSURANCE |       MAX NO. OF PASSENGER        |  NON MANILA ADDITIONAL CHARGE FEE (85.00 pesos standard fee) |\n"
						+ "+-------+-----------+-----------+-----------------------+--------------------------------------------------------------+\n"
						+ "|   A   | 195 pesos | 25 (w/ 2 drivers and 2 conductor) |                            30.00 pesos                       |\n"
						+ "|   B   | 140 pesos | 40 (w/ 2 drivers and 2 conductor) |                            20.00 pesos                       |\n"
						+ "|   C   | 95 pesos  | 60 (w/ 3 drivers and 2 conductor) |                            15.00 pesos                       |\n"
						+ "|   D   | 50 pesos  | 10 (w/ 2 drivers)                 |                            10 pesos                          |\n"
						+ "+-------+-----------+-----------------------------------+--------------------------------------------------------------+");
	}
}
