package heroball.scene;

import heroball.character.Player;
import heroball.map.Map;
import heroball.map.Map1;
import heroball.physics.Vector2D;

import java.util.concurrent.TimeUnit;

public class Scene1 extends Scene {

    public Scene1(){
        super();
        this.map = new Map1();
        Player player1 = new Player();
        add(player1);
        map.add(player1);
    }

    public Scene1(Map map) {
        super(map);
    }

    @Override
    public void play() throws InterruptedException {
        super.play();
    }
}
