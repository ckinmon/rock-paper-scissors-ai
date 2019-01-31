/**
 * 
 */
package rps;

/**
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class displays output to the screen for the user.  It contains
 * a welcome message (which also contains the games rules), and it asks the 
 * "friend" player to input a character to select a throw. It also contains 
 * three methods to display to player one "the friend" if they won, lost, or tied
 * with player two "the computer".  Finally, a method exists to display the results
 * of the games as aggregated data.
 * <br><br>
 * UPDATE: after step three, this class was expanded to account for RPS-LK.  The welcome
 * message and rules now contain the newly added throws. The method asking the friend to
 * input a character now include options for lizard and spock.
 * <br><br>
 * UPDATE: after step four, this class contains an additional method that asks the user
 * if they want to run the game as a "friend" or "simulated player". 
 * <br><br>
 * NOTE: I avoided using this class to accept and validate keyboard input because the class
 * that actually uses that data often is Thrower. So this class was designated to act
 * only as a means of communicating to the user through outputting text to screen. 
 */
public class Talker {
	
	/**
	 * This method displays a welcome message and 
	 * the rules of the game.
	 * <br><br>
	 * <em>This function was expanded for Step Three to include LIZARD and SPOCK options</em>.
	 */
	public void displayWelcomeMessage(){
		System.out.println("Welcome to ROCK PAPER SCISSORS!");
		System.out.println("The rules are simple:");
		System.out.println("\tROCK smashes SCISSORS.");
		System.out.println("\tROCK crushes LIZARD.");
		System.out.println("\tSCISSORS cuts PAPER.");
		System.out.println("\tSCISSORS decapitates LIZARD.");
		System.out.println("\tPAPER covers ROCK.");
		System.out.println("\tPAPER disproves SPOCK.");
		System.out.println("\tLIZARD poisons SPOCK.");
		System.out.println("\tLIZARD eats PAPER.");
		System.out.println("\tSPOCK smashes SCISSORS.");
		System.out.println("\tSPOCK vaporizes ROCK.");
		System.out.println("\tThe same move results in a tie.");
	}
	
	/**
	 * This method is for when a user is playing against
	 * a computer. It asks the user to select a move.
	 * <br><br>
	 * <em>This function was expanded for Step Three to include LIZARD and SPOCK options</em>.
	 */
	public void askFriendForChar(){
		System.out.println("----------");
		System.out.println("Choose a move below:");
		System.out.println("\tEnter 'r' to select ROCK.");
		System.out.println("\tEnter 'p' to select PAPER.");
		System.out.println("\tEnter 's' to select SCISSORS.");
		System.out.println("\tEnter 'l' (lowercase L) to select LIZARD.");
		System.out.println("\tEnter 'k' to select SPOCK.");
		System.out.print("Enter a valid character: ");
	}
	
	/**
	 * This method displays the results of a win
	 * @param playerOneHand contains a String showing players hand
	 * @param playerTwoHand contains a String showing players hand
	 */
	public void displayWinner(String playerOneHand, String playerTwoHand){
		System.out.println("");
		System.out.println("You won!");
		System.out.println(playerOneHand + " beats " + playerTwoHand);
	}
	
	/**
	 * This method displays the results of a loss
	 * @param playerOneHand contains a String showing players hand
	 * @param playerTwoHand contains a String showing players hand
	 */
	public void displayLoser(String playerOneHand, String playerTwoHand){
		System.out.println("");
		System.out.println("You lost!");
		System.out.println(playerOneHand + " loses to " + playerTwoHand);
	}
	
	/**
	 * This method displays the results of a tie
	 * @param playerOneHand contains a String showing players hand
	 * @param playerTwoHand contains a String showing players hand
	 */
	public void displayTie(String playerOneHand, String playerTwoHand){
		System.out.println("");
		System.out.println("You tied!");
		System.out.println(playerOneHand + " ties with " + playerTwoHand);
	}
	
	/**
	 * This method displays the games statistics as straight text output except
	 * for calling methods of the Statistics class to display more text output
	 * @param statistics contains the object of type Statistics 
	 */
	public void displayAggregatedOutcomes(Outcome outcome){
		System.out.println("");
		System.out.println("GAME OVER!");
		System.out.println("--------GAME STATISTICS--------");
		System.out.println("WINS\tLOSSES\tTIES\tWIN %");
		System.out.println(outcome.getTotalWins() + "\t" + outcome.getTotalLosses() + "\t" +  outcome.getTotalTies() + "\t" +  outcome.getWinningPercentage() + "%");
		System.out.println("Total Games Played: " + outcome.getTotalGamesPlayed());
	}
	
	/**
	 * This method was created in step four to display the message that
	 * asks if a simulated friend should play against the computer/AI.
	 */
	public void displaySimulatedFriendMessage(){
		System.out.print("Do you want to play as a simulated friend? Enter 'y' or 'n': ");
	}
	
}