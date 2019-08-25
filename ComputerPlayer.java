import java.util.Random;

/**
 * 
 */
public class ComputerPlayer extends Player{

    private String move;
    
    @Override
    public void computeMove(){
        Random random = new Random();
        int index = random.nextInt(5);
        move = moves[ index ];
    }

    @Override
    public String getMove(){
        return move;
    }
    
}