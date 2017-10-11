
package assignment_1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * The Main class contains FillInProperties, PrintAllProperties,
 * CalculateTotalIncome methods
 */

public class Main {

	public static void main(String[] args) {

		// Create the array lists to store different properties
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		ArrayList<House> houses = new ArrayList<House>();
		ArrayList<Villa> villas = new ArrayList<Villa>();

		FillInProperties(apartments, houses, villas);
		System.out.println("The register number of the last property is " + villas.get(2).getRegisterNumber());

		// Call method PrintAllProperties
		PrintAllProperties(apartments, houses, villas);

		// Call the Print the total income
		System.out.println("The current total income from all properties including the additial fee and tax is :");
		int TotalIncome = CalculateTotalIncome(apartments, houses, villas);
		System.out.println(TotalIncome + " Euro");

	}

	public static void FillInProperties(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {

		// Add those data for apartments
		apartments.add(new Apartment("Daniel", "UCD Belfield, Dublin 4", 50, 4, 5, 2));
		apartments.add(new Apartment("Steven", "Galway 23", 80, 3, 5, 2));
		apartments.add(new Apartment("Jackie", "Stuggart 12", 100, 3, 5, 2));

		// Add those data for houses
		houses.add(new House("Lily", "Cork 82", 80, 2, 2, 30));
		houses.add(new House("Daniel", "Frankfort 12", 120, 3, 2, 30));
		houses.add(new House("John", "Galway South", 60, 4, 2, 30));

		// Add those data for villas
		villas.add(new Villa("Sam", "Paris 123", 500, 3, 4, 15, 10));
		villas.add(new Villa("Mike", "London 123", 400, 5, 6, 20, 20));
		villas.add(new Villa("Simon", "Milan 123", 300, 7, 3, 12, 10));

		// Add rent days to properties using RentProperty method using
		// JOptionPane
		int type;
		String message = "Please input the property type:\n 1: Apartment 2: House 3:Villa, 0: Quit";
		type = Integer.parseInt(JOptionPane.showInputDialog(null, message));

		while (type != 0) {

			int RentApartmentNumber = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Porperty type " + type + "\nNumber is : "));
			int RentDays = Integer.parseInt(JOptionPane.showInputDialog(null, "Rental Days"));
			if (type == 1) {
				apartments.get(RentApartmentNumber).RentProperty(RentDays);
			} else if (type == 2) {
				houses.get(RentApartmentNumber).RentProperty(RentDays);
			} else if (type == 3) {
				villas.get(RentApartmentNumber).RentProperty(RentDays);
			}
			type = Integer.parseInt(JOptionPane.showInputDialog(null, message));
		}

		// Add rent days to properties using RentProperty method
		apartments.get(0).RentProperty(7);
		apartments.get(0).RentProperty(3);
		apartments.get(0).RentProperty(4);
		apartments.get(1).RentProperty(8);
		apartments.get(1).RentProperty(9);
		apartments.get(1).RentProperty(10);
		apartments.get(2).RentProperty(3);
		apartments.get(2).RentProperty(5);
		apartments.get(2).RentProperty(7);

		houses.get(0).RentProperty(5);
		houses.get(0).RentProperty(8);
		houses.get(0).RentProperty(5);
		houses.get(1).RentProperty(3);
		houses.get(1).RentProperty(4);
		houses.get(1).RentProperty(5);
		houses.get(2).RentProperty(15);
		houses.get(2).RentProperty(2);
		houses.get(2).RentProperty(7);

		villas.get(0).RentProperty(7);
		villas.get(0).RentProperty(10);
		villas.get(0).RentProperty(14);
		villas.get(1).RentProperty(5);
		villas.get(1).RentProperty(8);
		villas.get(1).RentProperty(5);
		villas.get(2).RentProperty(10);
		villas.get(2).RentProperty(8);
		villas.get(2).RentProperty(7);

	}

	// Method PrintAllProperties to print all the property information

	private static void PrintAllProperties(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {
		// TODO Auto-generated method stub

		System.out.println("\nAll Property Information\n\nApartments=======================");
		for (int i = 0; i < apartments.size(); i++) {
			System.out.println(apartments.get(i));
		}

		System.out.println("\nHouses=======================");
		for (int i = 0; i < houses.size(); i++) {
			System.out.println(houses.get(i));
		}

		System.out.println("\nVillas=======================");
		for (int i = 0; i < villas.size(); i++) {
			System.out.println(villas.get(i));
		}

		System.out.println("All Property Information=======================\n");

	}

	// Method CalculateTotalIncome to calculate all the income by add all those
	// income together

	public static int CalculateTotalIncome(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {

		int TotalIncome = 0;
		for (int i = 0; i < apartments.size(); i++) {
			TotalIncome += apartments.get(i).getTotalRentalDays() * apartments.get(i).getRentalCostPerDay();
		}

		for (int i = 0; i < houses.size(); i++) {
			TotalIncome += houses.get(i).getTotalRentalDays() * houses.get(i).getRentalCostPerDay()
					+ houses.get(i).getClearningFee();
		}

		for (int i = 0; i < villas.size(); i++) {
			TotalIncome += (villas.get(i).getTotalRentalDays() + villas.get(i).getRoomServiceCostPerDay()
					+ villas.get(i).getLuxuryTaxPerDay()) * villas.get(i).getRentalCostPerDay();
		}

		return TotalIncome;

	}

}
