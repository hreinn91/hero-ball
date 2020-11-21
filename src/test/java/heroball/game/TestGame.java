package heroball.game;

import heroball.character.Character;
import heroball.character.Player;
import heroball.map.Map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.ColorsUtil.WHITE_GRAY_DARK;

public class TestGame {

    Game game;
    Player player1 = new Player();
    List<Character> characters = new ArrayList<>();
    String name = "Test Game";
    int mapSize = 1000;
    int windowSize = 600;
    int animationDelay = 5;
    Color backgroundColor = WHITE_GRAY_DARK;


    public TestGame() {
        Map map = new Map(mapSize, mapSize, player1, characters);
        TestWindow testWindow = new TestWindow(windowSize, windowSize, backgroundColor, characters, map);
        game = new Game(name, animationDelay, backgroundColor, player1, characters, map , testWindow);
    }




    public static void main(String[] arg){
        new TestGame();
    }
}
