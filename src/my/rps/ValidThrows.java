package my.rps;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This interface contains two data structures to represent the possible outcomes of the game. 
 * charArrayOfThrows is used to match valid character input, and stringArrayOfThrows is the 
 * corresponding representation of that character spelled out fully as a string. Because multiple 
 * classes use these data structures (Thrower, Outcome, EnhancedThrower), this interface was 
 * created so that any class can implement.
 * <br><br>
 * Both 2D arrays (3 x 3) are hard-coded in a specific way. The first element in each sub-array beats the
 * second element and loses to the third element. For example, if player one chose paper, then 
 * a function can search the first index of each sub array [i][0] until it finds a match. After finding
 * a match [1][0], a second function can search the sub-array [1][i] for a match to player two's throw. 
 * If player two's throw is located at the first index [1][0], its a tie. [1][1] would mean player one
 * wins, and [1][2] would mean player two wins. 
 * <br><br>
 * These data structures were chosen because they can easily be expanded to include more options.
 * <br><br>
 * UPDATE:  after step three, both of these data structures were expanded to include LIZARD "l" 
 * and SPOCK "k".  Now, the first element beats the second and third element, and loses to the 
 * fourth and fifth elements. The same concept behind the idea of the previous version of these data
 * structures still applies. 
 * <br><br>
 */
public class ValidThrows {
	
	static final String[][] stringArrayOfThrows = new String[][]{{"ROCK", "SCISSORS", "LIZARD", "PAPER", "SPOCK"}, {"PAPER", "ROCK", "SPOCK", "SCISSORS", "LIZARD"}, {"SCISSORS", "PAPER", "LIZARD", "ROCK", "SPOCK"}, {"LIZARD", "PAPER", "SPOCK", "SCISSORS", "ROCK"}, {"SPOCK", "ROCK", "SCISSORS", "PAPER", "LIZARD"}};
	static final char[][] charArrayOfThrows = new char[][]{{'r', 's', 'l', 'p', 'k'}, {'p', 'r', 'k', 's', 'l'}, {'s', 'p', 'l', 'r', 'k'}, {'l', 'p', 'k', 's', 'r'}, {'k', 'r', 's', 'p', 'l'}};
}
