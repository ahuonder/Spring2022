package edu.gonzaga;

/** holds the Four of a kind line in scorecard*/
public class FourKindLine extends ScoreLine
{
    public FourKindLine()
    {
        this.name = "Four of a Kind";
        this.menuOption = "4K";
    }

    /** calcs the 4 of a kind possible score */
    @Override
    void calcScore(Integer[] diceFaces)
    {
        for (int i = 0; i < diceFaces.length; i++)
        {
            if (diceFaces[i] >= 4)
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
