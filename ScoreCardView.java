package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.border.Border;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class ScoreCardView implements PropertyChangeListener {
    JPanel myPanel;
    UpperScoreCardView upperView;
    LowerScoreCardView lowerView;
    ScoreCard cardToView;

    public ScoreCardView()
    {

    }
    void setupPanel() {
        myPanel = new JPanel();

        // Borders can change the style of widget edges
        Border blackline = BorderFactory.createLineBorder(Color.black);

        // FlowLayout is the default left to right kind of layout
        //myPanel.setLayout(new FlowLayout());

        // Box layout can go vertically
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.setSize(100, 600);
        myPanel.setBorder(blackline);

        setupSectionViews();

    }

    void setupSectionViews() {
        upperView = new UpperScoreCardView();
        lowerView = new LowerScoreCardView();

        upperView.setSectionToView(cardToView.getUpperCard());
        upperView.setupPanel();

        lowerView.setSectionToView(cardToView.getLowerCard());
        lowerView.setupPanel();

        myPanel.add(upperView.getPanel());
        myPanel.add(lowerView.getPanel());
    }

    void setCardToView(ScoreCard newCardToView)
    {
        cardToView = newCardToView;
        cardToView.addPropertyChangeListener(this::propertyChange);
        /*addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //toggleLocked();
                        //System.out.println("Button pressed to lock: " + locked);
                    }
                }
        );*/
    }

    public void propertyChange(PropertyChangeEvent e)
    {
        System.out.println("whole ScoreCard view prop change");
    }

    public JPanel getPanel()
    {
        return myPanel;
    }
}
