package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** holds the numeric score lines in scorecard*/
public class NumericScoreLine extends ScoreLine
{
    Integer myNumber;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public NumericScoreLine(Integer myNumber)
    {
        this.name = myNumber + "s";
        this.menuOption = myNumber + "S";
        this.myNumber = myNumber;
    }

    /** calcs the score given any myNumber value */
    @Override
    public void calcScore(Integer[] diceFaces)
    {
        possibleScore = diceFaces[myNumber - 1] * myNumber;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
}
