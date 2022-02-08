package com.Papsi.Bus;

public class CreateBox {
	
	String field[] = { "Passenger", "Last Name", "First Name", "M.I", "Alias", "Age", "Category", "Base Bus Fee (Php)",
			"Standard Destination Processing Fee (Php)", "Additional Destination Charge Fee (Php)",
			"Total Charge (Php)", "Insurance Fee (Php)", "Total Amount (Php) ", "Discount Rate (Php)",
			"Discounted Amount (Php)", "Total Amount (Php)" };
	int lengthPerFields[] = new int[16];

	public void getLength(int numPass, String[] tlastname, String[] tfirstname, String[] tmiddleinitial,
			String[] talias, int[] tage, String[] tcategory, double price, double standardDestinationFee,
			double additionalCharge, double totalCharge, double[] insuranceFee, double[] pseudoTotal,
			double[] tdiscount, double[] discountedAmount, double[] ttotal) {
		int fLength[] = new int[16];
		int dataLength = 0;

		// GET FIELD NAMES LENGTH
		for (int ctr = 0; ctr < field.length; ctr++) {
			fLength[ctr] = field[ctr].length();
		}

		// GET DATA LENGTH
		for (int ctr = 0; ctr < field.length; ctr++) {

			for (int x = 0; x < numPass; x++) {
				if (ctr == 0) {
					if (String.valueOf(x).length() > dataLength) {
						dataLength = String.valueOf(x).length();
					}
				} else if (ctr == 1) {
					if (tlastname[x].length() > dataLength) {
						dataLength = tlastname[x].length();
					}
				} else if (ctr == 2) {
					if (tfirstname[x].length() > dataLength) {
						dataLength = tfirstname[x].length();
					}
				} else if (ctr == 3) {
					if (tmiddleinitial[x].length() > dataLength) {
						dataLength = tmiddleinitial[x].length();
					}
				} else if (ctr == 4) {
					if (talias[x].length() > dataLength) {
						dataLength = talias[x].length();
					}
				} else if (ctr == 5) {
					if (String.valueOf(tage[x]).length() > dataLength) {
						dataLength = String.valueOf(tage[x]).length();
					}
				} else if (ctr == 6) {
					if (tcategory[x].length() > dataLength) {
						dataLength = tcategory[x].length();
					}
				} else if (ctr == 7) {
					if (String.valueOf(price).length() > dataLength) {
						dataLength = String.valueOf(price).length();
					}
				} else if (ctr == 8) {
					if (String.valueOf(standardDestinationFee).length() > dataLength) {
						dataLength = String.valueOf(standardDestinationFee).length();
					}
				} else if (ctr == 9) {
					if (String.valueOf(additionalCharge).length() > dataLength) {
						dataLength = String.valueOf(additionalCharge).length();
					}
				} else if (ctr == 10) {
					if (String.valueOf(totalCharge).length() > dataLength) {
						dataLength = String.valueOf(totalCharge).length();
					}
				} else if (ctr == 11) {
					if (String.valueOf(insuranceFee[x]).length() > dataLength) {
						dataLength = String.valueOf(insuranceFee[x]).length();
					}
				} else if (ctr == 12) {
					if (String.valueOf(pseudoTotal[x]).length() > dataLength) {
						dataLength = String.valueOf(pseudoTotal[x]).length();
					}
				} else if (ctr == 13) {
					if (String.valueOf((tdiscount[x] * 100) + "%").length() > dataLength) {
						dataLength = String.valueOf((tdiscount[x] * 100) + "%").length();
					}
				} else if (ctr == 14) {
					if (String.valueOf(discountedAmount[x]).length() > dataLength) {
						dataLength = String.valueOf(discountedAmount[x]).length();
					}
				} else if (ctr == 15) {
					if (String.valueOf(ttotal[x]).length() > dataLength) {
						dataLength = String.valueOf(ttotal[x]).length();
					}
				}
			}

			if (dataLength > fLength[ctr]) {
				lengthPerFields[ctr] = dataLength + 2;
			} else {
				lengthPerFields[ctr] = fLength[ctr] + 2;
			}
			dataLength = 0;
		}
	}
	
