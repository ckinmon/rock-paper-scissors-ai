import java.util.HashMap;
import java.util.Random;

public class AIPlayer extends Player{

    private String move = new String();

    @Override
    public void computeMove() {
        String bias = computeOpponentsBias();
        int index;
        if(bias == null){
            Random random = new Random();
            index = random.nextInt(5);
        }else{
            if(bias == "r" || bias == "k") index = 1;
            else if(bias == "p" || bias == "l") index = 2;
            else index = 0;
        }
        move = moves[ index ];
    }

    @Override
    public String getMove() {
        return move;
    }

    private String computeOpponentsBias(){
        HashMap<String, Integer> frequencies = GameData.getOpponentsHistory();
        String target = null;
        for(String key : frequencies.keySet()){
            if( (float) frequencies.get(key) / GameData.totalMoves >= .5) {
                target = key;
            }
        }
        return target;
    }

}