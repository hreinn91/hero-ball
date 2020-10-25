package heroball.map;

import java.awt.*;

import static heroball.util.ColorsUtil.WHITE_GRAY;

public class Map1 extends Map {

    public Map1(){
        super("First Map", 400, 400, 400, 400, WHITE_GRAY);
    }

    public Map1(String name, int mapWidth, int mapHeight, int frameWidth, int frameHeight, Color mapColor) {
        super(name, mapWidth, mapHeight, frameWidth, frameHeight, mapColor);
    }
}
