package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/** holds all the necessary numeric score lines in the upper part of the scorecard */
public class UpperScoreCard
{
    private ArrayList<ScoreLine> upperLines = new ArrayList<>();
    private Integer subTotal = 0;
    private Integer total = 0;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public UpperScoreCard(Integer numSides)
    {
        for (int i = 1; i <= numSides; i++)
        {
            upperLines.add(new NumericScoreLine(i));
        }
    }

    /** finds the possible score for the upper part of the scorecard */
    public void findUpperScores(AllDie hand) {
        for (int i = 0; i < hand.getDice().get(0).getNumSides(); i++)
        {
            upperLines.get(i).giveHand(hand);
        }
    }

    /** passes user input to all the lines in the upper section*/
    public Boolean selectMenuOption(String userInput)
    {
        Boolean valid = false;
        for (int i = 0; i < upperLines.size(); i++)
        {
            valid |= upperLines.get(i).userMenuSelect(userInput);
        }
        return valid;
    }

    /** finds the total score of all the lines*/
    public int calcTotal()
    {
        int total = 0;
        for (int i = 0; i < upperLines.size(); i++)
        {
            total += upperLines.get(i).getScore();
        }
        return total;
    }

    @Override
    public String toString()
    {
        String ret = "";

        for (int i = 0; i < upperLines.size(); i++)
        {
            ret += upperLines.get(i).toString() + "\n";
        }

        return ret;
    }

    public ArrayList<ScoreLine> getLines()
    {
        return upperLines;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
}
