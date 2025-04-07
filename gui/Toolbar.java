package gui;

import core.AbstractGraphObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Toolbar extends JPanel {

    private DrawPanel drawPanel;
    private List<AbstractGraphObject> objekty;

    private JButton toggleStyleButton;
    private boolean currentStyleFilled = true;

    public Toolbar(DrawPanel drawPanel, List<AbstractGraphObject> objekty) {
        this.drawPanel = drawPanel;
        this.objekty = objekty;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        toggleStyleButton = new JButton("Contour");

        Dimension buttonSize = new Dimension(90, 30);
        toggleStyleButton.setMaximumSize(buttonSize);
        toggleStyleButton.setPreferredSize(buttonSize);
        toggleStyleButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        toggleStyleButton.addActionListener(e -> {
            currentStyleFilled = !currentStyleFilled;

            for (AbstractGraphObject obj : objekty) {
                obj.setFilled(currentStyleFilled);
            }

            toggleStyleButton.setText(currentStyleFilled ? "Contour" : "Fill");
            drawPanel.repaint();
        });

        add(Box.createVerticalStrut(10));
        add(toggleStyleButton);
    }
}
