package heroball.scene;

import heroball.character.Character;
import heroball.map.Map;
import heroball.map.Map1;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    @Getter
    Map map;
    @Getter
    List<Character> characters = new ArrayList<>();

    public Scene(){
        this.map = new Map1();
    }

    public Scene(Map map){
        this.map = map;
    }

    public void play() throws InterruptedException {
    }

    public void playWithThreadSafety() throws InterruptedException {
        // Thread safety
        Runnable swingStarter = () -> {
            while (true){

            }
        };
    }

    public void add(Character c) {
        characters.add(c);
    }
}