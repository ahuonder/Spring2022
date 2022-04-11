package edu.gonzaga;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class UpperScoreCardView implements PropertyChangeListener {
    JPanel myPanel;
    ArrayList<ScoreLineView> lineViews;
    UpperScoreCard upperToView;

    void setupPanel() {
        myPanel = new JPanel();

        // Borders can change the style of widget edges
        Border blackline = BorderFactory.createLineBorder(Color.black);

        // FlowLayout is the default left to right kind of layout
        //myPanel.setLayout(new FlowLayout());

        // Box layout can go vertically
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.setSize(100, 300);
        myPanel.setBorder(blackline);

        setupLineViews();
    }

    void setupLineViews() {
        lineViews = new ArrayList<>();
        ArrayList<ScoreLine> upperLines = upperToView.getLines();

        for( int i = 0; i < 6; i++ ) {
            ScoreLineView newView = new ScoreLineView();
            newView.setLineToView(upperLines.get(i));
            newView.setupPanel();
            lineViews.add(newView);
            myPanel.add(newView.getLinePanel());
        }
    }

    public void setSectionToView(UpperScoreCard card)
    {
        upperToView = card;
        upperToView.addPropertyChangeListener(this::propertyChange);
        addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //toggleLocked();
                        //System.out.println("Button pressed to lock: " + locked);
                    }
                }
        );
    }

    public UpperScoreCardView() {
        //lineViews = new ArrayList<>();

        //setupPanel();
        //setupLineViews();
    }

    public void propertyChange(PropertyChangeEvent e)
    {
        System.out.println("upper ScoreCard view prop change");
        /*
        if(e.getPropertyName().equals("score change " + lineToView.menuOption))
        {
            lineToView.userMenuSelect(lineToView.menuOption);
            score.setText(lineToView.getScore().toString());
            scoreButton.setEnabled(false);
        }
        else if (e.getPropertyName().equals("possible score"))
        {
            possibleScore.setText(lineToView.getPossibleScore().toString());
        }
        */
    }

    public JPanel getPanel() {
        return myPanel;
    }
}
