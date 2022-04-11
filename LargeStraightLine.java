package edu.gonzaga;

/** holds the Large Straight line in scorecard */
public class LargeStraightLine extends ScoreLine
{
    public LargeStraightLine()
    {
        this.name = "Large Straight";
        this.menuOption = "LS";
    }

    /** calcs the Large straight possible score */
    @Override
    void calcScore(Integer[] diceFaces)
    {
        int consecutive = 0;

        for (int i = 0; i < diceFaces.length; i++)
        {

            if (diceFaces[i] != 0)
                consecutive++;
            else
            {
                consecutive = 0;
            }
            if (consecutive >= 5)
            {
                possibleScore = 40;
                return;
            }
        }
        possibleScore = 0;
    }
}
