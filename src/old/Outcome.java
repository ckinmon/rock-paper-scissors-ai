package my.rps;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class determines the outcome of the game.  It seemed appropriate to make Outcome
 * its own class because Thrower handled decision making for the friend and computer players, 
 * and Talker handled outputting text to the screen.
 * Outcome contains two main methods, and arguably the most complicated one (before I get to AI) that
 * determines if the friend or computer won, lost, or tied. Having said that, I turned this into its
 * own class, because it had at least two methods that didn't belong anywhere else.
 * <br><br>
 * UPDATE: After careful consideration, I decided to expand this class so that it keeps track of 
 * the wins, losses, and ties for the friend player.  Initially, these stats were kept in a 
 * class called Statistics, but Outcome was primarily using Statistics methods to access its data.
 * Therefore I removed the Statistics class, and optimized Outcome to handle storing and retrieving
 * the wins, losses, and ties. This class also runs two calculations, one to determine a 
 * player's winning percentage, and the other to calculate the total games played.
 * <br><br>
 * UPDATE:  after step three, the compute outcome function was slightly expanded to include
 * the potential outcomes for lizard and spock.
 */
public class Outcome {
	
	/**
	 * This method compares the throws of two players and determines an outcome.
	 * It calls the function that searches the main charArray data structure for player one's throw,
	 * and then finds player two's throw and uses the hard-coded "rules" to determine the match's 
	 * outcome based on the two throws.
	 * <br><br>
	 * UPDATE: For Step Three, this function was expanded to account for the new data elements
	 * LIZARD and SPOCK.
	 * <br><br> 
	 * @param player1 Thrower object represents the friend/simulated player. 
	 * @param player2 Thrower object represents the computer/AI player.
         * @return result of type String.
	 */ 
	public String computeOutcome(Thrower player1, Thrower player2){
		
		searchCharArrayForPlayersThrow(player1);
                String result = new String();

		// player one and player two ties, matching throws, display outcome
		if (player2.getThrow() == ValidThrows.charArrayOfThrows[locationOfThrow][0]){
			playerTwoHand = playerOneHand;
			result = talker.displayTie(playerOneHand, playerTwoHand);
			ties++;
		}
			
		// player one wins, and player two loses, display outcome
                else if (player2.getThrow() == ValidThrows.charArrayOfThrows[locationOfThrow][1]){
			playerTwoHand = ValidThrows.stringArrayOfThrows[locationOfThrow][1];
			result = talker.displayWinner(playerOneHand, playerTwoHand);
			wins++;
		}
		
		// player one wins, and player two loses, display outcome
                else if (player2.getThrow() == ValidThrows.charArrayOfThrows[locationOfThrow][2]){
			playerTwoHand = ValidThrows.stringArrayOfThrows[locationOfThrow][2];
			result = talker.displayWinner(playerOneHand, playerTwoHand);
			wins++;		
		}
		
		// player one loses, and player two wins, display outcome
                else if (player2.getThrow() == ValidThrows.charArrayOfThrows[locationOfThrow][3]){
			playerTwoHand = ValidThrows.stringArrayOfThrows[locationOfThrow][3];
			result = talker.displayLoser(playerOneHand, playerTwoHand);
			losses++;		
		}
		
		// player one loses, and player two wins, display outcome
                else if (player2.getThrow() == ValidThrows.charArrayOfThrows[locationOfThrow][4]){
			playerTwoHand = ValidThrows.stringArrayOfThrows[locationOfThrow][4];
			result = talker.displayLoser(playerOneHand, playerTwoHand);
			losses++;
		}
                
                return result;
	}
	
	/**
	 * This method searches the first index of each nested array to find 
	 * a char that matches the players throw. Each nested array is structured in a specific
	 * way to represent each possible outcome based on the first index. So identifying the
	 * first index is important for eventually determining the outcome. 
	 * @param takes an object of the Thrower class
	 */
	public void searchCharArrayForPlayersThrow(Thrower player1){
		for (int row = 0; row < ValidThrows.charArrayOfThrows.length; row++){
			if (player1.getThrow() == ValidThrows.charArrayOfThrows[row][0]){
				locationOfThrow = row;
				playerOneHand = ValidThrows.stringArrayOfThrows[row][0];
			}
		}
	}
	
	/**
	 * This method returns the total wins of player one (the friend or simulated friend). The 
	 * Talker class uses this method to display stats at the end.<br><br>   
	 * @return an integer to the Talker class.
	 */
	public int getTotalWins(){
		return wins;
	}
	
	/**
	 * This method returns the total losses of player one (the friend or simulated friend).
	 * Since RPS-LK is a zero sum game, one players win is the other player's loss. The 
	 * Talker class uses this method to display stats at the end.   
	 * @return an integer to the Talker class.
	 */
	public int getTotalLosses(){
		return losses;
	}
	
	/**
	 * This method returns the total ties of player one. The Talker class uses this method 
	 * to display stats at the end.   
	 * @return an integer to the Talker class.
	 */
	public int getTotalTies(){
		return ties;
	}
	
	/**
	 * This method returns the winning percentage of player one (the friend or simulated friend).
	 * I decided the method should return a calculation instead of a variable because it
	 * doesn't make sense to me use up memory, especially when I only use the result once
	 * at the end of the game when displaying the results. 
	 * @return a float, called by Talker for displaying stats to user at end of game.
	 */
	public float getWinningPercentage(){
		return ((float) wins / (wins + losses + ties)) * 100;
	}
	
	/** 
	 * This method is called by Talker to display the total games played between two
	 * players.
	 * <br><br>
	 * @return an integer representing the total games played.  Again, I chose
	 * to run a calculation and return the result instead of a variable to save memory,
	 * since it is only used once.
	 */
	public int getTotalGamesPlayed(){
		return wins + losses + ties;
	}
	
	private Talker talker = new Talker();
	private int locationOfThrow;
	private String playerOneHand, playerTwoHand;
	private int wins, ties, losses;
}
