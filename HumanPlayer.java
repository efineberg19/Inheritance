import java.awt.Color;
/**
 * Creates a human player
 *
 * @author Beth Finebegr
 * @version 1.0
 */
public class HumanPlayer extends SentientBeing
{
    int intelligenceLevel, hungerLevel, gold;

    /**
     * Constructor for objects of class HumanPlayer
     */
    public HumanPlayer(int x, int y, Color c, int health, String n, int iQ, 
        int hunger, int aU)
    {
        super(x, y, c, health, n);
        intelligenceLevel = iQ;
        hungerLevel = hunger;
        gold = aU;
    }
    
    /**
     * Constructor for objects of class HumanPlayer
     */
    public HumanPlayer()
    {
        super(10, 10, Color.RED, 100, "name");
        intelligenceLevel = 50;
        hungerLevel = 100;
        gold = 20;
    }
    
    /**
     * Allows human to say random phrases
     * 
     * @return String phrase to speak
     */
    @Override
    public String speak()
    {
        String[] randomPhrases = {"As a child, was your cradle rocked too close to the wall?",
            "I want more detailed information.", "I stepped on a Corn Flake, now I'm a Cereal Killer",
            "A song can make or ruin a person’s day if they let it get to them.",
            "Where do random thoughts come from?", "Love is a friend to none.",
            "Without thought there can be no upbringings.", "A dollar can make you stay young."};
            
        int n = (int)(Math.random() * (randomPhrases.length - 1));
        
        return "Hi, I'm " + name + " and I'm a human. " + randomPhrases[n]; 
    }
    
    /**
     * Allows human to eat food and lower hunger level 
     */
    public void eatFood()
    {
        hungerLevel--;
    }
}
