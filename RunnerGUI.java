import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Runner
 * 
 * @author Beckwith and Beth Fineberg
 * @version 1.1
 */
public class RunnerGUI
{
    public static void main(String[] args)
    {
        //the JFrame size:
        int windowWidth = 1000;
        int windowHeight = 700;

        final int DELAY = 220;  //speed of graphics, lower number = faster
                          //(actually, the number of milliseconds between updates to graphics)
                         
        //the display panel size within the JFrame:
        int displaySize = 600;

        int GRID_SIZE = 11;  //makes an nxn gridof squares within the 600 x 600 display
        //YOU COULD ASK THE USER WHAT SIZE GRID THEY WANT!!!
        
        int middleX = GRID_SIZE / 2;  //starting point for objects
        int middleY = GRID_SIZE / 2;
        
        //size of 1 object or 1 blank square:
        int squareSize = displaySize / GRID_SIZE; 
        
        //makes ArrayLists for needed objects:
        ArrayList<SentientBeing> sentientBeings = new ArrayList<SentientBeing>();
        ArrayList<InanimateObject> inanimateObjects = new ArrayList<InanimateObject>();
        
        //make Frame
        Window win = new Window(windowWidth, windowHeight, 
                                GRID_SIZE, 
                                sentientBeings, inanimateObjects,
                                DELAY);
        
        //creates objects to be drawn
        win.populate(10);

        //begin animation
        win.startTimer();
    }
}