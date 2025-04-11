package shapes;
import core.AbstractGraphObject;
import java.awt.*;

public class Kruznice extends AbstractGraphObject {
    private int polomer;

    public Kruznice(Point pozice, Color barva, int polomer) {
        super(pozice, barva);
        this.polomer = polomer;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(barva);
        int x = pozice.x - polomer;
        int y = pozice.y - polomer;

        g.fillOval(x, y, polomer * 2, polomer * 2);

    }
    @Override
    public boolean obsahuje(int x, int y) {
        int dx = x - pozice.x;
        int dy = y - pozice.y;
        return dx * dx + dy * dy <= polomer * polomer;
    }
}
