import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
/**
 * @author Beckwith & Beth Fineberg
 * @version 1.2.0
 */
public class Display extends JPanel
{
    int numSquaresAcross;  
    Font myFont; 
    
    ArrayList<SentientBeing> sentientBeings;
    ArrayList<InanimateObject> inanimateObjects;
    
    //hold objects temporarily
    Stack<SentientBeing> myThings = new Stack();
    
    /**
     * CONSTRUCTOR
     */
    public Display(ArrayList<SentientBeing> sB, ArrayList<InanimateObject> iO, int w, int h, int numSquaresAcross) 
    {
        this.numSquaresAcross = numSquaresAcross;
        sentientBeings = sB;
        inanimateObjects = iO;

        this.myFont = new Font("Verdana", Font.BOLD, 16);  //nice font for display purposes
        setPreferredSize(new Dimension(w, h));  //set size of display       
    }

    /**
     * Draw text, grid, and rabbit; called in Window class by a timer calling repaint()
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g); //clear the old drawings

        //use drawString show any updates or information:
        g.setFont(myFont);

        /*
         * show a pink square in the middle:
         */
        int middle = numSquaresAcross / 2;
        int SHIFT = 20;  //moves all squares down and to the right, so not at edge of display:

        for (int i = 0; i < sentientBeings.size(); i++)
        {
            //draws SentientBeing if it is not hidden
            if (!sentientBeings.get(i).hidden)
            {
                sentientBeings.get(i).draw(g);
            }
        }
        
        for (int i = 0; i < inanimateObjects.size(); i++)
        {
            //draws InanimateObject if it is not hidden
            if (!inanimateObjects.get(i).hidden)
            {
                inanimateObjects.get(i).draw(g);
            }
        }

        for(int i = 1; i < sentientBeings.size(); i++)
        {
            //fillRect(x,y,w,h) draws a recentalge at (x,y) of dimensions w x h:
            g.fillRect(middle * sentientBeings.get(i).squareSize + SHIFT,middle * sentientBeings.get(i).squareSize + SHIFT,
                sentientBeings.get(i).squareSize,sentientBeings.get(i).squareSize);

            //go through field, showing object or empty square:
            for(int col = 0; col < numSquaresAcross; col++)
            {
                for(int row = 0; row < numSquaresAcross; row++)
                {
                    //set location of where to draw current rectangle:
                    int x =  (int)(sentientBeings.get(i).squareSize * col);
                    int y =  (int)(sentientBeings.get(i).squareSize * row);
                    if((row + col) % 2 == 0)//(row % 2 == 0)
                    {
                        g.setColor(Color.PINK);
                    }
                    else  
                    {
                        g.setColor(Color.PINK);
                    }
                    g.drawRect(x + SHIFT , y + SHIFT, sentientBeings.get(i).squareSize, 
                        sentientBeings.get(i).squareSize);
                }
            }
            
            if (sentientBeings.get(i) instanceof Goblin)
            {
                //adds goblin to top of stack for easy access
                myThings.push(new Goblin());
            }
            else if (sentientBeings.get(i) instanceof AIPlayer)
            {
                //adds AIPlayer to top of stack for easy access
                myThings.push(new AIPlayer());
            }
            else if (sentientBeings.get(i) instanceof Vampire)
            {
                //adds Vampire to top of stack for easy access
                myThings.push(new Vampire());
            }
            else if (sentientBeings.get(i) instanceof Elf)
            {
                //adds Elf to top of stack for easy access
                myThings.push(new Elf());
            }
        }
        
        //draws stationary InanimateObjects
        for(int i = 1; i < inanimateObjects.size(); i++)
        {
            g.fillRect(middle * inanimateObjects.get(i).squareSize + SHIFT,middle * inanimateObjects.get(i).squareSize 
                + SHIFT, inanimateObjects.get(i).squareSize,inanimateObjects.get(i).squareSize);
        }
    }
}
