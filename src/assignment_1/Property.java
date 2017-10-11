package assignment_1;

/**
 * Property class is the superclass of all types of properties
 */

public class Property {

	private static int TotalRegisterNumber;
	private int RegisterNumber;
	private String OwnerName;
	private String PostalAddress;
	private int RentalCostPerDay;
	private int TotalRentalDays;

	/**
	 * the whole set of constructor
	 */

	public Property(String OwnerName, String PostalAddress, int RentalCostPerDay, int TotalRentalDays) {
		this.RegisterNumber = TotalRegisterNumber++;
		this.OwnerName = OwnerName;
		this.PostalAddress = PostalAddress;
		this.RentalCostPerDay = RentalCostPerDay;
		this.TotalRentalDays = TotalRentalDays;
	}

	/**
	 * mutator to change the total rental days and the rental cost per day
	 */
	public void RentProperty(int RentalDays) {
		TotalRentalDays += RentalDays;

	}

	public void setRentalCostPerDay(int NewRentalCostPerDay) {
		this.RentalCostPerDay = NewRentalCostPerDay;

	}

	/**
	 * accessor to all the attributes
	 */

	public int getRegisterNumber() {
		return RegisterNumber;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public String getPostalAddress() {
		return PostalAddress;

	}

	public int getRentalCostPerDay() {
		return RentalCostPerDay;
	}

	public int getTotalRentalDays() {
		return TotalRentalDays;
	}

}
