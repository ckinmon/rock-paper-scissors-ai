import java.util.HashMap;

/**
 * 
 */
public abstract class Player{

    protected final String[] moves = {"r", "p", "s", "l", "k"};
    
    public abstract String getMove();
    public abstract void computeMove();

}