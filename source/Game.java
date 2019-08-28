import java.util.Scanner;

/**
 * @author Caleb Kinmon
 * 
 * This class creates the actual game logic and is used to execute a
 * series of games of Rock, Paper, Scissors, Lizard, Spock. This class
 * uses the following classes: Talker, Player, Outcome, and GameData.
 * 
 * A test run of the game can be found in the public main static method
 * found at the end of this document.  
 */
public class Game{

    /**
     * This is the default constructor. Two parameters are required because
     * the game requires two players. 
     * @param p1 the first player of type Super class Player
     * @param p2 the second player of type Super class Player
     */
    Game(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
        gamesToPlay = 10;
    }

    /**
     * This method initializes the game and displays the rules to the user.
     */
    public void startGame(){
        talker = new Talker();
        outcome = new Outcome();
        data = new GameData();
        talker.showWelcome();
        talker.showRules();
    }

    /**
     * This method sets the number of games that the user wants to play.
     */
    public void setGamesToPlay(){
        Scanner scanner = new Scanner(System.in);
        talker.askForNumberOfGames();
        gamesToPlay = scanner.nextInt();
        scanner.close();
    }

    /**
     * This method executes the game and continuously plays the number of games set by 
     * the user.
     */
    public void play(){
        int count = 0;
        while(count++ < this.gamesToPlay){
            player1.computeMove();
            player2.computeMove();
            outcome.computeOutcome(player1, player2);
            System.out.println( outcome.getOutcome() );
            System.out.println( data.getResults() );
        }

        System.out.println( data.getMoves() );
    }

    private int gamesToPlay;
    private Talker talker;
    private Player player1;
    private Player player2;
    private Outcome outcome;
    private GameData data;

    // This is an example test run of the Game, using a Computer player
    // and an AI player.
    public static void main(String[] args){

        Game game = new Game(new ComputerPlayer(), new AIPlayer());
        game.startGame();  
        game.setGamesToPlay(); 
        game.play();
    }

}