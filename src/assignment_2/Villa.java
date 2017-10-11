package assignment_2;

/**
 * Villa is the subclass of Property
 */

public class Villa extends Property {

	/**
	 * the whole set of constructor
	 */

	private int RoomServiceCostPerDay;
	private int LuxuryTaxPerDay;
	private int NumberOfRooms;

	public Villa(String OwnerName, String PostalAddress, int RentalCostPerDay, int TotalRentalDays, int NumberOfRooms,
			int RoomServiceCostPerDay, int LuxuryTaxPerDay) {
		super(OwnerName, PostalAddress, RentalCostPerDay, TotalRentalDays);
		// TODO Auto-generated constructor stub
		this.RoomServiceCostPerDay = RoomServiceCostPerDay;
		this.LuxuryTaxPerDay = LuxuryTaxPerDay;
		this.NumberOfRooms = NumberOfRooms;

	}

	/**
	 * mutator to change the room service cost per day
	 * 
	 * @param RoomServiceCostPerDay
	 */

	public void SetRoomServiceCostPerDay(int RoomServiceCostPerDay) {
		this.RoomServiceCostPerDay = RoomServiceCostPerDay;
	}

	/**
	 * Accessors to the attributes only for Villa class
	 */

	public int getRoomServiceCostPerDay() {
		return RoomServiceCostPerDay;
	}

	public int getLuxuryTaxPerDay() {
		return LuxuryTaxPerDay;
	}

	public int getNumberOfRooms() {
		return NumberOfRooms;
	}

	@Override
	public String toString() {

		return getOwnerName() + " " + getPostalAddress() + " " + getTotalRentalDays() + " " + getRentalCostPerDay()
				+ " " + getRoomServiceCostPerDay() + " " + getLuxuryTaxPerDay() + getNumberOfRooms();
	}

}
