/**
* Author: Alex Cronin & Fintan Costello
* Description: This file consists of 2 classes the description of each features just before the class.
**/
package Tutorial;

import javax.swing.JOptionPane;

/**
* Represent six-sided dice which can hold a face value between 1 and 6. The dice can be rolled, and the face value
* accessed.
*/
// end of the Dice class

//*********************************************************************************************************************

/**
 * This class represents individual increasing total dice games. Initially all
 * dice are thrown. The user then opts to throw individual dice in an attempt to
 * maximize his total score. The game is over when the new score is less than or
 * equal to the previous score.
 */
public class DiceGameIncreasingTotal {

	private int currentTotal; // declare int variable to store the current
								// totals of the dice
	private int previousTotal; // declare int variable to store the previous
								// totals of the dice
	private Dice[] diceArray = new Dice[5]; // declare an array of dice called
											// "diceArray"
	private int rolls; // contains the number of successful rolls which have
						// taken place so far

	/**
	 * Constructor which creates an increasing total dice game. The initial roll
	 * of all dice is performed.
	 */
	public DiceGameIncreasingTotal() {
		// for loop which generates new Dice objects and assigns it to each
		// location in the array
		for (int x = 0; x < diceArray.length; x++) {
			diceArray[x] = new Dice();
		}
		previousTotal = 0; // the previous total is initialized to 0 as there
							// has been no previous rolling
		currentTotal = totalDiceValue(); // the current total is stored in the
											// private member data
	}

	/**
	 * Mutator method which throws the ith dice, updates the total score and
	 * checks to see if the roll was successful
	 * 
	 * @param i
	 *            the dice to be thrown
	 * @return true if the score of the most recent throw has increased the
	 *         total score
	 */
	public boolean throwDice(int i) {
		previousTotal = totalDiceValue(); // store the old total in
											// previousTotal
		diceArray[i].roll(); // roll dice i
		currentTotal = totalDiceValue(); // calculate the new total and store it
											// in currentTotal
		boolean rollStatus = currentTotal >= previousTotal; // determine if the
															// roll was
															// successful
		if (rollStatus)
			rolls++; // if the roll was successful then update the number of
						// successful rolls counter
		return rollStatus; // return if the roll was successful or not
	}

	/**
	 * Accessor method which returns the number of times the user has selected
	 * to roll an individual dice and the resultant total has been greater than
	 * the previous total
	 * 
	 * @return number of successful rolls which have taken place
	 */
	public int numberOfSuccessfulRolls() {
		return rolls;
	}

	/**
	 * Accessor method which returns the summed total of all dice
	 * 
	 * @return summed total of all dice
	 */
	public int totalDiceValue() {
		int result = 0;
		for (int x = 0; x < diceArray.length; x++) { // iterates through each
														// element of the
														// diceArray
			result = result + diceArray[x].value();
		}
		return result;
	}

	/**
	 * Accessor method which returns all the values of the dice as a string
	 * 
	 * @return a String containing all the values of the dice
	 */
	public String diceList() {
		String result = "";
		for (int x = 0; x < diceArray.length; x++) {
			result = result + diceArray[x].value() + "\n";// concatenates the
															// value of score of
															// each dice on to
															// the String
		}
		return result;
	}

	/**
	 * Creates a new dice game. The dice are rolled and the initial values are
	 * displayed to the user. The user is invited to roll individual dice in an
	 * attempt to increase his total score. The game is finished when the users
	 * total fails to increase.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

		// Create an instance/object of the DiceGameIncreasingTotal class and
		// calls it aGame
		DiceGameIncreasingTotal aGame = new DiceGameIncreasingTotal();

		String selectedAsString; // store the index entered by the user of the
									// dice to be rolled
		int selected; // the int value of index entered by the user of the dice
						// to be rolled
		String message; // message to be out put to the user
		do {
			// this message contains a list of the values of the dice, the total
			// so far and addition to an invite for the user to throw a dice
			message = "Your five dice contain the numbers:\n" + aGame.diceList() + "These dice have a total score of "
					+ aGame.currentTotal + ".\n" + "Can you roll one of these dice to increase that total?\n"
					+ "Type 1 to roll the first dice, 2 to roll the second dice, 3 to roll the third dice, and so on.";
			// the dice to be thrown is read in from the user as a String
			selectedAsString = JOptionPane.showInputDialog(null, message);
			// the String value is parsed to an int
			selected = Integer.parseInt(selectedAsString);
			// loops while the most recent roll was successful( i.e. the total
			// is increasing).
		} while (aGame.throwDice(selected));
		message = "Your five dice contain the numbers:\n" + aGame.diceList() + "These dice have a total score of "
				+ aGame.currentTotal + ".\n" + "You've failed to increase your total score " + " In total you made "
				+ aGame.numberOfSuccessfulRolls() + " successful rolls."; // the
																			// number
																			// of
																			// successful
																			// rolls
																			// forms
																			// part
																			// of
																			// this
																			// message
		JOptionPane.showMessageDialog(null, message);
	}

}
