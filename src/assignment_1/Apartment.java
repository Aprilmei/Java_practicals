package assignment_1;

/**
 * Apartment is the subclass of Property
 */

public class Apartment extends Property {

	private int StoreyNumber;
	private int BedNumber;

	/**
	 * the whole set of constructor
	 */

	public Apartment(String OwnerName, String PostalAddress, int RentalCostPerDay, int TotalRentalDays,
			int StoreyNumber, int BedNumber) {
		super(OwnerName, PostalAddress, RentalCostPerDay, TotalRentalDays);
		// TODO Auto-generated constructor stub

		this.StoreyNumber = StoreyNumber;
		this.BedNumber = BedNumber;
	}

	/**
	 * Accessors to the attributes only for Apartment class
	 */
	public int getStoreyNumber() {
		return StoreyNumber;
	}

	public int getBedNumber() {
		return BedNumber;
	}

	@Override
	public String toString() {
		return getOwnerName() + " " + getPostalAddress() + " " + getTotalRentalDays() + " " + getRentalCostPerDay()
				+ " " + getStoreyNumber() + " " + getBedNumber();
	}

}
