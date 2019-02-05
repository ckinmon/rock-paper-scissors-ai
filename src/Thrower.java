package rps;

import java.util.Scanner;
import java.util.Random;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class sets and gets the hands thrown for each player (the friend and computer)
 * and validates user input. It generates a random number for the computer to determine
 * a random throw, and it allows the friend to set their own hand.
 * <br><br>
 * UPDATE:  This class was expanded in step two to interact with an AI, or the "EnhancedThrower"
 * class. It now features a second setComputersThrow() method but it accepts an argument of 
 * Thrower player.  Instead of dumping the AI into the Thrower class, the AI was given its own
 * class "EnhancedThrower" and the Thrower class uses it as needed.
 * <br><br>
 * UPDATE:  This class did not require any updating for when the game was expanded to RPS-LK!  
 * <br><br>
 * UPDATE: This class did not require updating for step five!
 */
public class Thrower extends ValidThrows {
	
	/**
	 * This method is used to determine player one's throw by accepting user input, 
	 * when a real player is playing against the computer. I've tested numbers,
	 * characters, symbols, and blank spaces (in the first test for step one found in the RUNNER
	 * CLASS), and the function only accepts the user's input if its a valid move.
	 */
	public void setFriendsThrow(){
		
		selectedThrow = keyboardInput.next().charAt(0);
		
		while (validateUserThrow() == false){
			System.out.println("Invalid character. Please enter a valid character: ");
			selectedThrow = keyboardInput.next().charAt(0);
		}
	}

	/**
	 * This function determines the computer player's move. 
	 * UPDATE:  This function was expanded to include the AI's ability. So an
	 * if else statement was added to keep its randomness, but at the same time
	 * the computer attempts to make an "educated" throw.
	 */
	public void setComputersThrow(){
		generateRandomInt();
		selectedThrow = charArrayOfThrows[0][randomIndex];
	}
	
	/**
	 * UPDATE:  This method was added to include the AI's ability. An
	 * if else statement was added to keep its randomness, but at the same time
	 * the computer attempts to make an "educated" throw when it has enough data. It also accepts
	 * a Thrower object as a parameter, so that the AI records the opposing player's
	 * thrower after the match.
	 * <br><br>
	 * This method essentially augments the class and allows it to interact with
	 * the EnhancedThrower class, where the AI is located.
	 * @param takes an object of the Thrower class.
	 */
	public void setComputersThrow(Thrower player){
		if (enhancedThrower.getTotalRecordedThrows() > 20){
			selectedThrow = enhancedThrower.computeBestThrow();
		}
		else{
			generateRandomInt();
			selectedThrow = charArrayOfThrows[0][randomIndex];
		}
		enhancedThrower.recordThrows(player);
	}
	
	/**
	 * This method returns a player's selected throw, whether that
	 * player is a "friend", "simulated friend", or "computer."
	 * Because the input is validated, it will only return a character of
	 * r p s l or k.
	 * @return a character representing the player's throw.
	 */
	public char getThrow(){
		return selectedThrow;
	}
	
	/**
	 * This method is used to validate user input when the "friend" (live player) is
	 * entering a character to choose a throw. I used numbers, characters, and symbols
	 * to test to make sure if would return true only if a valid character was inputted.
	 * @return true if the input matches 'r', 's', 'p'. UPDATE: added 'l' (lowercase L) & 'k'.
	 */
	private boolean validateUserThrow(){
		for (int i = 0; i < charArrayOfThrows.length; i++){
			if (selectedThrow == charArrayOfThrows[0][i]){
				validatedInput = true;
				break;
			}
			else{
				validatedInput = false;
			}
		}
		return validatedInput; 
	}
	
	/**
	 * Generates a random integer between 0 and length of charArrayOfThrows, which contains
	 * all the possible throws.  By using .length instead of a constant, I can easily expand
	 * the data structure and not alter the function itself. This randomly generated number
	 * is used as an array index for when the computer chooses a throw. 
	 */
	private void generateRandomInt(){
		randomIndex = random.nextInt(charArrayOfThrows[0].length);
	}
	
		
	// Step One:
	private Random random = new Random();
	private Scanner keyboardInput = new Scanner(System.in);
	private char selectedThrow;
	private int randomIndex;
	private boolean validatedInput;
	
	// Step Two:
	private EnhancedThrower enhancedThrower = new EnhancedThrower();

}
