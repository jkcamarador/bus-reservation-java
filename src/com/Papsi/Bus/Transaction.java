package com.Papsi.Bus;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Transaction {
	//objects
	private Scanner in = new Scanner(System.in);
	private Random random = new Random();
	private CreateBox box = new CreateBox();
	//variables
	private static int[] generatedNumbers = new int[610];
	private boolean israndthesame;
	public DecimalFormat format = new DecimalFormat("#,###.00");
	double StandardDestinationFee, additionalCharge = 0, totalCharge;
	private double insuranceFee[] = new double[610];
	private double pseudoTotal[] = new double[610];
	private double discountedAmount[] = new double[610];
	private boolean cancelPayment;
	
	//return a generated number which is used in the search
	public int getGeneratedNumbers(int x) {
		return generatedNumbers[x];
	}
	
	//generate a random number
	int getRandom() {
		israndthesame = false;
		int rand = random.nextInt(10000);
		for (int x = 0; x < 610; x++) {
			if (rand == generatedNumbers[x]) {
				israndthesame = true;
				break;
			} else {
				if (generatedNumbers[x] == 0) {
					generatedNumbers[x] = rand;
					break;
				} else {
					continue;
				}
			}
		}
		if (israndthesame == true) {
			getRandom();
		}
		return rand;
	}
	
	//process the data and compute for the total amount
	public double process(int x, String origin, double price, String tripType, String isAvailedInsurance,
			double tdiscount, String busClass) {

		double total;
		StandardDestinationFee =0;
		additionalCharge = 0;
		totalCharge =0;
		
		if (tripType == "One Way") {

			total = price;

			if (origin == "Manila") {
				total += 85;
				StandardDestinationFee = 85;
			} else {
				if (busClass == "Class A") {
					StandardDestinationFee = 30;
					total += 30;
				} else if (busClass == "Class B") {
					StandardDestinationFee = 20;
					total += 20;
				} else if (busClass == "Class C") {
					StandardDestinationFee = 15;
					total += 15;
				} else if (busClass == "Class D") {
					StandardDestinationFee = 10;
					total += 10;
				}
			}

			if (isAvailedInsurance == "Yes") {
				if (busClass == "Class A") {
					total += 195;
					insuranceFee[x] = 195;
				} else if (busClass == "Class B") {
					total += 140;
					insuranceFee[x] = 140;
				} else if (busClass == "Class C") {
					total += 95;
					insuranceFee[x] = 95;
				} else if (busClass == "Class D") {
					total += 50;
					insuranceFee[x] = 50;
				}
			} else {
				insuranceFee[x] = 0;
			}

		} else {

			total = price * 2;

			if (busClass == "Class A") {
				if (origin == "Manila") {
					StandardDestinationFee = 85;
					additionalCharge = 30;
				} else {
					StandardDestinationFee = 30;
					additionalCharge = 85;
				}
				total += 115;
			} else if (busClass == "Class B") {
				if (origin == "Manila") {
					StandardDestinationFee = 85;
					additionalCharge = 20;
				} else {
					StandardDestinationFee = 20;
					additionalCharge = 85;
				}
				total += 105;
			} else if (busClass == "Class C") {
				if (origin == "Manila") {
					StandardDestinationFee = 85;
					additionalCharge = 15;
				} else {
					StandardDestinationFee = 15;
					additionalCharge = 85;
				}
				total += 100;
			} else if (busClass == "Class D") {
				if (origin == "Manila") {
					StandardDestinationFee = 85;
					additionalCharge = 10;
				} else {
					StandardDestinationFee = 10;
					additionalCharge = 85;
				}
				total += 95;
			}

			if (isAvailedInsurance == "Yes") {
				if (busClass == "Class A") {
					insuranceFee[x] = 195;
					total += 195;
				} else if (busClass == "Class B") {
					insuranceFee[x] = 140;
					total += 140;
				} else if (busClass == "Class C") {
					insuranceFee[x] = 95;
					total += 95;
				} else if (busClass == "Class D") {
					insuranceFee[x] = 50;
					total += 50;
				}
			} else {
				insuranceFee[x] = 0;
			}
		}

		pseudoTotal[x] = total;
		discountedAmount[x] = total * tdiscount;
		total = total - discountedAmount[x];
		totalCharge = StandardDestinationFee + additionalCharge;
		return total;
	}
	
	//display receipt for after the booking
	void DisplayTransactions(int numPass, String[] tlastname, String[] tfirstname, String[] tmiddleinitial,
			String[] talias, int[] tage, String[] tcategory, double price, String tripType, double[] ttotal,
			double[] tdiscount) {
		box.getLength(numPass, tlastname, tfirstname, tmiddleinitial, talias, tage, tcategory, price,
				StandardDestinationFee, additionalCharge, totalCharge, insuranceFee, pseudoTotal, tdiscount,
				discountedAmount, ttotal);
		box.showField();
		for (int ct = 0; ct < numPass; ct++) {
			box.showData((ct + 1), tlastname[ct], tfirstname[ct], tmiddleinitial[ct], talias[ct], tage[ct],
					tcategory[ct], price, StandardDestinationFee, additionalCharge, totalCharge, insuranceFee[ct],
					pseudoTotal[ct], (tdiscount[ct] * 100) + "%", format.format(discountedAmount[ct]), ttotal[ct]);
		}
		box.tableLine();
	}
	
	//display receipt in the search class
	void DisplayTransactions(int index, String last, String first, String middle, String alias, String age,
			String category, String total) {
		System.out.println("Full Name (Last, First, M.I): " + last + ", " + first + " " + middle + ".");
		System.out.println("Alias: " + alias);
		System.out.println("Age: " + age);
		System.out.println("Category: " + category);
		System.out.println("Total Amount: " + total);
		System.out.println();
	}
	
	//prompts the user for proceeding the total amount
	void proceedToPayment(double tgrandtotal) {
		cancelPayment = false;
		String choice;
		while (true) {
			System.out.println("\nTotal amount: Php " + tgrandtotal);
			System.out.print("Proceed to Payment ? [Y] or [N]: ");
			choice = in.nextLine().toLowerCase();
			if (choice.length() < 1) {
				System.out.println(">> Input Necessary Details");
				continue;
			}
			if (choice.equals("y")) {
				break;
			} else if (choice.equals("n")) {
				cancelPayment = true;
				break;
			} else {
				System.out.println(">> Invalid Input");
				continue;
			}
		}
	}
	
	//cancel function to be checked
	public boolean isCancelPayment() {
		return cancelPayment;
	}
	
	//function for the payment
	double payment(double tgrandtotal) {
		String spayment;
		String choice;
		cancelPayment = false;
		while (true) {
			try {
				System.out.println("\nTotal amount: Php " + tgrandtotal);
				System.out.print("Enter payment: Php ");
				spayment = in.nextLine();

				if (spayment.length() < 1) {
					System.out.println(">> Input Necessary Details");
					continue;
				}
				if (Integer.parseInt(spayment) < tgrandtotal) {
					while (true) {
						System.out.println("\n>> Insufficient funds");
						System.out.print("Continue ? [Y] or [N]: ");
						choice = in.nextLine().toLowerCase();
						if (choice.length() < 1) {
							System.out.println(">> Input necessary Details");
							continue;
						}
						if (choice.equals("y")) {
							break;
						} else if (choice.equals("n")) {
							cancelPayment = true;
							break;
						} else {
							System.out.println(">> Invalid Input");
							continue;
						}
					}
					if (choice.equals("y")) {
						continue;
					}
				}
			} catch (Exception e) {
				System.out.println(">> Invalid Input");
				continue;
			}
			break;
		}
		return Double.parseDouble(spayment);
	}
}
