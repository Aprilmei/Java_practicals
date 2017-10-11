
/**
 * Author: Alex Cronin & Fintan Costello
 * Description: This file consists of 2 classes the description of each features just before the class.
 **/
package Tutorial;

import javax.swing.JOptionPane;

/**
 * Represent six-sided dice which can hold a face value between 1 and 6. The
 * dice can be rolled, and the face value accessed.
 */
// end of the Dice class

// *********************************************************************************************************************

/**
 * This class represents a dice game. Initially all dice are thrown when the
 * constructor is called. The user can opt to throw all the dice again or quit.
 */
public class DiceGame {

	private Dice[] diceArray = new Dice[5]; // declare an array of dice called
											// "diceArray"

	/**
	 * Constructor which creates a dice game. The initial roll of all dice is
	 * performed.
	 */
	public DiceGame() {
		// for loop which generates new Dice objects and assigns it to each
		// location in the array
		for (int x = 0; x < diceArray.length; x++) {
			diceArray[x] = new Dice();
		}
	}

	/**
	 * Mutator method which throws the ith dice, updates the total score and
	 * checks to see if the roll was successful
	 * 
	 * @return true if the score of the most recent throw has increased the
	 *         total score
	 */
	public void rollAllDice() {
		for (int i = 0; i < this.diceArray.length; i++) {
			this.diceArray[i].roll();
		}
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
	 * displayed to the user. The user is invited to roll individual dice again
	 * or quit.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

		DiceGame aGame = new DiceGame(); // Create an instance/object of the
											// DiceGame class and calls it aGame
		String option; // store the option entered by the user "roll", "quit" or
						// another
		String message; // message to be out put to the user
		do {
			// this message contains a list of the values of the dice, the total
			// so far
			message = "Your five dice contain the numbers:\n" + aGame.diceList()
					+ "Do you want to roll them again or quit?";
			// the users desired action is read in
			option = JOptionPane.showInputDialog(null, message);
			if (option.compareTo("roll") == 0) // if the user type in "roll"
				aGame.rollAllDice();// all dice are rolled
			// loops while the user did not enter "quit"
		} while (option.compareTo("quit") != 0);
	}
}
