package edu.gonzaga;

/** holds the chance line in scorecard */
public class ChanceLine extends ScoreLine
{
    public ChanceLine()
    {
        this.name = "Chance";
        menuOption = "CH";
    }

    /** calcs the chance line possible score */
    @Override
    void calcScore(Integer[] diceFaces)
    {
        Integer total = 0;
        for (int i = 0; i < diceFaces.length; i++)
        {
            total += diceFaces[i] * (i+1);
        }
        possibleScore = total;
    }
}
