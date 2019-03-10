															//NAME: PRIYANKA ROY CHOUDHURY
															//STUDENT NUMBER: 180336834
															//COURSE NUMBER: CO1109
															//ASSIGNMENT NUMBER: cw1
import java.util.Scanner;								
import java.util.Random;

public class NumberGuessingGame {
	private static int numberOfTries;
	private static Random randomNumber = new Random();
	private static int correctGuessNumber;
	private static int guessNumber;
	private static int readAndReturn;
	private static boolean guessingNumberIsPresent = false;
	
	public static void main(String[] args) {
		play();
	}
	
	public static void generatedRandomNumber() {
		correctGuessNumber = randomNumber.nextInt(5000);
	}
	
	public static void askUserToGuessRandomNumber() {
		System.out.print("Try to guess the number I'm thinking of:");
	}

	public static int readAndReturnUserGuessAtRandomNumber() {
		Scanner inputNumber = new Scanner(System.in);
		guessNumber = Integer.parseInt(inputNumber.nextLine());
		return guessNumber;
	}

	public static void showFeedbackMessageToUser(String feedback) {
		numberOfTries++;
		if (guessNumberIsLow(guessNumber)) {
			System.out.println(feedback);
		} 
		else if (guessNumberIsHigh(guessNumber)) {
			System.out.println(feedback);
		} 
		else if(guessNumberIsCorrect(guessNumber)) { 
			System.out.println(feedback);
			continuePlayingOrQuitTheGame();
		}	
	}

	public static boolean guessNumberIsLow(int guessNumber) { 
		return guessNumber < correctGuessNumber;
	}

	public static boolean guessNumberIsHigh(int guessNumber) {
		return guessNumber > correctGuessNumber;
	}
	
	public static boolean guessNumberIsCorrect(int guessNumber) {
		return guessNumber==correctGuessNumber;
	}

	public static String getAndReturnFeedbackMessageForUser() {
		String feedback = null;
		if(guessNumberIsLow(guessNumber)) { 
			showFeedbackMessageToUser("too low - guess again:");
		}
		else if(guessNumberIsHigh(guessNumber)) {
			showFeedbackMessageToUser("too high - guess again:");
		}
		else if(guessNumberIsCorrect(guessNumber)) {
			showFeedbackMessageToUser("Correct! The number of guesses you made was:"+numberOfTries);
		}
		return feedback;
	}

	public static void loopUntilUserGetsTheCorrectAnswer() {
		while(guessNumberisPresent(guessingNumberIsPresent)) {
			generatedRandomNumber();	
			askUserToGuessRandomNumber();
			readAndReturn = readAndReturnUserGuessAtRandomNumber();
			System.out.println(readAndReturn);
			getAndReturnFeedbackMessageForUser();
		}
	}
	
	public static boolean guessNumberisPresent(boolean guessingNumberIsPresent) {
		return guessingNumberIsPresent==false;
	}
	
	public static void play() {
		loopUntilUserGetsTheCorrectAnswer();
	}
	
	public static void continuePlayingOrQuitTheGame() {
		correctGuessNumber=0;
		numberOfTries=0;
		GamesArcade.play();
		System.exit(1);
	}
}




