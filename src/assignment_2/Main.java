package assignment_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Main class contains FillInProperties, PrintAllProperties,
 * CalculateTotalIncome methods
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		// Create the array lists to store different properties
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		ArrayList<House> houses = new ArrayList<House>();
		ArrayList<Villa> villas = new ArrayList<Villa>();

		// Call the ReadInputPropertyFile method to add properties
		ReadInputPropertyFile("src/assignment_2/InputProperty.txt", apartments, houses, villas);

		// Call the FillInProperties method to add rental days to properties
		FillInProperties(apartments, houses, villas);

		// Call the GiveRentalProperty method to add properties
		GiveRentalProperty(apartments, houses, villas);

		// Call method PrintAllProperties
		PrintAllProperties("src/assignment_2/OutputProperty.txt", apartments, houses, villas);

		// Call the Print the total income
		System.out.println("The current total income from all properties including the additial fee and tax is :");
		int TotalIncome = CalculateTotalIncome(apartments, houses, villas);
		System.out.println(TotalIncome + " Euro");

		// Create the array lists to store different properties
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Truck> trucks = new ArrayList<Truck>();

		// Call ReadInputVehicleFile to add vehicle
		ReadInputVehicleFile("src/assignment_2/InputVehicle.txt", cars, trucks);

		// Call FillInVehicles to add rental days to vehicle
		FillInVehicles(cars, trucks);

		// Call PrintAllVehicles method
		PrintAllVehicles("src/assignment_2/OutputVehicle.txt", cars, trucks);

		System.out.println("The total income from all vehicles the additional costs and taxes is "
				+ CalculateVehicleTotalIncome(cars, trucks));

	}

	/**
	 * The method ReadInputPropertyFile read data from file and add them to the
	 * array list
	 */

	public static void ReadInputPropertyFile(String FileName, ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) throws FileNotFoundException {

		// Use FileReader to read file and use Scanner to read line by line
		FileReader readMyFile = new FileReader(FileName);
		Scanner inputFile = new Scanner(readMyFile);

		while (inputFile.hasNext()) {
			// Read the file line by line
			// Use Scanner to read the line
			String line = inputFile.nextLine();
			Scanner NewProperty = new Scanner(line);
			int type = NewProperty.nextInt();

			/*
			 * Check the type of property then add the property to different
			 * list type 1: apartment type 2: house type 3: villa
			 */

			if (type == 1) {

				int StoreyNumber = NewProperty.nextInt();
				int BedsNumber = NewProperty.nextInt();
				int RentalCostPerDay = NewProperty.nextInt();
				int TotalRentalDays = NewProperty.nextInt();
				String Owner = NewProperty.next();
				String Address = NewProperty.next();

				/*
				 * Add the new apartment data to array list and ordered them as
				 * in the constructor
				 */
				apartments.add(
						new Apartment(Owner, Address, RentalCostPerDay, TotalRentalDays, StoreyNumber, BedsNumber));
			} else if (type == 2) {

				int TotalStoreyNumber = NewProperty.nextInt();
				int ClearingFee = NewProperty.nextInt();
				int RentalCostPerDay = NewProperty.nextInt();
				int TotalRentalDays = NewProperty.nextInt();
				String Owner = NewProperty.next();
				String Address = NewProperty.next();
				/*
				 * Add the new apartment data to array list and ordered them as
				 * in the constructor
				 */
				houses.add(
						new House(Owner, Address, RentalCostPerDay, TotalRentalDays, TotalStoreyNumber, ClearingFee));

			} else if (type == 3) {

				int NumberOfRooms = NewProperty.nextInt();
				int RoomServiceCostPerDay = NewProperty.nextInt();
				int LuxuryTaxPerDay = NewProperty.nextInt();
				int RentalCostPerDay = NewProperty.nextInt();
				int TotalRentalDays = NewProperty.nextInt();
				String Owner = NewProperty.next();
				String Address = NewProperty.next();
				/*
				 * Add the new villa data to array list and ordered them as in
				 * the constructor
				 */
				villas.add(new Villa(Owner, Address, RentalCostPerDay, TotalRentalDays, NumberOfRooms,
						RoomServiceCostPerDay, LuxuryTaxPerDay));
			}

		}

	}

	/**
	 * The method ReadInputVehicleFile read data from file and add them to the
	 * vehicle array list
	 */

	public static void ReadInputVehicleFile(String FileName, ArrayList<Car> cars, ArrayList<Truck> trucks)
			throws FileNotFoundException {

		// Use FileReader to read file and use Scanner to read line by line
		FileReader readMyFile = new FileReader(FileName);
		Scanner inputFile = new Scanner(readMyFile);

		while (inputFile.hasNext()) {
			// Read the file line by line
			// Use Scanner to read the line

			String line = inputFile.nextLine();
			Scanner vin = new Scanner(line);
			int type = vin.nextInt();
			if (type == 1) {

				// In the file, all the vehicle data are ordered the same as the
				// constructor
				cars.add(new Car(vin.next(), vin.nextInt(), vin.nextInt(), vin.nextInt()));
			} else if (type == 2) {
				trucks.add(new Truck(vin.next(), vin.nextInt(), vin.nextInt(), vin.nextInt()));

			}

		}

	}

	/**
	 * GiveRentalProperty method displays a frame(using swing packet) and the
	 * user can insert a new rental transaction by giving the Property ID and
	 * the rental days.
	 */

	public static void GiveRentalProperty(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {

		// Add PropertyID, Rental Days Jlables and the input JTextField to a
		// JPanel
		JPanel panel = new JPanel();
		JTextField PropertyIdNumber = new JTextField(2);
		JTextField RentalDayNumber = new JTextField(2);

		panel.add(new JLabel("PropertyID"));
		panel.add(PropertyIdNumber);
		panel.add(new JLabel("Rental Days"));
		panel.add(RentalDayNumber);

		// http://www.java2s.com/Tutorial/Java/0240__Swing/OKcanceloptiondialog.htm
		// Use JOptionPane.showConfirmDialog OK_CANCEL_OPTION to show message
		int result = JOptionPane.showConfirmDialog(null, panel, "", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {

			// Get the PropertyID and RentalDays from the input window
			int PropertyID = Integer.parseInt(PropertyIdNumber.getText());
			// System.out.println("Property ID is " + PropertyID);
			int RentalDays = Integer.parseInt(RentalDayNumber.getText());
			// System.out.println("Rental Day is " + RentalDays);

			boolean Found = false;

			// Check all the properties until find the Property ID and add the
			// rental days to that property
			for (int i = 0; i < apartments.size(); i++) {
				if (Found = true) {
					break;
				} else if (apartments.get(i).getRegisterNumber() == PropertyID) {
					apartments.get(PropertyID).RentItem(RentalDays);
					Found = true;
					break;
				}

			}

			for (int i = 0; i < houses.size(); i++) {
				if (Found = true) {
					break;
				} else if (houses.get(i).getRegisterNumber() == PropertyID) {
					houses.get(PropertyID).RentItem(RentalDays);
					// System.out.print("The RegisterNumber is " +
					// houses.get(i).getRegisterNumber());
					Found = true;
					break;
				}
			}

			for (int i = 0; i < villas.size(); i++) {
				if (Found = true) {
					break;
				} else if (villas.get(i).getRegisterNumber() == PropertyID) {
					villas.get(PropertyID).RentItem(RentalDays);
					Found = true;
					break;
				}

			}

		}

	}

	public static void FillInProperties(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {

		apartments.get(0).RentItem(4);
		apartments.get(0).RentItem(3);
		apartments.get(0).RentItem(5);
		apartments.get(1).RentItem(5);
		apartments.get(1).RentItem(10);
		apartments.get(1).RentItem(2);
		apartments.get(2).RentItem(5);
		apartments.get(2).RentItem(3);
		apartments.get(2).RentItem(4);

		houses.get(0).RentItem(8);
		houses.get(0).RentItem(2);
		houses.get(0).RentItem(4);
		houses.get(1).RentItem(9);
		houses.get(1).RentItem(3);
		houses.get(1).RentItem(6);
		houses.get(2).RentItem(4);
		houses.get(2).RentItem(14);
		houses.get(2).RentItem(5);

		villas.get(0).RentItem(3);
		villas.get(0).RentItem(7);
		villas.get(0).RentItem(5);
		villas.get(1).RentItem(3);
		villas.get(1).RentItem(11);
		villas.get(1).RentItem(21);
		villas.get(2).RentItem(2);
		villas.get(2).RentItem(13);
		villas.get(2).RentItem(12);
	}

	public static void FillInVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks) {

		cars.get(0).RentItem(4);
		cars.get(0).RentItem(4);
		cars.get(1).RentItem(5);
		cars.get(1).RentItem(4);

		trucks.get(0).RentItem(9);
		trucks.get(0).RentItem(3);
		trucks.get(1).RentItem(7);
		trucks.get(1).RentItem(3);

	}
	// Method PrintAllProperties to print all the property information

	private static void PrintAllProperties(String FileName, ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter printOut = new PrintWriter(FileName);

		printOut.println("\nAll Property Information\n\nApartments=======================");
		for (int i = 0; i < apartments.size(); i++) {
			printOut.println(apartments.get(i));
		}

		printOut.println("\nHouses=======================");
		for (int i = 0; i < houses.size(); i++) {
			printOut.println(houses.get(i));
		}

		printOut.println("\nVillas=======================");
		for (int i = 0; i < villas.size(); i++) {
			printOut.println(villas.get(i));
		}

		printOut.println("\nAll Property Information=======================\n");

		printOut.close();

	}

	private static void PrintAllVehicles(String FileName, ArrayList<Car> cars, ArrayList<Truck> trucks)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter printOut = new PrintWriter(FileName);

		printOut.println("\nAll Vehicles Information\n\nCars=======================");
		for (int i = 0; i < cars.size(); i++) {
			printOut.println(cars.get(i));
		}

		printOut.println("\nTrucks=======================");
		for (int i = 0; i < trucks.size(); i++) {
			printOut.println(trucks.get(i));
			System.out.println(trucks.get(i));
		}

		printOut.println("\nAll Vehicles Information=======================\n");
		printOut.close();
	}

	// Method CalculateTotalIncome to calculate all the income by add all those
	// income together

	public static int CalculateTotalIncome(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {

		int TotalIncome = 0;
		for (int i = 0; i < apartments.size(); i++)
			TotalIncome += apartments.get(i).getTotalRentalDays() * apartments.get(i).getRentalCostPerDay();

		for (int i = 0; i < houses.size(); i++)
			TotalIncome += houses.get(i).getTotalRentalDays() * houses.get(i).getRentalCostPerDay()
					+ houses.get(i).getClearningFee();

		for (int i = 0; i < villas.size(); i++)
			TotalIncome += (villas.get(i).getTotalRentalDays() + villas.get(i).getRoomServiceCostPerDay()
					+ villas.get(i).getLuxuryTaxPerDay()) * villas.get(i).getRentalCostPerDay();

		return TotalIncome;

	}

	// Method CalculateVehicleTotalIncome to calculate all the income of
	// vehicles by add all those income together
	public static int CalculateVehicleTotalIncome(ArrayList<Car> cars, ArrayList<Truck> trucks) {

		int TotalIncome = 0;
		for (int i = 0; i < cars.size(); i++) {
			TotalIncome += cars.get(i).getRentalCostPerDay() * cars.get(i).getTotalRentalDays();
		}

		for (int i = 0; i < trucks.size(); i++) {
			TotalIncome += (trucks.get(i).getRentalCostPerDay() + trucks.get(i).getCargoWeight())
					* trucks.get(i).getTotalRentalDays();
		}

		return TotalIncome;

	}

}