package heroball.scene;

import heroball.character.Player;
import heroball.map.Map;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {

    @Getter
    Map map;
    @Getter
    List<Player> players = new ArrayList<>();

    public Scene(){
    }

    public Scene(Map map){
        this.map = map;
    }

    public void play(){
        map.paint();
    }

}