package Tutorial;

// objects from this class will represent
// six-sided dice.

public class Dice {

	private int faceValue;

	// mutator method for the dice class

	public void roll() {
		faceValue = 1 + (int) (Math.random() * 6.0);
	}

	// the accessor method for the dice

	public int value() {
		return faceValue;
	}

	// the constructor for dice objects. Starts them
	// with a roll.

	public Dice() {
		roll();
	}

} // end of the Dice class
