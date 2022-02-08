package com.Papsi.Bus;

import java.util.Scanner;

public class Search {

	// objects
	Transaction transaction = new Transaction();
	Scanner in = new Scanner(System.in);
	Passenger passenger = new Passenger();
	Bus bus = new Bus();

	// variables
	private String inputTransaction;
	private boolean isTransactionNumberFound;
	
	//searching the receipt
	void Start() {
		String choice;
		isTransactionNumberFound = false;
		//enter the user's transaction number
		while (true) {
			try {
				System.out.print("\nEnter your transaction number: ");
				inputTransaction = in.nextLine();
				if (inputTransaction.length() < 1) {
					System.out.println(">> Input Necessary Details");
					System.out.print("Do you want to proceed ? [Y][N]: ");
					choice = in.nextLine().toLowerCase();
					if (choice.equals("y")) {
						continue;
					} else {
						return;
					}

				}
				if (Integer.parseInt(inputTransaction) < 0) {
					System.out.println(">> Input Necessary Details");
					System.out.print("Do you want to proceed ? [Y][N]: ");
					choice = in.nextLine().toLowerCase();
					if (choice.equals("y")) {
						continue;
					} else {
						return;
					}
				}
			} catch (Exception e) {
				System.out.println(">> Input Necessary Details");
				System.out.print("Do you want to proceed ? [Y][N]: ");
				choice = in.nextLine().toLowerCase();
				if (choice.equals("y")) {
					continue;
				} else {
					return;
				}
			}
			break;
		}
		
		//checking the user's input transaction and number and see to it if there is a data into the database
		for (int x = 0; x < 610; x++) {
			if (Integer.parseInt(inputTransaction) == transaction.getGeneratedNumbers(x)) {
				System.out.print("\n       Receipt      \n\n" + "Details: \n" + "Date: " + bus.database[x][8] + "\n"
						+ "Class: " + bus.database[x][1] + "\n" + "Trip Type: " + bus.database[x][3] + "\n" + "Origin: "
						+ bus.database[x][4] + "\n" + "Destination: " + bus.database[x][5] + "\n"
						+ "Number of Passenger/s: " + bus.database[x][2] + "\n" + "Transaction Number: "
						+ bus.database[x][0] + "\n\n");
				for (int y = 0; y < 610; y++) {
					if (inputTransaction.equals(passenger.Table[y][7])) {
						transaction.DisplayTransactions(y, passenger.Table[y][0], passenger.Table[y][1],
								passenger.Table[y][2], passenger.Table[y][3], passenger.Table[y][4],
								passenger.Table[y][5], passenger.Table[y][6]);
					}
				}
				System.out.println("Grand Total: " + bus.database[x][6]);
				System.out.println("Change: " + transaction.format.format(Double.parseDouble(bus.database[x][7])));
				isTransactionNumberFound = true;
				break;
			}
		}

		if (isTransactionNumberFound == false) {
			System.out.println(">> No transaction Number Matched");
		}

	}
}
