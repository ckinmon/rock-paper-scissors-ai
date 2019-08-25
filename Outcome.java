import java.util.HashMap;

public class Outcome{

    private String result = new String();
    private HashMap<String, Integer> map = new HashMap<>();
    private GameData gameData;

    private final String[][] outcomes = {

        {"Tie! Rock ties with Rock.", "Loss! Rock loses to Paper.", "Win! Rock beats Scissors.", "Win! Rock beats Lizard.", "Loss! Rock loses to Spock."},
        {"Win! Paper beats Rock.", "Tie! Paper ties with Paper.", "Loss! Paper loses to Scissors.", "Loss! Paper loses to Lizard.", "Win! Paper beats Spock."},
        {"Loss! Scissors loses to Rock.", "Win! Scissors beats Paper.", "Tie! Scissors ties with Scissors.", "Win! Scissors beats Lizard.", "Loss! Scissors loses to Spock."},
        {"Loss! Lizard loses to Rock.", "Win! Lizard beats Paper.", "Loss! Lizard loses to Scissors.", "Tie! Lizard ties with Lizard.", "Win! Lizard beats Spock."},
        {"Win! Spock beats Rock.", "Loss! Spock loses to Paper.", "Win! Spock beats Scissors.", "Loss! Spock loses to Lizard.", "Tie! Spock ties with Spock."}

    };

    Outcome(){
        gameData = new GameData();
        map.put("r", 0);
        map.put("p", 1);
        map.put("s", 2);
        map.put("l", 3);
        map.put("k", 4);
    }

    public void computeOutcome(Player p1, Player p2){
        gameData.updateResults(p1, p2);
        gameData.updateMoves(p2);
        int row = map.get( p1.getMove() );
        int col = map.get( p2.getMove() );
        result = outcomes[row][col];
    }

    public String getOutcome(){
        return result;
    }

}