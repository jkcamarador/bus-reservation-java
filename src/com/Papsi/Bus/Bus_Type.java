package com.Papsi.Bus;

import java.util.Scanner;

public class Bus_Type extends Destination {

	private Scanner in = new Scanner(System.in);
	
	//array for bus Capacity
	public int busCapacity[][] = { 
			{ 0, 0, 0, 21, 36, 55, 8 }, // a
			{ 0, 0, 0, 21, 36, 55, 8 }, // b
			{ 0, 0, 0, 21, 36, 55, 8 }, // c
			{ 0, 0, 0, 21, 36, 55, 8 }, // d
			{ 0, 0, 0, 21, 36, 55, 8 }, // e
			{ 0, 0, 0, 21, 36, 55, 8 }, // f
			{ 0, 0, 0, 21, 36, 55, 8 }, // g
			{ 0, 0, 0, 21, 36, 55, 8 }, // h
			{ 0, 0, 0, 21, 36, 55, 8 }, // i
			{ 0, 0, 0, 21, 36, 55, 8 }, // j
	};

	private String busClass;
	private double busprice;

	public int getBusCapacity(int destination, int busclass) {
		return busCapacity[destination][busclass];
	}

	public void setBusCapacity(int destination, int busclass, int numPass) {
		this.busCapacity[destination][busclass] -= numPass;
	}

	// gettters
	public String getBusClass() {
		return busClass;
	}

	public double getBusprice() {
		return busprice;
	}

	// setters
	public void setBusClass(String busClass) {
		this.busClass = busClass;
	}

	public void setBusprice(double busprice) {
		this.busprice = busprice;
	}
	
	//function for choosing bus Class
	String busClass() {
		String choice2;
		while (true) {
			System.out.print("\nEnter your bus class: [a - d] (refer to the table above): ");
			choice2 = in.nextLine().toLowerCase();
			if (choice2.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (!(choice2.equals("a") || choice2.equals("b") || choice2.equals("c") || choice2.equals("d"))) {
				System.out.println(">> Invalid input");
				continue;
			}
			break;
		}
		return choice2;
	}

}
