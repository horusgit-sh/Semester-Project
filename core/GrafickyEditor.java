package core;
import shapes.*;
import gui.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GrafickyEditor extends JFrame {
    private final List<AbstractGraphObject> objekty = new ArrayList<>();

    public GrafickyEditor() {
        super("Vektorový editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DrawPanel drawPanel = new DrawPanel(objekty);
        Toolbar toolbar = new Toolbar(objekty, drawPanel);

        add(toolbar, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
