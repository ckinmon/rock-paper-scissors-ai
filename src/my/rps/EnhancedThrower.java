package my.rps;

import java.util.Random;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * * UPDATE:  This class was created for step two. It contains a few methods for recording data,
 * searching for data, and selecting the "best" data so that the Thrower can be "enhanced"
 * and make better decisions. I chose to make this its own class because its unique from 
 * the Thrower and I didn't want to burden the Thrower class with more than eight methods. Plus
 * the main method or "mind" of the AI in this class is a larger, complicated algorithm that
 * contains at least two helper methods. 
 * <br><br>
 * The AI records the opposing player's throws in an array, searches for the most commonly
 * thrown hand, then calculates if there's a bias and if so how to deal with that bias.
 * If the AI finds a player is making the same unique throw more than 33% of the time, it increases 
 * its likelihood that it will "randomly" choose the throw that beats the opposing player's biased 
 * throw. For example, if "friend" throws indiscriminately, the AI throws randomly. But if the 
 * opposing player throws scissors 50% of the time, the AI is more likely to throw rock.   
 * <br><br>
 * UPDATE:  after step three, this class was updated to account for the expansion from RPS
 * to RPS-LK.  The only update consisted of expanding the AI's array of recorded throws to
 * include lizard and spock.
 * <br><br>
 * UPDATE: for step five, this class was updated to include two new methods, one of which is called
 * makeAiGreatAgain(), which helps improve the initial AI. The other method is a helper that assists
 * makeAiGreatAgain() complete its tasks. These methods now help the AI find the opposition's least
 * likely throw, and then decrease the likelihood the computer will randomly choose a throw to
 * deal with the one identified. For example, if I never choose SCISSORS, the AI will try to avoid 
 * throwing ROCK and SPOCK too often, because it isn't necessary to win. Keep in mind that if
 * a pattern isn't detected then the AI will just throw randomly.
 *
 */
public class EnhancedThrower {
	
	/**
	 * UPDATE: This method searches for the opposition's most
	 * commonly thrown hand in an array, and then remembers that index for future reference.
	 */
	private void searchArrayForMostCommonThrow(){
		for (int i = 0; i < arrayOfRecordedThrows.length - 1; i++){
			if (arrayOfRecordedThrows[i] > arrayOfRecordedThrows[i + 1]){
				mostThrows = i;
			}
			else{
				mostThrows = i + 1;
			}
		}
	}
	
	/**
	 * UPDATE: This method searches the array for the best 
	 * throw to use against the opposition's most commonly thrown hand.
	 * <br><br>
	 * UPDATE: after step three, the function was expanded by one line to account for
	 * lizard and spock, and the fact that each throw can now be beaten by two other
	 * throws instead of one. See the line: randomIndex = random.nextInt(2) + 1. 
	 */
	private void selectBestThrowInArray(){
		if (randomIndex > ValidThrows.charArrayOfThrows[0].length){
			for (int i = 0; i < ValidThrows.charArrayOfThrows.length; i++){
				if (charArrayOfRecordedThrows[mostThrows] == ValidThrows.charArrayOfThrows[i][0]){
					/* This random integer generation assignment was added in step three since each
					 * throw can be beaten by two other throws
					 */
					randomIndex = random.nextInt(2) + 1;
					bestThrow = ValidThrows.charArrayOfThrows[i][randomIndex];
					// Step Five - new AI feature
					bestThrow = makeAiGreatAgain();
				}
			}
		}
		else{
			bestThrow = ValidThrows.charArrayOfThrows[0][randomIndex];
			// Step Five - new AI feature
			bestThrow = makeAiGreatAgain();
		}
	}

	/** 
	 * UPDATE:  This method is actually the "mind" of the AI.  I chose to make an AI that 
	 * is still random but as it collects more data about the players bias (number of times 
	 * a player may choose a specific throw), it increases the likelihood that the random throw 
	 * will be a throw that beats the player's throw.  
	 * <br><br>
	 * The AI begins weights the likelihood of throws based on if a bias is determined 
	 * (how many times a player chooses a hand).  If a player is choosing each throw 33% 
	 * of the time, the AI won't weigh its throws and will instead choose randomly.  
	 * If a player is choosing a move more than 33% of the time, the AI is more likely
	 * to choose the hand that beats the player's preferred move. If a player's move is chosen more
	 * than 66% of the time, the AI is even MORE likely to choose the hand that beats the player's
	 * preferred move.  And so on. 
	 * <br><br>
	 * UPDATE: This function was expanded for step three to account for LIZARD and SPOCK and the fact
	 * that there's a theoretical chance of 20% that any given hand will be chosen. Instead
	 * of weighting in increments of 33%, it now chooses increments of 20%, starting at or above 40%.
	 * <br><br>
	 */
	public char computeBestThrow(){
		searchArrayForMostCommonThrow();
		if (((arrayOfRecordedThrows[mostThrows] / totalThrows) * 100) < 40){
			randomIndex = random.nextInt(ValidThrows.charArrayOfThrows[0].length);
			selectBestThrowInArray();
		}
		if (((arrayOfRecordedThrows[mostThrows] / totalThrows) * 100) >= 40){
			randomIndex = random.nextInt(ValidThrows.charArrayOfThrows[0].length + 4);
			selectBestThrowInArray();
		}
		if (((arrayOfRecordedThrows[mostThrows] / totalThrows) * 100) >= 60){
			randomIndex = random.nextInt(ValidThrows.charArrayOfThrows[0].length + 8);
			selectBestThrowInArray();
		}
		if (((arrayOfRecordedThrows[mostThrows] / totalThrows) * 100) > 80){
			randomIndex = random.nextInt(ValidThrows.charArrayOfThrows[0].length + 20);
			selectBestThrowInArray();
		}
		return bestThrow;
	}
	
