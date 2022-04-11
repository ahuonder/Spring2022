package edu.gonzaga;

/** holds the Full house line in scorecard */
public class FullHouseLine extends ScoreLine
{
    public FullHouseLine()
    {
        this.name = "Full House";
        this.menuOption = "FH";
    }

    /** calcs the full house line possible score */
    @Override
    void calcScore(Integer[] diceFaces)
    {
        int overIdx = -1;
        //int underIdx = 0;
        for (int i = 0; i < diceFaces.length; i++)
        {
            if (diceFaces[i] >= 3)
            {
                overIdx = i;
                break;
            }
        }
        if (overIdx == -1)
        {
            possibleScore = 0;
            return;
        }
        else
        {
            for (int i = 0; i < diceFaces.length; i++)
            {
                if (diceFaces[i] >= 2 && i != overIdx)
                {
                    possibleScore = 25;
                    return;
                }
            }
        }
        possibleScore = 0;
    }
}
