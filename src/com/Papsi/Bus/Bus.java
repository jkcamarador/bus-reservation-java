package com.Papsi.Bus;

import java.util.Scanner;

public class Bus {

	private Scanner in = new Scanner(System.in);
	
	//array for table of data
	public String table[][] = { { "A", "Manila", "Ilocos", "950", "No Trip Available", "No Trip Available", "1100" },
			{ "B", "Ilocos", "Manila", "995", "No Trip Available", "No Trip Available", "1350" },
			{ "C", "Manila", "Pampanga", "No Trip Available", "400", "375", "600" },
			{ "D", "Pampanga", "Manila", "No Trip Available", "450", "400", "700" },
			{ "E", "Manila", "Zambales", "No Trip Available", "390", "No Trip Available", "No Trip Available" },
			{ "F", "Zambales", "Manila", "No Trip Available", "430", "No Trip Available", "No Trip Available" },
			{ "G", "Manila", "Baguio", "765", "No Trip Available", "400", "785" },
			{ "H", "Baguio", "Manila", "830", "No Trip Available", "430", "840" },
			{ "I", "Manila", "Tugegarao", "1300", "975", "No Trip Available", "No Trip Available" },
			{ "J", "Tugegarao", "Manila", "1340", "1000", "No Trip Available", "No Trip Available" } };

	// 610 possible groups with 9 columns which are: transact Number, busClass,
	// "Number Of passenger, Trip Type, origin, destination, grandtotal, change, and date
	public static String database[][] = new String[610][9];

	//choosing the type of trip
	String tripType() {
		String tripType;
		while (true) {
			System.out.print("\nPlease choose your trip type One Way[O] or Round Trip[R]: ");
			tripType = in.nextLine().toLowerCase();
			if (tripType.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (tripType.equals("o")) {
				tripType = "One Way";
				break;
			} else if (tripType.equals("r")) {
				tripType = "Round Trip";
				break;
			} else {
				System.out.println(">> Invalid Input");
				continue;
			}
		}
		return tripType;
	}

}