	//display table
	public void showData(int data0, String data1, String data2, String data3, String data4, int data5, String data6,
			double data7, double data8, double data9, double data10, double data11, double data12, String data13,
			String data14, double data15) {
		System.out.format("%-" + (lengthPerFields[0]) + "s|", "|" + data0);
		System.out.format("%-" + (lengthPerFields[1] - 1) + "s|", data1);
		System.out.format("%-" + (lengthPerFields[2] - 1) + "s|", data2);
		System.out.format("%-" + (lengthPerFields[3] - 1) + "s|", data3);
		System.out.format("%-" + (lengthPerFields[4] - 1) + "s|", data4);
		System.out.format("%-" + (lengthPerFields[5] - 1) + "s|", data5);
		System.out.format("%-" + (lengthPerFields[6] - 1) + "s|", data6);
		System.out.format("%-" + (lengthPerFields[7] - 1) + "s|", data7);
		System.out.format("%-" + (lengthPerFields[8] - 1) + "s|", data8);
		System.out.format("%-" + (lengthPerFields[9] - 1) + "s|", data9);
		System.out.format("%-" + (lengthPerFields[10] - 1) + "s|", data10);
		System.out.format("%-" + (lengthPerFields[11] - 1) + "s|", data11);
		System.out.format("%-" + (lengthPerFields[12] - 1) + "s|", data12);
		System.out.format("%-" + (lengthPerFields[13] - 1) + "s|", data13);
		System.out.format("%-" + (lengthPerFields[14] - 1) + "s|", data14);
		System.out.format("%-" + (lengthPerFields[15] - 1) + "s|\n", data15);
	}

	public void showField() {
		tableLine();
		System.out.format("%-" + (lengthPerFields[0]) + "s|", "|" + field[0]);
		System.out.format("%-" + (lengthPerFields[1] - 1) + "s|", field[1]);
		System.out.format("%-" + (lengthPerFields[2] - 1) + "s|", field[2]);
		System.out.format("%-" + (lengthPerFields[3] - 1) + "s|", field[3]);
		System.out.format("%-" + (lengthPerFields[4] - 1) + "s|", field[4]);
		System.out.format("%-" + (lengthPerFields[5] - 1) + "s|", field[5]);
		System.out.format("%-" + (lengthPerFields[6] - 1) + "s|", field[6]);
		System.out.format("%-" + (lengthPerFields[7] - 1) + "s|", field[7]);
		System.out.format("%-" + (lengthPerFields[8] - 1) + "s|", field[8]);
		System.out.format("%-" + (lengthPerFields[9] - 1) + "s|", field[9]);
		System.out.format("%-" + (lengthPerFields[10] - 1) + "s|", field[10]);
		System.out.format("%-" + (lengthPerFields[11] - 1) + "s|", field[11]);
		System.out.format("%-" + (lengthPerFields[12] - 1) + "s|", field[12]);
		System.out.format("%-" + (lengthPerFields[13] - 1) + "s|", field[13]);
		System.out.format("%-" + (lengthPerFields[14] - 1) + "s|", field[14]);
		System.out.format("%-" + (lengthPerFields[15] - 1) + "s|\n", field[15]);
		tableLine();
	}

	public void tableLine() {
		boolean firstPlus = false;
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < lengthPerFields[x]; y++) {
				if (y == (lengthPerFields[x] - 1)) {
					System.out.print("+");
				} else if (y == 0) {
					if (!firstPlus) {
						firstPlus = true;
						System.out.print("+");
					}
					System.out.print("-");
				} else {
					System.out.print("-");
				}
			}
		}
		System.out.println();
	}
}
