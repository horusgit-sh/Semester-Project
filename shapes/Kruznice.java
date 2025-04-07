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
        if (filled) {
            g.fillRect(pozice.x, pozice.y, polomer, polomer);
        } else {
            g.drawRect(pozice.x, pozice.y, polomer, polomer);
        }
    }
    @Override
    public boolean obsahuje(int x, int y) {
        int dx = x - pozice.x;
        int dy = y - pozice.y;
        return dx * dx + dy * dy <= polomer * polomer;
    }
}
