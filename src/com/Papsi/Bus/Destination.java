package com.Papsi.Bus;

import java.util.Scanner;

public class Destination extends Bus {

	private Scanner in = new Scanner(System.in);
	
	//origin and destination
	private String origin, destination;

	//setters
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	//getters
	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}
	
	//choose destination
	String destination() {
		String choice1;
		while (true) {
			System.out.print("\nEnter your bus destination [a - j] (refer to the table above): ");
			choice1 = in.nextLine().toLowerCase();
			if (choice1.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (!(choice1.equals("a") || choice1.equals("b") || choice1.equals("c") || choice1.equals("d")
					|| choice1.equals("e") || choice1.equals("f") || choice1.equals("g") || choice1.equals("h")
					|| choice1.equals("i") || choice1.equals("j"))) {
				System.out.println(">> Invalid input");
				continue;
			}
			break;
		}
		return choice1;
	}

}
