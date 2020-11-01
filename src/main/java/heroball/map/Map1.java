package heroball.map;

import heroball.character.Character;
import heroball.character.Player;
import heroball.physics.Vector2D;

import java.awt.*;
import java.util.List;

import static heroball.util.ColorsUtil.WHITE_GRAY_DARK;

public class Map1 extends Map {

    public Map1(){
        super("Map1", 800, 800, 800, 800, 30,
                WHITE_GRAY_DARK, List.of(new Player(100,  Color.RED, new Vector2D(500, 500))));
    }

    public Map1(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, int delay, Color mapColor,
                List<Character> characters) {
        super(name, mapWidth, mapHeight, frameWidth, frameHeight, delay, mapColor, characters);
    }

    public static void main(String[] arg){
        new Map1();
    }
}
