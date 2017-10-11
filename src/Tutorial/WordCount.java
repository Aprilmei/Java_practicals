/**
 * Author: Alex Cronin & Fintan Costello
 * Description: This program repeatedly invites the user to enter a sentence. The program may respond in 2 ways
 * 1. if the user enters the sentence "goodbye" then the program terminates
 * 2. if the user enters a sentence which is not "goodbye" the user will be informed of the number of words in the sentence
 * entered.
 */

package Tutorial;

import java.util.Scanner; //import the Scanner class

public class WordCount {// class declaration

	public static void main(String[] args) {
		// declare a Scanner Object called "lineScanner" and initialize it to
		// accept input from the standard input stream
		Scanner lineScanner = new Scanner(System.in);
		// use "lineScanner" to get the next line of input from the user and
		// store it in the String variable "sentence"
		System.out.print("user:"); // prompt the user for input
		String sentence = lineScanner.nextLine();
		// while the user has not entered the sentence "goodbye"
		while (!sentence.equalsIgnoreCase("goodbye")) {
			// declare and initialize a new Scanner called "wordScanner" based
			// on the string variable "sentence"
			Scanner wordScanner = new Scanner(sentence);
			// loop to count the words
			int numberOfWords = 0;
			while (wordScanner.hasNext()) {// while wordScanner still has more
											// tokens
				wordScanner.next();// get the next token of wordScanner
				numberOfWords++;// increment the number of words
			}
			// output the number of words in the sentence to the user
			System.out.println("There are " + numberOfWords + " words in that sentence");
			System.out.print("user:"); // prompt the user for input
			// use "lineScanner" to get the next line of input from the user and
			// store it in the String variable "sentence"
			sentence = lineScanner.nextLine();
			// System.out.printf(sentence + "\n");
		}
		System.exit(0); // Terminate the current java virtual machine with code
						// 0
	}

}
