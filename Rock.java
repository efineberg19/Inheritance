import java.awt.Color;

/**
 * Creates a rock
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class Rock extends InanimateObject
{
    int weight;
    boolean rolling;

    /**
     * Constructor for objects of class Rock
     */
    public Rock(int x, int y, Color c, boolean plantBased, int w, boolean r)
    {
        super (x, y, c);
        weight = w;
        rolling = r;
        super.isPlantBased = false;
    }
    
    /**
     * Constructor for objects of class Rock
     */
    public Rock()
    {
        super(20, 20, Color.GRAY);
        weight = 10;
        rolling = true;
        super.isPlantBased = false;
    }
    
    /**
     * Increases slope so ball speeds up
     * 
     * int amt amount of slope increase
     */
    public void increaseSlope(int amt)
    {
        rolling = true;
    }
    
    /**
     * Determines if a ball is heavy based upon its weight
     * 
     * @return boolean true or false if its heavy or not
     */
    public boolean isHeavy()
    {
        if (weight > 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
