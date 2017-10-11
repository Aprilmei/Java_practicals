/**
 * Author: Alex Cronin & Fintan Costello
 * Description: This program repeatedly invites the user to talk about themselves. The program may respond in 4 ways
 * 1. if the user enters the sentence "goodbye" then the program terminates
 * 2. if the user enters a sentence with the word "I" in it then the computer responds with the prompt "Why do you
 * feel that way?"
 * 3. if the user enters a sentence which does not contain the word "I" and contains a word X with more than 7 letter
 * the user will be prompted with "How do you feel about X?"
 * 4  if the user enters a sentence which does not contain the word "I" and does not contain a word of more than 7 letters
 * the user will be prompted with "Tell me more.".
 */
package Tutorial;

import java.util.Scanner; //import the Scanner class

public class Conversation { // class declaration

	public static void main(String[] args) { // main method
		// declare a Scanner Object called "lineScanner" and initialize it to
		// accept input from the standard input stream
		Scanner lineScanner = new Scanner(System.in);
		// specify the delimiters to be used to tokenize the input of
		// "lineScanner"
		lineScanner.useDelimiter("[ ,.!]");
		System.out.print("computer: Tell me about yourself \nuser:");
		// request input from the user
		// use "lineScanner" to get the next line of input from the user and
		// store it in the String variable "sentence"
		String sentence = lineScanner.nextLine();
		while (!sentence.equalsIgnoreCase("goodbye")) { // while the user has
														// not entered the
														// sentence "goodbye"
			Scanner wordScanner = new Scanner(sentence).useDelimiter("[ ,.!]");
			// declare,
			// initialize
			// and
			// set
			// the
			// delimiters
			// of
			// a
			// Scanner
			// all
			// in
			// one
			// line
			// of
			// code
			String maxWord = ""; // declare a String variable "maxWord" and set
									// it to the null String
			boolean containsI = false; // declare a boolean variable called
										// "containsI" and set it to false.
										// Before a sentence is examined it is
										// assumed not to contain an 'I'.
			while (wordScanner.hasNext()) { // while the Scanner "wordScanner"
											// still has another token
				String currentWord = wordScanner.next();// get the next token
														// from "wordScanner"
														// and store it in the
														// String variable
														// "currentWord"
				if (currentWord.equals("I")) { // if next "currentWord" is 'I'
					containsI = true; // set the variable "containsI" to true
				}
				if (currentWord.length() > maxWord.length()) { // if the length
																// of
																// "currentWord"
																// is greater
																// then the
																// length of the
																// previously
																// found
																// "maxWord"
					maxWord = currentWord; // assign currentWord to maxWord
				}
			}
			// output
			if (containsI) {// if the sentence contained an "I"
				System.out.println("computer: Why do you feel that way?");// output
																			// this
																			// to
																			// the
																			// user
			} else {
				if (maxWord.length() > 7) {// if the length of the longest word
											// in the sentence is greater than 7
					System.out.println("computer: How do you feel about " + maxWord + "?"); // output
																							// this
																							// to
																							// the
																							// user
				} else {// otherwise
					System.out.println("computer: Tell me more."); // output
																	// this to
																	// the user.
				}
			}
			System.out.print("user: ");// invite the user to input a sentence
			sentence = lineScanner.nextLine(); // use the "lineScanner" to get
												// the next line of input from
												// the user and store it in the
												// String variable "sentence"
		}
		System.exit(0); // terminate the currently running Java Virtual Machine
	}
}
