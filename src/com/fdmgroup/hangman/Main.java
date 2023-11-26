package com.fdmgroup.hangman;

import java.util.ArrayList;

public class Main {
	
	// Execute the game
	
	public static void main(String[] args) {
		
		// Initialise variables
		
		UserInput input = new UserInput();
		WordList wordList = new WordList();
		String wordToGuess = wordList.getWord();
		Game newGame = new Game(wordToGuess, 8);
		
		System.out.println("Welcome to Hangman!");
		
		// Print out basic info for player
		
		while (newGame.getGameOver() == false) {
			System.out.println("The word now looks like this: " + newGame.getWordState());
			System.out.println("You have " + newGame.getNumberOfGuesses() + " guesses left");
		
			// Get user input
			
			char userGuess = input.userInput();
			System.out.println("Your guess: " + userGuess);
			
			// Game logic, by checking user input against word to be guessed
			
			newGame.makeGuess(userGuess);
			
			// Criteria to end game
			
			if (newGame.getWordState().equals(wordToGuess) || newGame.getNumberOfGuesses() == 0) {
				
				newGame.setGameOver(true);
				
				// Player wins the game / Player lose the game
				
				if (newGame.getWordState().equals(wordToGuess)) {
					
					System.out.println("You win! The word is " + newGame.getWordState());
					
				} else if (newGame.getNumberOfGuesses() == 0) {
					
					System.out.println("You're completely hung.");
					System.out.println("The word is " + wordToGuess);
					System.out.println("You lose");
					
					}	
			}
		}
	}
}
