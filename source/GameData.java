import java.util.HashMap;

public class GameData{

    // wins, losses, draws
    private static HashMap<String, Integer> results = new HashMap<>();
    // rocks, papers, scissors counts
    private static HashMap<String, Integer> opponentsMoves = new HashMap<>();

    // String to Index mapping 
    private HashMap<String, Integer> map = new HashMap<>();

    // total moves made by opponent
    static int totalMoves;

    /*          
    *           Rock     Paper   Scissors   Lizard  Spock
    * Rock      Tie      Loss    Win        Win     Loss
    * Paper     Win      Tie     Loss       Loss    Win
    * Scisors   Loss     Win     Tie        Win     Loss
    * Lizard    Loss     Win     Loss       Tie     Win
    * Spock     Win      Loss    Win        Loss    Tie
    */
    private final String[][] possible_moves = {
        {"Tie", "Loss", "Win", "Win", "Loss"},
        {"Win", "Tie", "Loss", "Loss", "Win"},
        {"Loss", "Win", "Tie", "Win", "Loss"},
        {"Loss", "Win", "Loss", "Tie", "Win"},
        {"Win", "Loss", "Win", "Loss", "Tie"}
    };

    GameData(){
        results.put("Win", 0);
        results.put("Loss", 0);
        results.put("Tie", 0);
        opponentsMoves.put("r", 0);
        opponentsMoves.put("p", 0);
        opponentsMoves.put("s", 0);
        opponentsMoves.put("l", 0);
        opponentsMoves.put("k", 0);
        map.put("r", 0);
        map.put("p", 1);
        map.put("s", 2);
        map.put("l", 3);
        map.put("k", 4);
        totalMoves = 0;
    }

    public void updateResults(Player p1, Player p2){
        int row = map.get( p1.getMove() );
        int col = map.get( p2.getMove() );
        this.updateResults( possible_moves[row][col] );
    }

    public void updateResults(String result){
        results.put(result, results.get(result) + 1);
    }

    public void updateMoves(Player player){
        this.updateMoves( player.getMove() );
    }

    public void updateMoves(String move){
        opponentsMoves.put(move, opponentsMoves.get(move) + 1);
        totalMoves++;
    }

    public String getResults(){
        StringBuilder sb = new StringBuilder();
        for(String key : results.keySet() ){
            sb.append( key ).append(":\t").append( results.get( key ) )
            .append("\n");
        }
        return sb.toString();
    }

    public String getMoves(){
        StringBuilder sb = new StringBuilder();
        for(String key : opponentsMoves.keySet() ){
            sb.append( key ).append(":\t").append( opponentsMoves.get( key ) )
            .append("\n");
        }
        return sb.toString();
    }

    public static HashMap<String, Integer> getOpponentsHistory(){
        return opponentsMoves;
    }
}