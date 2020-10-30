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
        map.repaint();
    }

    public void playWithThreadSafety() throws InterruptedException {
        // Thread safety
        Runnable swingStarter = () -> {
            try {
                while (true){
                    play();
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public void add(Character c) {
        characters.add(c);
    }
}