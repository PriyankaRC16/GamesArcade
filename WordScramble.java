															//NAME: PRIYANKA ROY CHOUDHURY
															//STUDENT NUMBER: 180336834
															//COURSE NUMBER: CO1109
															//ASSIGNMENT NUMBER: cw1 

/*
This game can be used to test a user's knowledge in at least 3 rounds. The 3 rounds would consist
of beginner level, intermediate level and the challenging level. The user has to choose any one 
level to proceed with the game. If the user has guessed a word correctly, the user can either continue 
or quit the game. However, if the user has not guessed the word correctly, the game will start all over 
again.
  
For each level of the game, there can be points awarded to the user. For every correct
answer, 10 points would be awarded. If the user has partially guessed the answer, 5 
points would be awarded. However, there would be no points if the user has not 
attempted to guess the word. There should also be a points result page where the user
can view the total points of the levels that they had played.
*/

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class WordScramble {
    private static Random random = new Random();
    private static String[] words = { "formula", "mechanic", "embolden", "scramble", "medicine", "autopilot", "photocopier" };
    private static final int NUMBER_OF_LIVES = 2;

    public static void play(Scanner input, PrintStream output) {
        String wordToGuess = getWordToGuess();
        String scrambledWord = scramble(wordToGuess);

        showScrambledWord(output, scrambledWord);
        loopUntilUserGuessesCorrectlyOrRunsOutOfLives(input, output, wordToGuess);
    }

    private static String getWordToGuess() {
        int i = random.nextInt(words.length);
        return words[i];
    }

    private static String scramble(String word) {
        char[] scramble = word.toCharArray();

        int length = scramble.length;
        int counter = length * 2;
        int x, y;
        while (counter > 0) {
            x = random.nextInt(length);
            y = random.nextInt(length);          
            swapChars(x, y, scramble);
            counter--;
        }

        return new String(scramble);
    }
    
    private static void swapChars(int x, int y, char[] scramble){
		 char z = scramble[x];
		 scramble[x] = scramble[y];
         scramble[y] = z;
	}

    private static void showScrambledWord(PrintStream output, String scrambledWord) {
        output.println("Unscramble this word: " + scrambledWord);
    }

    private static void loopUntilUserGuessesCorrectlyOrRunsOutOfLives(Scanner input, PrintStream output, String wordToGuess) {
        int guesses = NUMBER_OF_LIVES;
        boolean guessedCorrectly;
        do {
            askUserToGuess(output);
            String guess = getUserGuess(input);
            guesses--;
            guessedCorrectly = didUserGuessWord(wordToGuess, guess);
            String message = getFeedbackMessageForUser(guessedCorrectly, guesses, wordToGuess);
            output.println(message);
        } while (userHasNotGuessedWordAndHasGuessesRemaining(guesses, guessedCorrectly));
    }

    private static void askUserToGuess(PrintStream output) {
        output.print("Enter your guess: ");
    }

    private static String getUserGuess(Scanner in) {
        return in.nextLine();
    }

    private static boolean didUserGuessWord(String wordToGuess, String guess) {
        return wordToGuess.equalsIgnoreCase(guess);
    }

    private static String getFeedbackMessageForUser(boolean correct, int guessesLeft, String wordBeingGuessed) {
        if (correct) {
            return "Correct. You win!";
        } else if (!correct && guessesLeft == 1) {
            return "That's not the answer. Here's a hint: " + getHint(wordBeingGuessed);
        } else {
            return "Incorrect. You Lose! The word was '" + wordBeingGuessed + "'.";
        }
    }

    private static boolean userHasNotGuessedWordAndHasGuessesRemaining(int numberOfGuessesLeft, boolean guessedTheWordCorrectly) {
        return numberOfGuessesLeft > 0 && !guessedTheWordCorrectly;
    }

    private static String getHint(String word) {
        return "the first letter of the word is " + word.charAt(0);
    }

    public static void main(String[] args) {
        WordScramble.play(new Scanner(System.in), System.out);
    }
}

