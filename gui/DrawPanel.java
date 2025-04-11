package gui;
import core.AbstractGraphObject;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import core.AbstractGraphObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class DrawPanel extends JPanel {
    List<AbstractGraphObject> objectList;
    private AbstractGraphObject selectedObject = null;
    private Point lastMousePosition;

    public DrawPanel(List<AbstractGraphObject> objectList) {
        this.objectList = objectList;
        setBackground(Color.LIGHT_GRAY);


        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point clickPoint = e.getPoint();
                for (int i = objectList.size() - 1; i >= 0; i--) { // от верхней фигуры
                    AbstractGraphObject obj = objectList.get(i);
                    if (obj.obsahuje(clickPoint.x, clickPoint.y)) {
                        selectedObject = obj;
                        lastMousePosition = clickPoint;
                        break;
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedObject != null && lastMousePosition != null) {
                    Point current = e.getPoint();
                    int dx = current.x - lastMousePosition.x;
                    int dy = current.y - lastMousePosition.y;

                    Point newPosition = new Point(
                            selectedObject.getPozice().x + dx,
                            selectedObject.getPozice().y + dy
                    );
                    selectedObject.setPozice(newPosition);
                    lastMousePosition = current;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedObject = null;
                lastMousePosition = null;
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (AbstractGraphObject obj : objectList) {
            obj.draw(g2);
        }
    }
}
