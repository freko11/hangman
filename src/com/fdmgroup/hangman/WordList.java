package com.fdmgroup.hangman;

// List of words to guess

public class WordList {
	
	// Initialise a list of words to be guessed
	
	private String[] words = {"anime", "football", "chicken", "choice", "monkey", 
			"police", "desktop", "panda", "playful", "confused"};
	
	// Get a random word from our words list
	
	public String getWord() {
		
		// Convert chosen word to uppercase
		String wordToGuess = words[(int) (Math.random() * words.length)].toUpperCase();
		return wordToGuess.toString();
	}
}