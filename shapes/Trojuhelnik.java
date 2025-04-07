package shapes;
import core.AbstractGraphObject;
import java.awt.*;

public class Trojuhelnik extends AbstractGraphObject {
    private int strana;

    public Trojuhelnik(Point pozice, Color barva, int strana) {
        super(pozice, barva);
        this.strana = strana;
    }

    @Override
    public void draw(Graphics2D g) {
        int halfSize = strana / 2;
        int height = (int) (Math.sqrt(3) / 2 * strana);

        int[] xPoints = {
                pozice.x,
                pozice.x - halfSize,
                pozice.x + halfSize
        };

        int[] yPoints = {
                pozice.y,
                pozice.y + height,
                pozice.y + height
        };

        g.setColor(barva);
        if (filled) {
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public boolean obsahuje(int x, int y) {
        int[] xPoints = {pozice.x, pozice.x + strana / 2, pozice.x - strana / 2};
        int[] yPoints = {pozice.y, pozice.y + (int) (Math.sqrt(3) * strana / 2), pozice.y + (int) (Math.sqrt(3) * strana / 2)};
        Polygon polygon = new Polygon(xPoints, yPoints, 3);
        return polygon.contains(x, y);
    }
}