package assignment2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartA {
	
	public static void main(String[] args) {
		
		ArrayList<BnBProperty> apartments = new ArrayList<BnBProperty>();
		ArrayList<BnBProperty> houses = new ArrayList<BnBProperty>();
		ArrayList<BnBProperty> luxuryVillas = new ArrayList<BnBProperty>();
		
		readInputPropertyFile("src/assignment2/InputProperty.txt",apartments,houses,luxuryVillas);
		printAllProperties("src/assignment2/OutputProperty.txt",apartments, houses, luxuryVillas);
		giveRentalProperty(apartments,houses,luxuryVillas);
		printAllProperties("src/assignment2/OutputProperty.txt",apartments, houses, luxuryVillas);
		System.exit(0);
	}

	
	public static void readInputPropertyFile(String filePath, ArrayList<BnBProperty> apartments, ArrayList<BnBProperty> houses, ArrayList<BnBProperty> luxuryVillas) {
		
		//check if file exists in the path, if not catch the error
		try {
			
			FileReader readMyFile = new FileReader(filePath);
			Scanner scanMyFile = new Scanner(readMyFile);
			while (scanMyFile.hasNext()) {
				
				//use regex to split a string into a string array based on white spaces
				String[] splitString = scanMyFile.nextLine().split("\\s+");
				
				int registerNumber = Integer.parseInt(splitString[1]);
				System.out.println("registerNumber: " + registerNumber);
				String ownersName = splitString[2];
				String postalAddress = splitString[3];
				int rentalCostPerDay = Integer.parseInt(splitString[4]);
				int rentalDays = Integer.parseInt(splitString[5]);
				
				//if it is an apartment
				if (splitString[0].equals("1")) {
						
					int storeyNumber = Integer.parseInt(splitString[6]);
					int numberBeds = Integer.parseInt(splitString[7]);
					apartments.add(new BnBApartment(registerNumber, ownersName, postalAddress, rentalCostPerDay, rentalDays, storeyNumber, numberBeds));
					
				}
				
				// else if it is a house
				else if (splitString[0].equals("2")) {
					
					int totalNumberStoreys = Integer.parseInt(splitString[6]);
					int clearingFees = Integer.parseInt(splitString[7]);
					houses.add(new BnBHouse(registerNumber, ownersName, postalAddress, rentalCostPerDay, rentalDays, totalNumberStoreys, clearingFees));
					
				}
				
				// else if it is luxury villa
				else if (splitString[0].equals("3")) {
					
					int totalNumberRooms = Integer.parseInt(splitString[6]);
					int roomServiceCostPerDay = Integer.parseInt(splitString[7]);
					int luxuryTaxPerDay = Integer.parseInt(splitString[8]);
					luxuryVillas.add(new BnBLuxuryVilla(registerNumber, ownersName, postalAddress, rentalCostPerDay, rentalDays, totalNumberRooms, roomServiceCostPerDay, luxuryTaxPerDay));
					
				}
				
				//this is likely to be an error
				else { System.out.println("Could not recognise property type"); }
				
			}
			
			scanMyFile.close();
			
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	public static void printAllProperties(String outputFilePath, ArrayList<BnBProperty> apartments, ArrayList<BnBProperty> houses, ArrayList<BnBProperty> luxuryVillas) {
		
		try {
			
			PrintWriter myOutFile = new PrintWriter(outputFilePath);
			
			ArrayList<ArrayList<BnBProperty>> arrayOfProperties = new ArrayList<ArrayList<BnBProperty>>();
			arrayOfProperties.add(apartments);
			arrayOfProperties.add(houses);
			arrayOfProperties.add(luxuryVillas);
			
			for (ArrayList<BnBProperty> array : arrayOfProperties) {
				
				for (BnBProperty property : array) {
					
					myOutFile.println(property.toString());
				
				}
			
			}
			
			myOutFile.close();
			
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}

	}
	
	public static void giveRentalProperty(ArrayList<BnBProperty> apartments, ArrayList<BnBProperty> houses, ArrayList<BnBProperty> luxuryVillas) {
		
		JPanel panel = new JPanel();
		JTextField propertyIDJText = new JTextField(10);
		JTextField rentalDaysJText = new JTextField(10);
		
		panel.add(new JLabel("PropertyID :"));
		panel.add(propertyIDJText);
		panel.add(new JLabel("Rental days : "));
		panel.add(rentalDaysJText);
		
	    int result = JOptionPane.showConfirmDialog(null, panel,
	            "", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	
	    	//test to see if input is correct, it must be two integers
	    	try {
	    		
				String text1 = propertyIDJText.getText();
				int propertyID = Integer.parseInt(text1);
				
				String text2 = rentalDaysJText.getText();
				int rentalDays = Integer.parseInt(text2);
				
				
				ArrayList<ArrayList<BnBProperty>> arrayOfProperties = new ArrayList<ArrayList<BnBProperty>>();
				arrayOfProperties.add(apartments);
				arrayOfProperties.add(houses);
				arrayOfProperties.add(luxuryVillas);
				
				for (ArrayList<BnBProperty> array : arrayOfProperties) {
					
					for (BnBProperty property : array) {
						
						if(property.getRegisterNumber() == propertyID) {
							
							property.rentProperty(rentalDays);
						}
					
					}
				
				}
	    		
	    	}
	    	
	    	catch (NumberFormatException ex) {
	    		System.out.println(ex.getMessage());
	    	}
	    	
	    }
		
	}
	
}	
