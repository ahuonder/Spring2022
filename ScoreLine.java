package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/** has all the main functionality of a scoreline */
public abstract class ScoreLine {
    Boolean used = false;
    Integer possibleScore = 0;
    Integer score = 0;
    String menuOption = "";
    String name = "";
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    /** calls calcscore so the possible score of a line can be calculated */
    public void giveHand(AllDie hand)
    {
        calcScore(assignDiceValues(hand.getDice()));
        this.pcs.firePropertyChange("possible score", 0, possibleScore.intValue());
    }

    /** forces sub classes to have a calcScore */
    abstract void calcScore(Integer[] diceFaces);

    /** handles string input from the user to select it to be scored */
    public Boolean userMenuSelect(String userInput)
    {
        if(!used && userInput.equals(menuOption))
        {
            used = true;
            score = possibleScore;
            System.out.println("before fire in userMenuSelect");
            this.pcs.firePropertyChange("score change " + this.menuOption, 0, 7);
            System.out.println("after fire in userMenuSelect");
            return true;
        }
        else
        {
            return false;
        }
    }

    /** makes an array that records how many dice have a certain face up for easier scoring */
    public Integer[] assignDiceValues(ArrayList<Die> hand)
    {
        Integer[] diceFaceCount = new Integer[hand.get(0).getNumSides()];

        for (int i = 0; i < hand.get(0).getNumSides(); i++)
            diceFaceCount[i] = 0;

        for (int i = 1; i < hand.get(0).getNumSides() + 1; i++)
        {
            for(int j = 0; j < hand.size(); ++j)
            {
                if (hand.get(j).getSideUp() == i)
                {
                    diceFaceCount[i -1] += 1;
                }
            }
        }
        return diceFaceCount;
    }

    @Override
    public String toString()
    {
        String ret;
        if (!used)
            ret = "[" + menuOption + "] - " + name + " | " + score + " || " + possibleScore;
        else
            ret = "[  ]" + " - " + name + " | " + score + " || ";
        return ret;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    /** getter for member variable */
    public Boolean getUsed() {
        return used;
    }
    /** setter for member variable */
    public void setUsed(Boolean used) {
        this.used = used;
    }
    /** getter for member variable */
    public Integer getPossibleScore() {
        return possibleScore;
    }
    /** setter for member variable */
    public void setPossibleScore(Integer possibleScore) {
        this.possibleScore = possibleScore;
    }
    /** getter for member variable */
    public Integer getScore() {
        return score;
    }
    /** setter for member variable */
    public void setScore(Integer score) {
        this.score = score;
    }
    /** getter for member variable */
    public String getMenuOption() {
        return menuOption;
    }
    /** setter for member variable */
    public void setMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }
    /** getter for member variable */
    public String getName() {
        return name;
    }
    /** setter for member variable */
    public void setName(String name) {
        this.name = name;
    }
}
