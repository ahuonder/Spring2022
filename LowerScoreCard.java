package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/** holds all the lines in the lower section of the scorecard*/
public class LowerScoreCard {
    private ArrayList<ScoreLine> lowerLines = new ArrayList<>();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public LowerScoreCard()
    {
        //3K,4K,FH,SS,LS,YE,CH
        lowerLines.add(new ThreeKindLine());
        lowerLines.add(new FourKindLine());
        lowerLines.add(new FullHouseLine());
        lowerLines.add(new SmallStraightLine());
        lowerLines.add(new LargeStraightLine());
        lowerLines.add(new YahtzeeLine());
        lowerLines.add(new ChanceLine());
    }

    /** gives the hand to all the lower score lines */
    public void findLowerScores(AllDie hand)
    {
        for (int i = 0; i < lowerLines.size(); i++)
        {
            lowerLines.get(i).giveHand(hand);
        }
    }

    /** passes the menu option selection to all the lower lines */
    public Boolean selectMenuOption(String userInput)
    {
        Boolean valid = false;
        for (int i = 0; i < lowerLines.size(); i++)
        {
            valid |= lowerLines.get(i).userMenuSelect(userInput);
        }
        return valid;
    }

    /** finds the total of all the lines in lower scorecard*/
    public int calcTotal()
    {
        int total = 0;
        for (int i = 0; i < 7; i++)
        {
            total += lowerLines.get(i).getScore();
        }
        return total;
    }

    @Override
    public String toString()
    {
        String ret = "";

        for (int i = 0; i < lowerLines.size(); i++)
        {
            ret += lowerLines.get(i).toString() + "\n";
        }

        return ret;
    }

    public ArrayList<ScoreLine> getLines()
    {
        return lowerLines;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
}
