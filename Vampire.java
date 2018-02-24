import java.awt.Color;
/**
 * Creates vampires
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class Vampire extends SentientBeing
{
    int intelligenceLevel;
    int bloodThirst;
    
    /**
     * Constructor for objects of class Vampire
     */
    public Vampire(int x, int y, Color c, int health, String n, int iQ, int bT)
    {
        super(x, y, c, health, n);
        intelligenceLevel = iQ;
        bloodThirst = bT;
    }
    
    /**
     * Constructor for objects of class Vampire
     */
    public Vampire()
    {
        super(10, 10, Color.BLACK, 100, "");
        setNameRandom();
        intelligenceLevel = 2;
        bloodThirst = 50;
    }

    /**
     * Allows Vampire to speak random phrases
     * 
     * @return String what the vampire says
     */
    @Override
    public String speak()
    {
        //I used a random sentences from the internet
        String[] randomPhrases = {"As a child, was your cradle rocked too close to the wall?",
            "I want more detailed information.", "I stepped on a Corn Flake, now I'm a Cereal Killer",
            "A song can make or ruin a person’s day if they let it get to them.",
            "Where do random thoughts come from?", "Love is a friend to none.",
            "Without thought there can be no upbringings.", "A dollar can make you stay young."};
            
        int n = (int)(Math.random() * (randomPhrases.length - 1));
        
        return "An Vampire named " + name + " says: " + randomPhrases[n]; //add something to make it different
    }
}
