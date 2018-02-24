import java.awt.Color;
/**
 * Allows user to create Goblins
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class Goblin extends SentientBeing
{
    int intelligenceLevel;

    /**
     * Constructor for objects of class Goblin
     */
    public Goblin(int x, int y, Color c, int health, String n, int iQ)
    {
        super(x, y, c, health, n);
        intelligenceLevel = iQ;
    }

    /**
     * Constructor for objects of class Goblin
     */
    public Goblin()
    {
        super(10, 10, Color.BLUE, 100, "");
        setNameRandom();
        intelligenceLevel = 2;
    }

    /**
     * Allows goblin to move double what other objects would move
     */
    public void move()
    {
        int moveCode = (int)(Math.random() * 8);
        move(moveCode); 
        move(moveCode); 
    }

    /**
     * Allows Goblin to speak random phrases
     * 
     * @return String what the goblin says
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

        return "A goblin named " + name + " says: " + randomPhrases[n]; //add something to make it different
    }
}
