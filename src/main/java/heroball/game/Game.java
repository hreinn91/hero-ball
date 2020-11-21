package heroball.game;

import heroball.character.Character;
import heroball.character.Player;
import heroball.map.Map;
import heroball.window.Window;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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


}
