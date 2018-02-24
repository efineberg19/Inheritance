import java.awt.Color;
/**
 * Creates a tree
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class Tree extends InanimateObject
{
    int healthLevel, height;
    
    /**
     * Constructor for objects of class Rock
     */
    public Tree(int x, int y, Color c, boolean plantBased, int hL, int h)
    {
        super (x, y, c);
        int heathLevel = hL;
        int height = h;
        super.isPlantBased = true;
    }
    
    /**
     * Constructor for objects of class Rock
     */
    public Tree()
    {
        super(10, 10, Color.GREEN);
        healthLevel = 100;
        height = 10;
        super.isPlantBased = true;
    }
}
