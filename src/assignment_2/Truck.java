package assignment_2;

/**
 * Truck class is the subclass of Vehicle
 */

public class Truck extends Vehicle {

	private int CargoWeight;

	/**
	 * the whole set of constructor
	 */
	public Truck(String Owner, int RentalCostPerDay, int TotalRentalDays, int CargoWeight) {
		super(Owner, RentalCostPerDay, TotalRentalDays);
		// TODO Auto-generated constructor stub
		this.CargoWeight = CargoWeight;
	}

	/**
	 * Accessor to the attribute CargoWeight
	 */
	public int getCargoWeight() {
		return CargoWeight;
	}

	// implement toString method the get all information
	@Override
	public String toString() {

		return getOwner() + " " + getRentalCostPerDay() + " " + getTotalRentalDays() + " " + getRentalCostPerDay() + " "
				+ getCargoWeight();
	}

}
