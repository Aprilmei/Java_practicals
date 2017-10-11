package assignment_2;

/**
 * House is the subclass of Property
 */

public class House extends Property {

	private int TotalStoreyNumber;
	private int ClearingFee;

	/**
	 * the whole set of constructor
	 */

	public House(String OwnerName, String PostalAddress, int RentalCostPerDay, int TotalRentalDays,
			int TotalStoreyNumber, int ClearingFee) {
		super(OwnerName, PostalAddress, RentalCostPerDay, TotalRentalDays);
		// TODO Auto-generated constructor stub
		this.TotalStoreyNumber = TotalStoreyNumber;
		this.ClearingFee = ClearingFee;

	}

	/**
	 * mutator to change the clearing fee of the house
	 * 
	 * @param ClearingFee
	 */

	public void SetClearingFee(int ClearingFee) {
		this.ClearingFee = ClearingFee;
	}

	/**
	 * Accessors to the attributes only for Apartment class
	 */

	public int getTotalStoreyNumber() {
		return TotalStoreyNumber;
	}

	public int getClearningFee() {
		return ClearingFee;
	}

	@Override
	public String toString() {
		return getOwnerName() + " " + getPostalAddress() + " " + getTotalRentalDays() + " " + getRentalCostPerDay()
				+ " " + getTotalStoreyNumber() + " " + getClearningFee();

	}

}
