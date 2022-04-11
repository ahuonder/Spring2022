package edu.gonzaga;

/** holds the yahtzee line in the scorecard */
public class YahtzeeLine extends ScoreLine
{
    public YahtzeeLine()
    {
        this.name = "Yahtzee";
        this.menuOption = "YE";
    }

    /** calcs the possible score for the yahtzee line */
    @Override
    void calcScore(Integer[] diceFaces)
    {
        for (int i = 0; i < diceFaces.length; i++)
        {
            if (diceFaces[i] == 5)
            {
                possibleScore = 100;
                return;
            }
        }
        possibleScore = 0;
    }
}
