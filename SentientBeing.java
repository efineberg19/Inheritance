import java.awt.Color;

/**
 * Write a description of class SentientBeing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SentientBeing extends AnyThing
{
    int healthLevel;
    String name;

    //I used a random name generator
    String[] randomNames = {"Naveen", "Kyler", "Xun", "Tomatoa", "Draga", "Aleta", "Dinesh",
            "Ile", "Anne", "Dagrun", "Morta", "Crispinus", "Bandile", "Mair", "Rasim", "Linda",
            "Aziz", "Arleen", "Gull", "Arachne", "Hibiki", "Olavi", "Artemio", "Teboho", "Moran"};

    /**
     * Constructor for objects of class SentientBeing
     */
    public SentientBeing(int x, int y, Color c, int health, String n)
    {
        super(x, y, c, 600/11);
        healthLevel = health;
        name = n;
    }

    /**
     * Constructor for objects of class SentientBeing
     */
    public SentientBeing()
    {
        super();
        healthLevel = 100;
        int randomNumber = (int)(Math.random() * (randomNames.length - 1));
        name = randomNames[randomNumber];
    }

    /**
     * Allows object to speak
     * 
     * @return String what object says
     */
    public String speak()
    {
        return name + " says: " + "";
    }

    /**
     * Determines if two sentient beings are equal based on color and name
     * 
     * @param SentientBeing sB object to compare to
     * @return boolean if objects are equal or not
     */
    public boolean equals(SentientBeing sB)
    {
        if (this.name == sB.name && this.color == sB.color)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Allows user to print info about object
     * 
     * @return String info about object
     */
    @Override
    public String toString()
    {
        return name + "has a health level of " + healthLevel + "and is the color " + color;
    }

    /**
     * Allows user to change name of object
     * 
     * @param String s new name of object
     */
    public void setName(String s)
    {
        name = s;
    }

    /**
     * Allows user to have name randomly selected for object
     * 
     */
    public void setNameRandom()
    {
        int randomNumber = (int)(Math.random() * (randomNames.length - 1));
        name = randomNames[randomNumber];
    }

    /**
     * Allows user to access object's name
     * 
     * @return String name of object
     */
    public String getName()
    {
        return name;
    }

    /**
     * Reduces to health level of the object
     */
    public void reduceHealth()
    {
        healthLevel--;
    }

    /**
     * Allows user to access the object's health level
     * 
     * @return int health level
     */
    public int getHealth()
    {
        return healthLevel;
    }
}
