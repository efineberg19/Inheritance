import java.awt.Color;
import java.awt.*;

/**
 * Creates any object
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class AnyThing
{
    int xLoc, yLoc;
    boolean hidden;
    Color color;
    int numMoves;
    int squareSize;
    boolean moving = true;
    String randomID;
    String name;

    /**
     * Constructor for objects of class AnyThing
     */
    public AnyThing(int x, int y, Color c, int ss)
    {
        xLoc = x;
        yLoc = y;
        color = c;
        squareSize = ss;
        randomID = (char)((int)(Math.random() * 6000)) + "";
    }

    /**
     * Constructor for objects of class AnyThing
     */
    public AnyThing()
    {
        xLoc = 10;
        yLoc = 10;
        color = Color.RED;
        squareSize = 600/11;
        randomID = (char)((int)(Math.random() * 6000)) + "";
    }
    
    /**
     * Changes x and y loc of object
     * 
     * @param int x x-location of object
     * @param int y y-location of object
     */
    public void changeLoc(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Allows objects to move around.
     * 
     * @param int moveCode dictates which situation to follow
     */
    public void move(int moveCode)
    {
        numMoves++;

        switch(moveCode)
        {
            case 0: //move right
            xLoc++;
            break;

            case 1: //move diag up right
            xLoc++;
            yLoc--;
            break;

            case 2: //move up
            yLoc--;
            break;

            case 3: //move diag left up
            xLoc--;
            yLoc--;
            break;

            case 4: //move left
            xLoc--;
            break;

            case 5: //move diag down left
            xLoc--;
            yLoc++;
            break;

            case 6: //move down
            yLoc++;
            break;

            case 7: //move diag down right
            xLoc++;
            yLoc++;

            default:
            numMoves--;
            break;
        }
    }

    /**
     * Draws objects
     * 
     * @param Graphics g draws object
     */
    public void draw(Graphics g)
    {
        g.setColor(color);   //sets the color of this object before drawing

        final int SHIFT = 20;  //shifts right and down to match where grid is positioned
        //location of this object on grid:
        int x =  (int)(600/11 * xLoc) + SHIFT;  
        int y =  (int)(600/11 * yLoc) + SHIFT;

        //draw the rabbit square:
        g.fillRect(x, y, squareSize, squareSize);  //rectangle with equal w and h is a square located at (x,y)
    }
    
    /**
     * Checks if two objects are the same. I create a random ID from ASCII values, this is
     * to differeniate objects that are the same in all other ways.
     * 
     * @param AnyThing t object to compare to
     * @return boolean true or false depending on equality
     */
    public boolean equals(AnyThing t)
    {
        if (xLoc == t.xLoc && yLoc == t.yLoc && numMoves == t.numMoves 
            && randomID.equals(t.randomID))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
