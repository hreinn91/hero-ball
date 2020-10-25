package heroball.map;

import heroball.character.Character;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Map {

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
    @Setter
    private int frameWidth;
    @Getter
    @Setter
    private int frameHeight;
    @Getter
    private final JFrame frame;

    @Getter
    private final BufferedImage graphicsContext;
    @Getter
    private final JPanel contentPanel = new JPanel();
    @Getter
    private final JLabel contextRender;
    @Getter
    private final Graphics2D graphics2D;
    @Getter
    private final Color mapColor;

    @Getter
    private final List<Character> characters = new ArrayList<>();


    public Map(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, Color mapColor) {
        sizeCheck(mapWidth, frameWidth);
        sizeCheck(mapHeight, frameHeight);

        this.name = name;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frame = new JFrame(name);
        this.mapColor = mapColor;

        graphicsContext = new BufferedImage(frameWidth,
                frameHeight, BufferedImage.TYPE_INT_RGB);
        contextRender = new JLabel(new ImageIcon(graphicsContext));


        contentPanel.add(contextRender);
        contentPanel.setSize(frameWidth, frameHeight);
        contentPanel.setBackground(getMapColor());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(contentPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        graphics2D = graphicsContext.createGraphics();
        // Might have to put this in the paint method
        graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        setVisible(true);
    }

    public void paint() {
        Graphics2D graphicsContext = getGraphics2D();
        // Paint background
        graphicsContext.setColor(getMapColor());
        graphicsContext.fillRect(0, 0, frameWidth, frameHeight);

        characters.forEach(c -> c.paint(graphicsContext));

        graphicsContext.dispose();
        contextRender.repaint();
    }

    public void add(Character c) {
        characters.add(c);
    }

    public void setVisible(boolean visible) {
        getFrame().setVisible(visible);
    }

    public boolean isVisible() {
        return getFrame().isVisible();
    }

    private static void sizeCheck(int mapSize, int frameSize) {
        if (frameSize > mapSize)
            throw new IllegalArgumentException("Frame height or width must not exceed map height" +
                    " or width");
    }

}
