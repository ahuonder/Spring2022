package edu.gonzaga;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class ScoreLineView implements PropertyChangeListener {
    ScoreLine lineToView;
    JPanel line;
    JButton scoreButton;
    JLabel menuOption;
    JLabel score;
    JLabel possibleScore;
    //private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public ScoreLineView()
    {
        //this.setupPanel();
    }

    public void setupPanel() {
        line = new JPanel();

        // Borders can change the style of widget edges
        Border blackline = BorderFactory.createLineBorder(Color.black);

        // FlowLayout is the default left to right kind of layout
        line.setLayout(new FlowLayout());

        // Box layout can go vertically
        //line.setLayout(new BoxLayout(line, BoxLayout.PAGE_AXIS));

        line.setSize(100, 20);
        line.setBorder(blackline);

        setupScoreButton();
        setupLabels();
    }

    public void setupScoreButton() {
        scoreButton = new JButton("+");
        //scoreButton.setSize(40,40);
        scoreButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println("Button pressed to roll");
                        //hand.rollAll();
                        //fire score change thing
                        //lineToView.giveHand();
                        System.out.println(lineToView.menuOption + " score button pressed");
                        //System.out.println("prop change title is: " + "score change " + lineToView.menuOption);
                        lineToView.userMenuSelect(lineToView.menuOption);
                    }
                }
        );
        line.add(scoreButton);
    }

    public void setupLabels()
    {
        menuOption = new JLabel();
        score = new JLabel();
        possibleScore = new JLabel();

        menuOption.setText(lineToView.getMenuOption());
        score.setText(lineToView.getScore().toString());
        possibleScore.setText(lineToView.getPossibleScore().toString());

        line.add(menuOption);
        line.add(score);
        line.add(possibleScore);
    }

    public void setLineToView(ScoreLine newLineToView) {
        lineToView = newLineToView;
        lineToView.addPropertyChangeListener(this::propertyChange);
        /*addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("is here?");
                        //toggleLocked();
                        //System.out.println("Button pressed to lock: " + locked);
                    }
                }
        );*/
    }

    public void propertyChange(PropertyChangeEvent e)
    {
        System.out.println("in scoreLineView prop change function");
        if(e.getPropertyName().equals("score change " + lineToView.menuOption))
        {
            System.out.println("top of score change, property change");
            lineToView.userMenuSelect(lineToView.menuOption);
            score.setText(lineToView.getScore().toString());
            scoreButton.setEnabled(false);
            possibleScore.setText("");
        }
        else if (e.getPropertyName().equals("possible score"))
        {
            if(!lineToView.used)
                possibleScore.setText(lineToView.getPossibleScore().toString());
        }
    }

    public JPanel getLinePanel()
    {
        return line;
    }
}
