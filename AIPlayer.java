import java.awt.Color;
/**
 * Creates AIPlater
 *
 * @author Beth Finebegr
 * @version 1.0
 */
public class AIPlayer extends HumanPlayer
{
    /**
     * Constructor for objects of class AIPlayer
     */
    public AIPlayer(int x, int y, Color c, int health, String n, int iQ, 
        int hunger, int aU)
    {
        super(x, y, c, health, n, iQ, hunger, aU);
    }
    
    /**
     * Constructor for objects of class AIPlayer
     */
    public AIPlayer()
    {
        super(10, 10, Color.RED, 100, "", 100, 0, 10);
        setNameRandom();
    }
}
