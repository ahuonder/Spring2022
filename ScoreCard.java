package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** handles the scoring in yahtzee */
public class ScoreCard
{
    private UpperScoreCard upperCard;
    private LowerScoreCard lowerCard;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public ScoreCard(Integer numSides)
    {
        upperCard = new UpperScoreCard(numSides);
        lowerCard = new LowerScoreCard();
    }

    /** passes the hand to the upper and lower scorecards*/
    public void calculatePossibleScores(AllDie hand)
    {
        upperCard.findUpperScores(hand);
        lowerCard.findLowerScores(hand);
    }

    /** passes the uer input down to the 2 sections of the card*/
    public Boolean selectMenuOption(String userInput)
    {
        if (upperCard.selectMenuOption(userInput))
        {
            return true;
        }
        else if (lowerCard.selectMenuOption(userInput))
        {
            return true;
        }
        else
            return false;
    }

    /** outputs final score of the game and calcs a bonus*/
    public void finalScore()
    {
        int bonus = 0;
        if (upperCard.calcTotal() >= 63)
            bonus = 35;

        System.out.println("Your upper line total was " + upperCard.calcTotal());
        System.out.println("You were awarded a bonus of " + bonus + " for a total of " + (bonus + upperCard.calcTotal()));
        System.out.println("Your lower line total was " + lowerCard.calcTotal());
        System.out.println("Your total score was " + (upperCard.calcTotal() + lowerCard.calcTotal() + bonus) + "!");
    }

    @Override
    public String toString()
    {
        String ret = "";
        ret += upperCard.toString();
        ret += lowerCard.toString();
        return ret;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public UpperScoreCard getUpperCard() {
        return upperCard;
    }

    public LowerScoreCard getLowerCard() {
        return lowerCard;
    }
}
