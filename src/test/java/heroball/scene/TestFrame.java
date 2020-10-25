package heroball.scene;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TestFrame extends JFrame {
    protected long startTime = new Date().getTime();

    public class MainPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            // calculate elapsed time
            long currentTime = new Date().getTime();
            long timeDiff = currentTime - TestFrame.this.startTime;

            // animation time dependent
            g.fillRect((int) (timeDiff / 100), 10, 10, 10);
        }
    }

    public class MainLoop implements Runnable {
        @Override
        public void run() {
            while (true) {
                // trigger repaint
                TestFrame.this.repaint();
                try{
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestFrame();
            }
        });
    }

    public TestFrame() {
        // init window
        this.setTitle("Test");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MainPanel());
        this.setVisible(true);

        // start render loop
        Thread loop = new Thread(new MainLoop());
        loop.start();
    }
}