package assignment_2;

/**
 * Vehicle class is the superclass of all types of vehicles
 */

public class Vehicle implements RentallItem {

	private static int TotalRegisterNumber;

	// All attributes
	private int RegisterNumber;

	private String Owner;
	private int RentalCostPerDay;
	private int TotalRentalDays;

	/**
	 * the whole set of constructor
	 */

	public Vehicle(String Owner, int RentalCostPerDay, int TotalRentalDays) {

		this.RegisterNumber = TotalRegisterNumber++;
		this.Owner = Owner;
		this.RentalCostPerDay = RentalCostPerDay;
		this.TotalRentalDays = TotalRentalDays;

	}

	/**
	 * mutator to change the total rental days and the rental cost per day
	 */

	public void setRentalCostPerDay(int rentalcostPerDay) {
		RentalCostPerDay = rentalcostPerDay;
	}

	// Implement RentItem method
	@Override
	public void RentItem(int RentalDays) {
		TotalRentalDays += RentalDays;
	}

	/**
	 * Accessors to all the attributes
	 */

	public int getTotalRentalDays() {
		return TotalRentalDays;
	}

	public int getRentalCostPerDay() {
		return RentalCostPerDay;
	}

	public String getOwner() {
		return Owner;
	}

	public int getRegisterNumber() {
		return RegisterNumber;
	}

}
