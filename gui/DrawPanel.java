package gui;

import core.AbstractGraphObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DrawPanel extends JPanel {

    private List<AbstractGraphObject> objekty;
    private AbstractGraphObject selectedObject = null;
    private Point lastDragPoint = null;

    public DrawPanel(List<AbstractGraphObject> objekty) {
        this.objekty = objekty;
        setBackground(Color.LIGHT_GRAY);
        initMouseListener();
    }

    private void initMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedObject = getObjectAt(e.getPoint());
                lastDragPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedObject = null;
                lastDragPoint = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedObject != null) {
                    int dx = e.getX() - lastDragPoint.x;
                    int dy = e.getY() - lastDragPoint.y;

                    Point newPozice = new Point(selectedObject.getPozice().x + dx, selectedObject.getPozice().y + dy);
                    selectedObject.setPozice(newPozice);

                    lastDragPoint = e.getPoint();

                    repaint();
                }
            }
        });
    }

    private AbstractGraphObject getObjectAt(Point point) {
        for (AbstractGraphObject obj : objekty) {
            if (obj.obsahuje(point.x, point.y)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (AbstractGraphObject obj : objekty) {
            obj.draw(g2d);
        }
    }
}
