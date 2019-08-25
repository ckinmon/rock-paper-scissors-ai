/**
 * @class 
 */
public class Talker{

    public void showWelcome(){
        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock!");
    }

    public void showRules(){
        System.out.println(
            "Here are the rules of the game." + 
            "\n\n" + 
            "Rock beats Scissors and Lizard." + "\n" +
            "Paper beats Rock and Spock." + "\n" +
            "Scissors beats Paper and Lizard" + "\n" +
            "Lizard beats Paper and Spock" + "\n" +
            "Spock beats Rock and Scissors" + "\n" + 
            "The same move results in a tie." + "\n" 
        );
    }

    public void askForMove(){
        System.out.println(
            "Select the move you want to make by entering" +
            " 'r' for Rock, 's' for Scissors, 'p' for Paper, 'l' for Lizard," + 
            " and 'k' for Spock."
        );
    }

    public void askForNumberOfGames(){
        System.out.println(
            "Enter the number of games that you want to play."
        );
    }
    
}