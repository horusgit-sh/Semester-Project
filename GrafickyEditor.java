

import core.AbstractGraphObject;
import gui.Toolbar;
import shapes.*;
import gui.DrawPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GrafickyEditor extends JFrame {

    private DrawPanel drawPanel;
    private List<AbstractGraphObject> objekty;

    public GrafickyEditor() {
        super("Grafický Vektorový Editor");

        objekty = new ArrayList<>();

        drawPanel = new DrawPanel(objekty);

        Toolbar toolbar = new Toolbar(drawPanel, objekty);

        add(drawPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.WEST);

        initTestData();

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initTestData() {
        objekty.add(new Ctverec(new Point(100, 100), Color.RED, 100));
        objekty.add(new Obdelnik(new Point(200, 120), Color.MAGENTA, 150, 60));
        objekty.add(new Trojuhelnik(new Point(350, 180), Color.ORANGE, 120));
        objekty.add(new Kruznice(new Point(500, 150), Color.BLUE, 100));

        drawPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GrafickyEditor());
    }
}
