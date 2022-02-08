package com.Papsi.Bus;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//objects
		Scanner in = new Scanner(System.in);
		Reserve reserve = new Reserve();
		Search search = new Search();
		//menu choice
		String choice;
		
		//menu
		while (true) {
			System.out.println("\nPapsi Bus Reservation System\n");
			System.out.println("[R] Reserve");
			System.out.println("[S] Show table");
			System.out.println("[H] Show Charges/Services");
			System.out.println("[T] Show Transaction Details");
			System.out.println("[E] Exit");
			System.out.print("Enter here: ");
			choice = in.nextLine().toLowerCase();
			if (choice.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (choice.equals("r")) {
				reserve.Start();
			} else if (choice.equals("s")) {
				reserve.destinationTable();
			} else if (choice.equals("h")) {
				reserve.chargesAndServices();
			} else if (choice.equals("t")) {
				search.Start();
			} else if (choice.equals("e")) {
				System.out.println(">> Thank you for using Papsi Reservation System =D ");
				in.close();
				System.exit(0);
			} else {
				System.out.println(">> Invalid Input");
			}
		}
	}
}
