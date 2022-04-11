package edu.gonzaga;

/** holds the small straight line in scorecard */
public class SmallStraightLine extends ScoreLine
{
    public SmallStraightLine()
    {
        this.name = "Small Straight";
        this.menuOption = "SS";
    }

    /** calcs the possible score for the small straight line*/
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
            if (consecutive >= 4)
            {
                possibleScore = 30;
                return;
            }
        }
        possibleScore = 0;
    }
}
