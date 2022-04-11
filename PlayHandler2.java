package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class PlayHandler2 {
    static GraphicsConfiguration gc;
    JFrame mainWindow;

    AllDie hand;
    AllDieView handView;
    ScoreCard card;
    ScoreCardView scoreCardView;
    ScoreLineView scoreLineView;
    NumericScoreLine scoreLine;

    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee game by Crandall");
        mainWindow.setLayout(new FlowLayout());
        mainWindow.setSize(1200, 700);
        mainWindow.setLocation(50,50);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void startGUI() {
        mainWindow.setVisible(true);
    }

    //TODO: change hard coded stuff later
    void setupHand() {
        hand = new AllDie(5,6);
    }

    void setupHandView() {
        handView = new AllDieView(hand);
    }

    void setupScoreCard()
    {
        scoreCardView = new ScoreCardView();
        card = new ScoreCard(6);
        scoreCardView.setCardToView(card);
        scoreCardView.setupPanel();
        //scoreLineView = new ScoreLineView();
        //scoreLine = new NumericScoreLine(1);
        //scoreLineView.setLineToView(scoreLine);
        //scoreLineView.setupPanel();
    }

    public PlayHandler2() {
        setupHand();
        setupHandView();
        setupScoreCard();
        setupMainWindow();



        DieView dv = new DieView();
        dv.setDieToView(hand.getDice().get(0));

        Die die = hand.getDice().get(0);
        die.roll();



        mainWindow.add(handView.getPanel());
        mainWindow.add(scoreCardView.getPanel());
        //mainWindow.add(scorecardView.getPanel());
        //mainWindow.add(player.get(0).playerView.getPanel());
        //playerView.get(0).getPanel();
        //mainWindow.add(player.get(1).playerView.getPanel());

        startGUI();
    }
}
