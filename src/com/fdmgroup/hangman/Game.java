package com.fdmgroup.hangman;

import java.util.ArrayList;

public class Game {
	
	// Set up variables
	
	private ArrayList<Character> usedLetters;
	private static boolean gameOver;
	private int numberOfGuesses;
	private StringBuilder wordState;
	private String wordToGuess;
	
	// Initialize Game
	
	public Game(String wordToGuess, int numberOfGuesses) {
		this.wordToGuess = wordToGuess;
		this.wordState = new StringBuilder("-".repeat(wordToGuess.length()));
		this.usedLetters = new ArrayList<Character>();
		this.numberOfGuesses = numberOfGuesses;
		this.gameOver = false;
	}
	
	/* Run multiple checks 
	   1) Check that word to be guessed contains user input and user input is not repeated
	   2) Check that word to be guessed contains user input and user input is repeated
	   3) check that word to be guessed does not contain user input and user input is not repeated
	   4) Check that word to be guessed does not contain user input and user input is repeated */
	
	public void makeGuess(char userGuess) {
		
		if (wordToGuess.contains(String.valueOf(userGuess)) && usedLetters.contains(userGuess) == false) {
			
			updateState(userGuess);
			usedLetters.add(userGuess);
			System.out.println("That guess is correct");
			
		} else if (wordToGuess.contains(String.valueOf(userGuess)) && usedLetters.contains(userGuess) == true) {
			
			System.out.println("You have already guessed: " + userGuess);
			
		} else if (wordToGuess.contains(String.valueOf(userGuess)) == false && usedLetters.contains(userGuess) == false){
			
			usedLetters.add(userGuess);
			numberOfGuesses --;
			System.out.println("There are no " + userGuess + "'s in the word");
			
		} else if (wordToGuess.contains(String.valueOf(userGuess)) == false && usedLetters.contains(userGuess) == true){ 
			
			System.out.println("You have already guessed: " + userGuess + " and the word does not contain it");
			
		} else {
			
			numberOfGuesses --;
			System.out.println("There are no " + userGuess + "'s in the word");
		}	
	}
	
	// Update word state so that hyphens become correct letter is player guessed correctly
	
	public void updateState(char letter) {
		
		for (int i = 0; i < wordToGuess.length(); i++) {
			
			if (wordToGuess.charAt(i) == letter) {
				wordState.setCharAt(i, letter);
			}
		}		
	}
	
	// Getter and setter methods
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}
	
	public String getWordState() {
		return wordState.toString();	
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
