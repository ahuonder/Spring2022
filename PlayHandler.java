package edu.gonzaga;

import java.io.*;
import java.util.Scanner;

/** class has multiple functions that handle main play functionality */
public class PlayHandler {
    private Integer sides;
    private Integer numDie;
    private Integer turns;

    public PlayHandler()
    {
        this.sides = 0;
        this.numDie = 0;
        this.turns = 0;
    }

    /** handles the file IO used for the settings of the game */
    public void configureSettings() throws IOException {
        String filePath = System.getProperty("user.dir");

        File file = new File(filePath + "\\yahtzeeConfig.txt");

        Scanner settings = new Scanner(file); //sides, dice, turns
        Scanner kb = new Scanner(System.in);
        String response = "";

        sides = settings.nextInt();
        numDie = settings.nextInt();
        turns = settings.nextInt();

        //must ask for different values and write them out to the file
        System.out.println("You have " + numDie + " dice with " + sides + " sides each, and " + turns + " turns.\nWould you like to change these? (y for yes. n for no.)");
        response = kb.nextLine();
        if (response.equals("y") || response.equals("Y"))
        {
            System.out.println("Enter desired number sides.");
            sides = kb.nextInt();
            System.out.println("Enter desired number of dice.");
            numDie = kb.nextInt();
            System.out.println("Enter desired number of turns.");
            turns = kb.nextInt();
            //write to the file
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(sides + "\n" + numDie + "\n" + turns);
            out.close();
        }
    }

    /** handles the rolling and scoring of the game */
    public void playGame()
    {
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to Yahtzee.\nYou have " + numDie + " dice with " + sides + " sides each, and " + turns + " turns.\nPress Enter to start your roll.");
        kb.nextLine();

        AllDie hand = new AllDie(numDie, sides);
        ScoreCard card = new ScoreCard(sides);

        for (int i = 0; i < sides + 7; i++) {
            this.playTurn(card, hand);
        }
        this.outputFinalScoring(card);
        System.out.println("Nice job. Goodbye!");
    }

    /** plays a round of yahtzee ie 3 rolls and pick a line to score */
    public void playTurn(ScoreCard card, AllDie hand)
    {
        String rollSelect = "";
        Scanner kb = new Scanner(System.in);

        for (int i = 0; i < turns; i++) {
            if (i == 0)
                // roll all and do not give user a choice
                hand.rollAll();
            else {
                //give user choice
                System.out.println("Which dice would you like to roll again? Use 'y' and 'n' (entering 'y' will roll its respective die)");
                rollSelect = kb.nextLine();
                hand.rollSelection(rollSelect);
            }
            //output after roll here
            System.out.println("You rolled: " + hand + "\nYou have " + (turns - (i + 1)) + " turns left.");
        }
        //end of turn stuff
        hand.sortDie();
        System.out.println("In sorted order, you rolled: " + hand.toString());
        System.out.println("Press enter to continue to scoring.");
        kb.nextLine();

        card.calculatePossibleScores(hand);
        System.out.println(card + "\nSelect what line you would like to fill with its possible score.");
        while(!card.selectMenuOption(kb.nextLine()))
        {
            System.out.println("Incorrect input. Try again.");
        }
    }

    /** outputs the full scoring of the scorecard */
    public void outputFinalScoring(ScoreCard card)
    {
        System.out.println("Nice Game! Your final scores will be displayed below.\n");
        card.finalScore();
    }

    /** getter for the sides member variable */
    public Integer getSides() {
        return sides;
    }

    /** setter for the sides member variable */
    public void setSides(Integer sides) {
        this.sides = sides;
    }

    /** getter for the numDie member variable */
    public Integer getNumDie() {
        return numDie;
    }

    /** setter for the numDie member variable */
    public void setNumDie(Integer numDie) {
        this.numDie = numDie;
    }

    /** getter for the turns member variable */
    public Integer getTurns() {
        return turns;
    }

    /** setter for the turns member variable */
    public void setTurns(Integer turns) {
        this.turns = turns;
    }
}

