package rps;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class is used to test the program and the interactions among the other classes.
 * It calls methods from various classes to:  display the welcome message and rules,
 * ask the user to input a valid character (throw), force the opposing player (the computer) 
 * to make a move, then determine the outcome and eventually display the results. 
 * <br><br>
 * The Runner class uses the Talker, Thrower, Outcome, and Simulator classes to run the game.
 * <br><br>
 * UPDATE: after step two, a call to method was added that enables the AI to track player one's
 * throws.
 * <br><br>
 * UPDATE: after step four, an if else statement was added so that the user can decide if
 * they want to run the game as a "friend" or a "simulated player".  Depending on the choice,
 * the user will play the AI or allow a simulated friend to randomly throw against the AI.
 * A simulated player object was created from Thrower to account for the update.
 * <br><br>
 * Below are the test results for each step. I also included the full input/output
 * of each step/test in the zip file.
 * <br><br>
 * <strong>Step One Results</strong>:<br>
 * Testing for step one (Hwk1Step1Output.txt).  This also includes input testing for bad characters.
 * I played against a computerPlayer that randomly chose various throws.  The computerPlayer 
 * won more than I did.  My winning % was 32.00% and the computerPlayer's 42%. Testing indicates
 * that the computerPlayer's ability to purely make random throws is superior. Hopefully the 
 * next round of testing featuring the AI will help improve the computerPlayer.
 * <br><br>
 * --------GAME STATISTICS--------<br>
 *	WINS	LOSSES	TIES	WIN %<br>
 *	32		42		26		32.0%<br>
 *	Total Games Played: 100
 *<br><br>
 *----------------------------------------------------------
 *<br><br>
 * <strong>Step Two Results</strong>:<br>
 *  Testing for step two (Hwk1Step2Output.txt). I played against the computerPlayer with an 
 *  AI feature added to the mix. The AI records all of the opposing player's throws, and then searches 
 *  to see if the player is choosing the same throw more than others. If the AI detects I'm making 
 *  the same throw at least 33% of the time, then the AI increases the likelihood that it will choose 
 *  a throw that can beat the throw I keep choosing. The AI won with 40% compared to my 32%, a slight 
 *  drop compared to the previous step (although not statistically significant).
 *  <br><br>
 *	--------GAME STATISTICS--------<br>
 *	WINS	LOSSES	TIES	WIN %<br>
 *	32		40		28		32.0%<br>
 *	Total Games Played: 100
 *<br><br>
 * ----------------------------------------------------------
 *<br><br>
 * <strong>Step Three Results</strong>:<br>
 * Test results (Hwk1Step3Output.txt) from where I played RPS-LK against the AI.
 * The AI is essentially recording all the player's throws, and then determining if a player is 
 * choosing one of those throws at a percentage greater than 40%. If so, the AI increases 
 * its likelihood of choosing a throw that beats the player's commonly chosen throw.
 * If a pattern isn't detected, then the AI defaults to throwing randomly. I won 38.5% of the
 * time, and the AI won 43.5%. 
 * <br><br>
 *	--------GAME STATISTICS--------<br>
 *	WINS	LOSSES	TIES	WIN %
 *	77		87		36		38.5%
 *	Total Games Played: 200
 *<br><br>
 * ------------------------------------------
 *<br><br>
 * <strong>Step Four Results</strong>:<br>
 * Test results (Hwk1Step4Output.txt) from where the AI played against a fully simulated player that
 * randomly chose various throws. I ran 10,000 games and the simulatedPlayer beat the
 * AI, although not by much (40.56% vs. 39.44%, just over one percent).  I ran the 
 * game a few more times and got the same result (basically a statistical tie). 
 * I'm suspecting that since the simulated friend is programmed to throw randomly, 
 * then there isn't a pattern for the AI to detect, therefore it never actually runs the 
 * AI feature. Instead the AI throws randomly because a pattern isn't detected, which 
 * is what it is programmed to do.  
 * <br><br>
 *	--------GAME STATISTICS--------<br>
 *	WINS	LOSSES	TIES	WIN %<br>
 *	4056	3944	2000	40.56%<br>
 *	Total Games Played: 10000
 *<br><br>
 *--------------------------------------------------
 * <br><br>
 * <strong>Step Four Results</strong>:<br>
 * Test results (Hwk1Step4Output_test.txt) from where the AI played against a live person (me) to ensure that
 * the functionality still worked after altering it to allow a simulated player. 
 * The game worked, but the results were not promising, as I beat the AI. However,
 * I only played 2% of the total games the simulatedPlayer.
 * <br><br>
 *	--------GAME STATISTICS--------<br>
 *	WINS	LOSSES	TIES	WIN %<br>
 *	91		78		31		45.5%<br>
 *	Total Games Played: 200
 *	<br><br>
 *	------------------------------------------------
 *	<br><br>
 * <strong>Step Five Results</strong>:<br>
 * Test results (Hwk1Step5Output.txt) from the first game against the updated AI against a friend player
 * instead of a simulated player.  The simulated player throws randomly so there's
 * no reason to test against it.  No pattern can be detected, and the winning
 * percentage between it and the AI is essentially tied.  However, the AI
 * beat me, a live player, in this round, with 41% to my 36.5%. I'm going to run the 
 * test again for 200 rounds, and report the results below. Essentially the AI
 * is tracking whether or not I'm not making one of the throws, and if I'm not,
 * and the AI chooses a throw that beats the throw I'm not making, it changes
 * to a different throw.
 *  <br><br>
 *	--------GAME STATISTICS--------
 *	WINS	LOSSES	TIES	WIN %
 *	73		82		45		36.5%
 *	Total Games Played: 200
 *  <br><br>
 *  -------------------------------------------------
 *  <br><br>
 *  <strong>Step Five Results</strong>:<br>
 *  Test results (Hwk1Step5Output_test2.txt) from the second game from step five.  I needed to confirm that
 *  the AI is successfully tracking a pattern based on the results from the last round,
 *  and not beating me based on its ability to throw randomly, but on its "educated throws."
 *  So I intentionally threw SCISSORS 80 out of 200 times, which is 40%. At any point when 
 *  the opposing player is making the throw at least 40% of the the, the AI kicks in and increases the
 *  likelihood the computer makes a throw that will win -- in this case, beat scissors. In 
 *  response, the AI threw either ROCK or SPOCK, both throws that beat scissors, 109 times (54.5%). 
 *  Moreover, I only threw SPOCK six times, which is 3%. The updated AI should detect that I'm never
 *  throwing SPOCK, and consequently begin increasingly avoiding throws such as PAPER and LIZARD, 
 *  since it doesn't need that combination in order to win. The results show the computer/AI only
 *  threw PAPER and LIZARD a total of 29 times, or 14.5%.  The AI is successfully detecting patterns,
 *  and acting appropriately.  Even better, when a pattern diminishes, the AI goes back to
 *  throwing random, which is its best strategy.
 *  <br><br>
 *  --------GAME STATISTICS--------
 *	WINS	LOSSES	TIES	WIN %
 *	67		86		47		33.5%
 *	Total Games Played: 200
 */
