package assignment_2;

/**
 * Car class is the subclass of Vehicle
 */

public class Car extends Vehicle {

	private int PassengersNumber;

	/**
	 * the whole set of constructor
	 */

	public Car(String Owner, int RentalCostPerDay, int TotalRentalDays, int PassengersNumber) {
		super(Owner, RentalCostPerDay, TotalRentalDays);
		// TODO Auto-generated constructor stub
		this.PassengersNumber = PassengersNumber;
	}

	/**
	 * Accessor to the attribute PassengersNumber
	 */
	public int getPassengersNumber() {
		return PassengersNumber;
	}

	// implement toString method the get all information
	@Override
	public String toString() {

		return getOwner() + " " + getRentalCostPerDay() + " " + getTotalRentalDays() + " " + getRentalCostPerDay() + " "
				+ getPassengersNumber();
	}

}
