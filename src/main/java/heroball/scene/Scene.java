package heroball.scene;

import heroball.character.Character;
import heroball.map.Map;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {

    @Getter
    Map map;
    @Getter
    List<Character> characters = new ArrayList<>();

    public Scene(){
    }

    public Scene(Map map){
        this.map = map;
    }

    public void play() throws InterruptedException {
        // TODO: Set while loop here
        map.repaint();
    }


    public void add(Character c) {
        characters.add(c);
    }
}