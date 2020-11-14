package heroball.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static heroball.util.ColorsUtil.WHITE_GRAY_DARK;

public class TestMap extends Map {
    public TestMap() {
        super("TestMap", 500, 500, 500, 500,
                4,WHITE_GRAY_DARK, List.of(),
                new TestWindow(500, 500, WHITE_GRAY_DARK, new ArrayList<>()));
    }




    public static void main(String[] arg){
        new TestMap();
    }
}
