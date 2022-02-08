package com.Papsi.Bus;

import java.util.Scanner;

public class Passenger {

	private Scanner in = new Scanner(System.in);
	private boolean isNumber;
	private char charchecker;

	// 610 people with 8 columns which are: "Last Name", "First Name", "Middle
	// Initial", "alias", "age", "category", total, Transaction Number

	public static String Table[][] = new String[610][8];
	
	//number of passengers
	int numberOfPassengers(int busDisplayCapacity) {
		String numPass;
		while (true) {
			try {
				System.out.print("\nEnter number of Passengers: ");
				numPass = in.nextLine();
				if (numPass.length() < 1) {
					System.out.println(">> Input Necessary Details");
					continue;
				}
				if (Integer.parseInt(numPass) < 1) {
					System.out.println(">> Invalid Input");
					continue;
				}
				if (Integer.parseInt(numPass) > busDisplayCapacity) {
					System.out.println(">> Exceed number of passengers");
					continue;
				}
			} catch (Exception e) {
				System.out.println(">> Invalid Input");
				continue;
			}
			break;
		}
		return Integer.parseInt(numPass);
	}
	
	//lastname
	String lastName(int ct) {
		String lastName;
		while (true) {
			isNumber = false;
			System.out.print("\nEnter Person " + (ct + 1) + "'s: Last Name: ");
			lastName = in.nextLine();
			if (lastName.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			} else if (lastName.length() < 2) {
				System.out.println(">> Name must be atleast 2 characters");
				continue;
			}

			for (int y = 0; y < lastName.length(); y++) {
				charchecker = lastName.charAt(y);
				if (charchecker >= 'a' && charchecker <= 'z') {
				} else if (charchecker >= 'A' && charchecker <= 'Z') {
				} else if (charchecker == ' ' || charchecker == '.') {
				} else {
					isNumber = true;
					break;
				}
			}

			if (isNumber == true) {
				System.out.println(">> Invalid Input");
				continue;
			} else {
				break;
			}

		}
		return lastName;
	}

	//firstname
	String firstName(int ct) {
		String firstName;
		while (true) {
			isNumber = false;
			System.out.print("Enter Person " + (ct + 1) + "'s: First Name: ");
			firstName = in.nextLine();
			if (firstName.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			} else if (firstName.length() < 2) {
				System.out.println(">> Name must be atleast 2 characters");
				continue;
			}

			for (int y = 0; y < firstName.length(); y++) {
				charchecker = firstName.charAt(y);
				if (charchecker >= 'a' && charchecker <= 'z') {
				} else if (charchecker >= 'A' && charchecker <= 'Z') {
				} else if (charchecker == ' ' || charchecker == '.') {
				} else {
					isNumber = true;
					break;
				}
			}

			if (isNumber == true) {
				System.out.println(">> Invalid Input");
				continue;
			} else {
				break;
			}

		}
		return firstName;
	}
	
	//midddle initial
	String middleInitial(int ct) {
		String middleInitial;
		while (true) {
			isNumber = false;
			System.out.print("Enter Person " + (ct + 1) + "'s: Middle Initial: ");
			middleInitial = in.nextLine().toUpperCase();
			if (middleInitial.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			} else if (middleInitial.length() > 2) {
				System.out.println(">> Name must be 1 or 2 characters only");
				continue;
			}

			for (int y = 0; y < middleInitial.length(); y++) {
				charchecker = middleInitial.charAt(y);
				if (charchecker >= 'A' && charchecker <= 'Z') {
				} else {
					isNumber = true;
					break;
				}
			}

			if (isNumber == true) {
				System.out.println(">> Invalid Input");
				continue;
			} else {
				break;
			}

		}
		return middleInitial;
	}

	//age
	int age(int ct) {
		String sage;
		int age;
		while (true) {
			try {
				System.out.print("Enter Person " + (ct + 1) + "'s: age: ");
				sage = in.nextLine();
				if (sage.length() < 1) {
					System.out.println(">> Input Necessary Details");
					continue;
				}
				if (Integer.parseInt(sage) < 0) {
					System.out.println(">> Invalid Input");
					continue;
				}
			} catch (Exception e) {
				System.out.println(">> Invalid Input");
				continue;
			}
			age = Integer.parseInt(sage);
			break;
		}
		return age;
	}

	//alias
	String alias(int ct) {
		String alias;
		while (true) {
			System.out.print("Enter Person " + (ct + 1) + "'s: alias: ");
			alias = in.nextLine();
			if (alias.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			break;
		}
		return alias;
	}

	//insurance
	String availInsurance(int ct) {
		String insurance;
		while (true) {
			System.out.print("Avail Insurance? [Y] or [N]: ");
			insurance = in.nextLine().toLowerCase();
			if (insurance.equals("y")) {
				insurance = "Yes";
				break;
			} else if (insurance.equals("n")) {
				insurance = "No";
				break;
			} else {
				System.out.println(">> Invalid Input");
				continue;
			}
		}
		return insurance;
	}
}
