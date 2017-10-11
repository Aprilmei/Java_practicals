package assignment_2;

/**
 * Property class is the superclass of all types of properties
 */

public class Property implements RentallItem {

	private static int TotalRegisterNumber;

	// All attributes
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

	public void setRentalCostPerDay(int NewRentalCostPerDay) {
		this.RentalCostPerDay = NewRentalCostPerDay;

	}

	// Implement RentItem method
	@Override
	public void RentItem(int RentalDays) {
		TotalRentalDays += RentalDays;

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
