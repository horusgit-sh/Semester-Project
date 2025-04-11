package gui;

import shapes.*;
import core.AbstractGraphObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Toolbar extends JPanel {
    public Toolbar(List<AbstractGraphObject> objects, DrawPanel drawPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton circleBtn = new JButton("Kruh");
        JButton squareBtn = new JButton("Čtverec");
        JButton triangleBtn = new JButton("Trojúhelník");
        JButton rectBtn = new JButton("Obdélník");
        JButton clearBtn = new JButton("Vymazat");

        circleBtn.addActionListener(e -> {
            objects.add(new Kruznice(new Point(100, 100), Color.BLUE, 50));
            drawPanel.repaint();
        });

        squareBtn.addActionListener(e -> {
            objects.add(new Ctverec(new Point(200, 100), Color.RED, 60));
            drawPanel.repaint();
        });

        triangleBtn.addActionListener(e -> {
            objects.add(new Trojuhelnik(new Point(300, 150), Color.ORANGE, 100));
            drawPanel.repaint();
        });

        rectBtn.addActionListener(e -> {
            objects.add(new Obdelnik(new Point(400, 200), Color.GREEN, 120, 60));
            drawPanel.repaint();
        });

        clearBtn.addActionListener(e -> {
            objects.clear();
            drawPanel.repaint();
        });

        add(circleBtn);
        add(squareBtn);
        add(triangleBtn);
        add(rectBtn);
        add(clearBtn);
    }
}
