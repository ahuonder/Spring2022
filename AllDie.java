package edu.gonzaga;

import java.util.ArrayList;
import java.util.Comparator;

/** Class to store the state of all the dice. */
public class AllDie {

    private ArrayList<Die> dice = new ArrayList<Die>();
    private Integer numDie;
    private Integer numSides;

    public AllDie(Integer numDie, Integer numSides)
    {
        this.numDie = numDie;
        this.numSides = numSides;

        for (int i = 0; i < numDie; i++) {
            dice.add(new Die(numSides));
        }
    }

    public AllDie(ArrayList<Die> dice) //constructor used for testing
    {
        this.numSides = dice.get(0).getNumSides();
        this.numDie = dice.size();
        this.dice = dice;
    }

    /** Rolls all the die once, getting new random value for each. */
    public void rollAll()
    {
        for (int i = 0; i < numDie; i++)
        {
            dice.get(i).roll();
        }
    }

    /** Rolls each die based on what the user selects, getting new random value for each. */
    public void rollSelection(String selection)
    {
        for (int i = 0; i < numDie; i++)
        {
            if (selection.charAt(i) == 'y' || selection.charAt(i) == 'Y')
                dice.get(i).roll();
        }
    }

    /** getter for the ArrayList<Die> dice member variable */
    public ArrayList<Die> getDice() {
        return dice;
    }

    /** prints each of the dice side up with spaces between each number */
    public String toString()
    {
        String out = "";

        for (int i = 0; i < numDie; i++)
        {
            out += dice.get(i).toString();
            out += " ";
        }

        return out;
    }

    /** Sorts each die by numerical order from least to greatest */
    public void sortDie()
    {
        dice.sort(Die::compareTo);
    }
}
