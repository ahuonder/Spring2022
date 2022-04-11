package edu.gonzaga;

import java.util.ArrayList;
/** holds the three of a kind line in scorecard */
public class ThreeKindLine extends ScoreLine
{
    public ThreeKindLine()
    {
        this.name = "Three of a Kind";
        this.menuOption = "3K";
    }

    /** calcs the possible score for the 3K line*/
    @Override
    void calcScore(Integer[] diceFaces)
    {
        for (int i = 0; i < diceFaces.length; i++)
        {
            if (diceFaces[i] >= 3)
            {
                Integer total = 0;
                for (int j = 0; j < diceFaces.length; j++)
                {
                    total += diceFaces[j] * (j+1);
                }
                possibleScore = total;
                return;
            }
        }
        possibleScore = 0;
    }
}
