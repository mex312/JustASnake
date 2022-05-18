import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Dimension2D;

public class LilThingie extends Entity {
    public LilThingie(){
        super("Lil Thingie");
        setBounds(200, 200, 100, 100);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        g2.fillOval(0, 0, 100, 100);
    }

    @Override
    public void Update() {

    }
}
