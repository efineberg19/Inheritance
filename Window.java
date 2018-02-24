import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Provides a window for buttons, entry boxes and displaying of grahpics. 
 * If I had more time, I would add coin and food objects. If an object
 * goes in the same square as them, their hunger level or gold will 
 * change and be displayed.
 * 
 * @author Beckwith & Beth Fineberg
 * @version 1.2.0
 */
public class Window extends JFrame implements ActionListener
{
    final int TIMER_DELAY;  //milliseconds for updating graphics/motion
    Timer t;

    //components and objects:
    JButton stop, start, explanation;
    JPanel topPanel, displayPanel, sidePanel;
    JTextArea side;
    JTextField info;
    Display display;
    public ArrayList<SentientBeing> sentientBeings;
    public ArrayList<InanimateObject> inanimateObjects;
    JScrollPane outputScroll;

    int numSquaresAcross;
    //size of window:
    int WIDTH;
    int HEIGHT;
    
    String yourName = JOptionPane.showInputDialog("What is your name?");
    
    String displayText = "Welcome " + yourName + "!";

    /**
     * Constructor for Window
     */
    public Window(int width, int height, int numSquaresAcross, ArrayList<SentientBeing> sB, 
        ArrayList<InanimateObject> iO, int delay)
    {
        //in case you're wondering: this calls the constructor of the "super class", which
        //   is JFrame.  That constructor takes the titlebar name as an argument:
        super("Inheritance");
        TIMER_DELAY = delay;

        //save instance variables:
        WIDTH = width;
        HEIGHT = height;
        this.numSquaresAcross = numSquaresAcross;
        sentientBeings = sB;
        inanimateObjects = iO;

        //this allows me to place things where I want them (see this.add below)
        this.setLayout(new BorderLayout());

        //button to pause game
        stop = new JButton("Pause");
        stop.addActionListener(this);
        stop.setActionCommand("pause");
        
        //button to start game
        start = new JButton("Resume");
        start.addActionListener(this);
        start.setActionCommand("resume");
        
        //button to show explanation
        explanation = new JButton("Explanation");
        explanation.addActionListener(this);
        explanation.setActionCommand("explanation");

        //panel for buttons and textfields:
        topPanel = new JPanel();
        topPanel.add(stop);
        topPanel.add(start);
        topPanel.add(explanation);
        
        //text area to display stats
        side = new JTextArea(displayText, 50 , 30);  
        side.setForeground(Color.BLACK);
        side.setEditable(false);
        side.setLineWrap(true);
        side.setWrapStyleWord(true);

        //make a display object that will show board and motion:
        display = new Display(sentientBeings, inanimateObjects, WIDTH, HEIGHT, numSquaresAcross);

        sidePanel = new JPanel();
        outputScroll = new JScrollPane(side);
        sidePanel.add(outputScroll);

        //add the display to this JFrame:
        this.add(topPanel, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

        //final setup
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Creates a Timer object and starts timer
     */
    public void startTimer()
    {
        t = new Timer(TIMER_DELAY ,this); 
        t.setActionCommand("timerFired");
        t.start();
    }

    /**
     * Called automatically when a button is pressed
     * @param e this contains information about the button that was pressed and is send automatically
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("pause"))  //button has been pressed
        {
            t.stop();
        }
        if(e.getActionCommand().equals("resume"))  //button has been pressed
        {
            startTimer();
        }
        if(e.getActionCommand().equals("explanation"))  //button has been pressed
        {
            JOptionPane.showMessageDialog(null, "There are Humans (red), Goblins (blue), " + 
                "Vampires (black), Elfs (orange), Rocks (gray), and Trees (green). \n" +
                "Rocks and trees are stationary. \nIf a human or elf collides with a goblin or vampire " +
                "they will lose health points. \nOccasionally, the elfs, humans, goblins, or vampires " +
                "will say things. \nThe pink square is a castle that no one can enter.");
        }
        if(e.getActionCommand().equals("timerFired"))  //timer has fired
        {
            updateAll();            //does all motion and checking and logic (see below)
            display.repaint();      //calls paintComponent to redraw everything
        }
    }

    /**
     * Creates ArrayList of different types of objects
     * 
     * @param int k number of objects wanted in ArrayList
     */
    public void populate(int k)
    {
        for (int i = 0; i < k; i++)
        {
            int n = (int)(Math.random() * 4);

            //randomly selects which type of SentientBeing to randomly create
            switch(n)
            {
                case 0: 
                AIPlayer aP = new AIPlayer();
                aP.setNameRandom();
                sentientBeings.add(aP);
                break;

                case 1:
                Goblin g = new Goblin();
                g.setNameRandom();
                sentientBeings.add(g);
                break; 
                
                case 2:
                Elf e = new Elf();
                e.setNameRandom();
                sentientBeings.add(e);
                break;
                
                case 3:
                Vampire v = new Vampire();
                v.setNameRandom();
                sentientBeings.add(v);
                break;
            }
        }
        
        //randomly selects which type of InanimateObject to randomly create
        for (int i = 0; i < k; i++)
        {
            int n = (int)(Math.random() * 2);
            switch(n)
            {
                case 0:
                Rock r = new Rock();
                inanimateObjects.add(r);
                r.randomLocation();
                break;
                
                case 1:
                Tree t = new Tree();
                inanimateObjects.add(t);
                t.randomLocation();
                break;
            }
        }
    }

    /**
     * Called by the timer.
     * Do all altering of bunnies, etc. here, since this is followed by a repaint of everything
     */
    public void updateAll()
    {
        for (SentientBeing s : sentientBeings)
        {
            //allows objects to move
            int moveCode = (int)(Math.random() * 8);
            s.move(moveCode);   
            
            //if off an edge, recenter:
            if(s.xLoc < 0 || s.yLoc < 0  //left or top
            || s.xLoc >= numSquaresAcross    //right
            || s.yLoc >= numSquaresAcross)  //bottom
            {
                s.xLoc = numSquaresAcross / 2;  //center coordinates
                s.yLoc = numSquaresAcross / 2;
            }
            //DO ALL OTHER LOGIC HERE: MAYBE CHECKING OTHER BUNNIES OR FOR COLLISION, ETC.

            if(s.xLoc < 0 || s.xLoc >= numSquaresAcross) s.xLoc = numSquaresAcross / 2;
            if(s.yLoc < 0 || s.yLoc >= numSquaresAcross) s.yLoc = numSquaresAcross / 2;
            
            for (int i = 9; i > 0; i--)
            {
                //if AIPlayer or Elf is in the same square as a Vampire or Goblin, health lost
                if (s.xLoc == sentientBeings.get(i).xLoc && s.yLoc == sentientBeings.get(i).yLoc
                && s.equals(sentientBeings.get(i)) == false)
                {
                    if((sentientBeings.get(i) instanceof Goblin || sentientBeings.get(i) instanceof Vampire) 
                        && s instanceof AIPlayer || s instanceof Elf)
                    {
                        s.reduceHealth();
                        show(s.getName()  + "'s health: " + s.getHealth());
                    }
                }
            }
            
            int randomSpeak = (int)(Math.random() * 1000) + 1;
            
            //will occasionally have SentientBeings say things
            if (s.numMoves % randomSpeak == 13)
            {
                show(s.speak());
            }
            
            /*
             * If SentientBeing runs out of health, it says they are dead. Their ghosts will 
             * still play with negative health.
             */
            if(s.getHealth() == 0)
            {
                show(s.getName() + " has died. RIP.");
            }
        }
    }
    
    /**
     * Adds text to side panel
     * 
     * @param String t text to display
     */
    public void show(String t)
    {
        displayText += "\n" + t;

        side.setText(displayText);
    }
}