public class Runner {

	public static void main(String[] args) {
		
		Talker talker = new Talker();
		// Three Thrower objects to represent friend, simulated player, and computer opponent
		Thrower friendPlayer = new Thrower();
		Thrower computerPlayer = new Thrower();
		Thrower simulatedPlayer = new Thrower(); // added for step four
		Simulator simulation = new Simulator(); // added for Step Four
		Outcome outcome = new Outcome();
		
		
		talker.displayWelcomeMessage();
		talker.displaySimulatedFriendMessage(); // this call was added for Step Four
		
		/* The following if else statement was added for Step Four so that
		 * a decision could be made on whether or not to run the program
		 * as a simulated friendPlayer or a real person.
		 */
		if(simulation.playAsSimulatedFriend() == true){
			for (int i = 0; i < 10000; i++){
				simulatedPlayer.setComputersThrow();
				computerPlayer.setComputersThrow(simulatedPlayer); // This argument was added to override the method so the class knows its an AI
				outcome.computeOutcome(simulatedPlayer, computerPlayer);
			}
		}
		
		/* If you want to play against the non-AI computer, just remove the argument when calling
		*  the setComputersThrow method.
		*/ 
		else{
			for (int i = 0; i < 200; i++){
				talker.askFriendForChar();
				friendPlayer.setFriendsThrow();
				computerPlayer.setComputersThrow(friendPlayer); // This argument was added to override the method so the class knows its an AI 
				outcome.computeOutcome(friendPlayer, computerPlayer);
			}
		}
		talker.displayAggregatedOutcomes(outcome);
	}

}
