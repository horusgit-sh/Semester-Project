package core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends AbstractGraphObject {
    private List<AbstractGraphObject> objekty;

    public Group(Point pozice, Color barva) {
        super(pozice, barva);
        this.objekty = new ArrayList<>();
    }


    public void pridatObjekt(AbstractGraphObject objekt) {
        objekty.add(objekt);
    }


    @Override
    public void draw(Graphics2D g) {
        for (AbstractGraphObject objekt : objekty) {
            objekt.draw(g);
        }
    }


    @Override
    public boolean obsahuje(int x, int y) {
        for (AbstractGraphObject objekt : objekty) {
            if (objekt.obsahuje(x, y)) {
                return true;
            }
        }
        return false;
    }
}
