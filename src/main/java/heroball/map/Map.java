package heroball.map;

import heroball.character.Character;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class Map extends JFrame implements ActionListener {

    @Getter
    @Setter
    private int mapWidth;
    @Getter
    @Setter
    private int mapHeight;
    @Getter
    private final Color mapColor;
    @Getter
    private final Timer timer;
    @Getter
    private final Window window;
    @Getter
    private final List<Character> characters;


    public Map(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, int animationDelay,
               Color mapColor, List<Character> characters) {
        super(name);
        sizeCheck(mapWidth, frameWidth);
        sizeCheck(mapHeight, frameHeight);

        // MAP PROPERTIES
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.characters = characters;

        // SET THE FRAME PROPERTIES
        this.mapColor = mapColor;
        this.window = new Window(frameWidth, frameHeight, mapColor, characters);
        add(window);
        pack();
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // SET ACTION LISTENER PROPERTIES
        this.timer = new Timer(animationDelay, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        window.step();
    }

    public void add(Character c) {
        characters.add(c);
    }

    private static void sizeCheck(int mapSize, int frameSize) {
        if (frameSize > mapSize)
            throw new IllegalArgumentException("Frame height or width must not exceed map height" +
                    " or width");
    }
}
