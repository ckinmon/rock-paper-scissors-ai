import java.util.Scanner;

public class HumanPlayer extends Player{

    private String move;
    private Talker talker;

    HumanPlayer(){ 
        talker = new Talker();
        move = null; 
    }

    @Override
    public void computeMove(){
        talker.askForMove();
        Scanner scanner = new Scanner(System.in);
        move = scanner.next();
        scanner.close();
    }

    @Override
    public String getMove(){
        return move;
    }

}