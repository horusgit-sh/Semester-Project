package shapes;
import core.AbstractGraphObject;
import java.awt.*;

public class Obdelnik extends AbstractGraphObject {
    private int sirka;
    private int vyska;

    public Obdelnik(Point pozice, Color barva, int sirka, int vyska) {
        super(pozice, barva);
        this.sirka = sirka;
        this.vyska = vyska;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(barva);
        if (filled) {
            g.fillRect(pozice.x, pozice.y, sirka, vyska);
        } else {
            g.drawRect(pozice.x, pozice.y, sirka, vyska);
        }
    }

    @Override
    public boolean obsahuje(int x, int y) {
        return x >= pozice.x && x <= pozice.x + sirka && y >= pozice.y && y <= pozice.y + vyska;
    }
}
