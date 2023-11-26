package com.fdmgroup.hangman;

import java.util.Scanner;

// UserInput class

public class UserInput {
	
	public char userInput() {
		
		// Get user input
		
		Scanner guesser = new Scanner(System.in);
		
		// Convert user input to upper case
		
		String letter = guesser.nextLine().toUpperCase();
		
		// Check that user input is a character
		
		if (letter.length() != 1 || Character.isLetter(letter.charAt(0)) == false) {
			
			System.out.println("Invalid option, Please enter a letter");
			return userInput();
		} 
		
		return letter.charAt(0);
	}
	
}
