package heroball.scene;

import heroball.character.Player;
import heroball.map.Map;
import heroball.map.Map1;

import java.awt.*;

public class Scene1 extends Scene {

    public Scene1(){
        super();
        this.map = new Map1("First Map", 800, 800, 800,
                800, Color.WHITE);
        Player player = new Player(15, Color.BLACK, new Point(100, 100));
        getPlayers().add(player);
        map.add(player);
    }

    public Scene1(Map map) {
        super(map);
    }

    @Override
    public void play(){
        super.play();
    }
}
