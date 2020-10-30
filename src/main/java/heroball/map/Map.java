package heroball.map;

import heroball.character.Character;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Map extends JFrame implements ActionListener {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int mapWidth;
    @Getter
    @Setter
    private int mapHeight;
    @Getter
    private final Color mapColor;
    @Getter
    private Timer timer;
    @Getter
    private MainPanel panel;
    @Getter
    private final List<Character> characters = new ArrayList<>();


    public Map(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, Color mapColor) {
        sizeCheck(mapWidth, frameWidth);
        sizeCheck(mapHeight, frameHeight);

        this.name = name;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.mapColor = mapColor;
        setTitle(name);
        this.panel = new MainPanel(frameWidth, frameHeight, mapColor);
        add(panel);
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class MainPanel extends JPanel {
        public MainPanel(int width, int height, Color color) {
            setPreferredSize(new Dimension(width, height));
            setBackground(color);
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON));

            super.paintComponent(graphics);

            characters.forEach(c -> c.paint(graphics2D));
//            graphics.dispose();
        }
    }

    public void actionPerformed(ActionEvent e) {
        panel.repaint();
    }

    public void step(){
        panel.repaint();
    }

    public void add(Character c) {
        characters.add(c);
    }

    private static void sizeCheck(int mapSize, int frameSize) {
        if (frameSize > mapSize)
            throw new IllegalArgumentException("Frame height or width must not exceed map height" +
                    " or width");
    }


    public static void main(String[] arg) {
        Map map = new Map1();
        map.getPanel().repaint();
    }

}
