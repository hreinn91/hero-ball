package heroball.map;

import heroball.character.Player;

import java.awt.*;
import java.awt.event.ActionEvent;

import static heroball.util.ColorsUtil.WHITE_GRAY;

public class Map1 extends Map {

    public Map1(){
        super("First Map", 600, 600, 600, 600, WHITE_GRAY);
        getCharacters().add(new Player());
    }

    public Map1(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, Color mapColor) {
        super(name, mapWidth, mapHeight, frameWidth, frameHeight, mapColor);
    }
}