	/**
	 * UPDATE:  This method was added for the AI.  It records the user's selected throws 
	 * in an array.  Each array index represents a throw, and one is added to each respective 
	 * index every time a user makes throw. This makes it easy for the AI to determine what the 
	 * user is throwing the most because arrays are easy to search. 
	 * <br><br>
	 * UPDATE:  This function was expanded in Step Three to include lizard and spock, 'l' and 'k'.
	 * @param player: receives an argument that is Thrower object so that we can 
	 * pull that specific player's throw.
	 */
	public void recordThrows(Thrower player){
		if (player.getThrow() == 'r'){
			arrayOfRecordedThrows[0]++;
		}
		if (player.getThrow() == 'p'){
			arrayOfRecordedThrows[1]++;
		}
		if (player.getThrow() == 's'){
			arrayOfRecordedThrows[2]++;
		}
		if (player.getThrow() == 'l'){
			arrayOfRecordedThrows[3]++;
		}
		if (player.getThrow() == 'k'){
			arrayOfRecordedThrows[4]++;
		}
		totalThrows++;
	}
	
	/**
	 * UPDATE:  This method returns the total throws made by the opposing player that the
	 * AI has also recorded.  The Thrower class uses it to determine if enough data
	 * has been collected to justify using the AI's features to make better decisions. 
	 * @return an integer that represents the total recorded throws.
	 */
	public int getTotalRecordedThrows(){
		return totalThrows;
	}
	
	/**
	 * UPDATE: This method was added for Step Five to help improve the AI. It identifies
	 * the opponent's least likely throw.  This method is used as a helper for the main
	 * method of the makeAiGreatAgain method.
	 */
	private void searchArrayForLeastCommonThrow(){
		for (int i = 0; i < arrayOfRecordedThrows.length - 1; i++){
			if (arrayOfRecordedThrows[i] < arrayOfRecordedThrows[i + 1]){
				leastThrows = i;
			}
			else{
				leastThrows = i + 1;
			}
		}
		leastCommonThrow = charArrayOfRecordedThrows[leastThrows];
	}
	
	/**
	 * UPDATE: This method was added for Step Five to improve the EnhancedThrower "AI".  After the
	 * AI selects the best throw based upon its initial version from step two, it calls this
	 * method which eliminates the opponent's least likely throw.   
	 * @return a char to the computeBestMove method from the initial AI.
	 */
	private char makeAiGreatAgain(){
		searchArrayForLeastCommonThrow();
		for (int i = 0; i < ValidThrows.charArrayOfThrows.length; i++){
			if (bestThrow == ValidThrows.charArrayOfThrows[i][0]){
				if (leastCommonThrow == ValidThrows.charArrayOfThrows[i][1] || leastCommonThrow == ValidThrows.charArrayOfThrows[i][2]){
					randomIndex = random.nextInt(4);
					bestThrow = ValidThrows.charArrayOfThrows[i][randomIndex];
				}
			}
		}
		return bestThrow;
	}
	
	// Step Two: These variables are used by the AI to get useful information 
	// from the arrayOfRecordedThrows
	private int mostThrows;
	private int totalThrows;
	private int randomIndex;
	private char bestThrow;
	private Random random = new Random();
	
	/* Step Two: This array was built to help with the AI, each index
	 * represents a unique throw.
	 * [0] = rock; [1] = paper; [2] = scissors; [3] = lizard; [4] = spock
	 * For Step Three, this array was expanded to include LIZARD and SPOCK.
	 */ 
	private int[] arrayOfRecordedThrows = new int[5];
	private char charArrayOfRecordedThrows[] = new char[]{'r', 'p', 's', 'l', 'k'};
	
	// Step Five:  These variables were added and used by the MAIGA feature
	// that improves the EnhancedThrower and Thrower classes.
	private int leastThrows;
	private char leastCommonThrow;
}
