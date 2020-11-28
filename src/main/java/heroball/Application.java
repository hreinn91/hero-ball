package heroball;


import heroball.character.Character;
import heroball.character.player.Player;
import heroball.game.Game;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.ColorsUtil.WHITE_GRAY_DARK;

@Slf4j
public class Application {

    public static void run() {
        log.info(" > Starting Application < ");
        // Set these properties in a container
        Player player1 = new Player();
        List<Character> characters = new ArrayList<>();
        String name = "Game";
        int mapSize = 1000;
        int windowSize = 600;
        int animationDelay = 5;
        Color backgroundColor = WHITE_GRAY_DARK;
        Game game = Game.build(name, mapSize, windowSize, animationDelay, backgroundColor, player1, characters);
    }

    public static void main(String[] arg) {
        run();
    }
}
