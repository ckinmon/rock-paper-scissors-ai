package rps;

import java.util.Scanner;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class was created in step four to do two things:  accept and validate
 * user input when prompted to decide if they want to play as a "friend" or 
 * "simulated friend."  It didn't seem appropriate to throw these two methods
 * in any of the other classes, so it became its own.
 * <br><br>
 * Both methods are bools.  One accepts keyboard input as either a 'y' or 'n' to
 * represent the user's response as YES and NO, and then the other method validates 
 * that the user actually entered one of those two options. If the user chooses yes,
 * the method returns true and the Runner class can choose a set of instructions
 * for running a simuated friend against the computer/AI. If the user chooses no,
 * then the Runner class chooses a different set of instructions where a "friend"
 * plays against the computer/AI.
 */
public class Simulator{
	
	/**
	 * This method was added for Step Four so that the option to play
	 * as a simulated player can occur.
	 * @return a boolean value that indicates whether or not the program
	 * should run as a simulated friend against the computer.
	 */
	public boolean playAsSimulatedFriend(){
		userResponse = keyboardInput.next().charAt(0);
		while (validateUserResponse() == false){
			System.out.print("Invalid character. Please enter a valid character: ");
			userResponse = keyboardInput.next().charAt(0);
		}
		if (userResponse == 'y' || userResponse == 'Y'){
			simulatedPlay = true;
		}
		if (userResponse == 'n' || userResponse == 'N'){
			simulatedPlay = false;
		}
		return simulatedPlay;
	}
	
	/**
	 * This function was added to validate the users response when
	 * prompted to enter whether or not they want to run a simulation
	 * or play as a live person. 
	 * @return boolean: true if the input is valid, false if not. 
	 */
	public boolean validateUserResponse(){
		if (userResponse == 'y'){
			return true;
		}
		else if (userResponse == 'n'){
			return true;
		}
		else{
			return false;
		}
	}
	
	// Step Four: used to allow a simulated friend play against the AI
	private boolean simulatedPlay;
	private char userResponse;
	private Scanner keyboardInput = new Scanner(System.in);
}
