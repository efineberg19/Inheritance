import java.awt.Color;
/**
 * Creates inanimate objects
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class InanimateObject extends AnyThing
{
    boolean isPlantBased;

    /**
     * Constructor for objects of class InanimateObject
     */
    public InanimateObject(int x, int y, Color c)
    {
        super(x, y, c, 600/11);
    }
    
    /**
     * Constructor for objects of class InanimateObject
     */
    public InanimateObject()
    {
        super(10, 10, Color.YELLOW, 600/11);
    }
    
    /**
     * Places object in random location
     */
    public void randomLocation()
    {
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        changeLoc(x, y);
    }
}
