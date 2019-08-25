import java.util.Scanner;

public class Game{

    Game(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
        gamesToPlay = 10;
    }

    public void startGame(){
        talker = new Talker();
        outcome = new Outcome();
        data = new GameData();
        talker.showWelcome();
        talker.showRules();
    }

    public void setGamesToPlay(){
        Scanner scanner = new Scanner(System.in);
        talker.askForNumberOfGames();
        gamesToPlay = scanner.nextInt();
        scanner.close();
    }

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

    public static void main(String[] args){
        Game game = new Game(new ComputerPlayer(), new AIPlayer());
        game.startGame();
        game.setGamesToPlay();
        game.play();
    }

}