package heroball.game;

import heroball.character.Character;
import heroball.character.player.Player;
import heroball.map.Map;
import heroball.window.Window;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 */
public class Game extends JFrame implements ActionListener {


    @Getter
    private final Color backgroundColour;
    @Getter
    private final Timer timer;
    @Getter
    private final Window window;
    @Getter
    private final Map map;
    @Getter
    private final Player player1;
    @Getter
    private final List<Character> characters;


    public Game(String name, int animationDelay,
                Color backgroundColour, Player player1, List<Character> characters, Map map, Window window) {
        super(name);


        // MAP PROPERTIES
        this.map = map;
        this.characters = characters;

        // SET THE FRAME PROPERTIES
        this.backgroundColour = backgroundColour;
        this.window = window;
        this.player1 = window.getPlayer1();
        add(window);
        pack();
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hideCursor();

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

    public static Game build(String name, int mapSize, int windowSize, int animationDelay, Color backgroundColor,
                             Player player1, List<Character> characters) {
        Map map = new Map(mapSize, mapSize, player1, characters);
        Window window = new Window(windowSize, windowSize, backgroundColor, player1, characters, map);
        return new Game(name, animationDelay, backgroundColor, player1, characters, map, window);
    }

    public void hideCursor(){
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor to the JFrame.
        getContentPane().setCursor(blankCursor);
    }


}
