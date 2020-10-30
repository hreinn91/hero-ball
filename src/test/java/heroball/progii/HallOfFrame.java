package heroball.progii;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HallOfFrame
        extends JFrame
        implements ActionListener
{
    private Hall theHall;
    private Timer timer;

    public HallOfFrame(int width, int height,
                       int delay, int dx, int dy) {
        theHall = new Hall(width, height, dx, dy);
        timer = new Timer(delay, this);
        add(theHall);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        theHall.step();
        if(this.theHall.getBall().getDy()==0 && this.theHall.getBall().getY()==theHall.getHeight()-this.theHall.getBall().getR()){
//        String msg = "Turn me off";
//        JOptionPane.showMessageDialog(null, msg);
//        System.exit(0);
        }
    }

    public static void main(String[] args) {
        HallOfFrame hf = new HallOfFrame(500, 300, 5, 10, -30);
    }

}