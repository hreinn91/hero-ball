package heroball.progii;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Hall
        extends JPanel
{
    private Ball b;

    public Hall(int width, int height, int dx, int dy) {
        b = new Ball(this, 0, height, dx, dy);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(Color.red,2));
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        super.paintComponent(graphics);
        b.paint(graphics);
//        graphics.dispose();
    }

    public void step() {
        b.move();
        repaint();
    }

    public Ball getBall(){
        return this.b;
    }

}