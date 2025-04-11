import core.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new GrafickyEditor().setVisible(true);
        });
    }
}