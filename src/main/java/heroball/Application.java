package heroball;


import heroball.character.Player;
import heroball.scene.Scene;
import heroball.scene.Scene1;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class Application {

    public static void run() {
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        log.info("Hello");
        Scene scene = new Scene1();
        try {
            scene.play();
        } catch (InterruptedException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] arg) {
        run();
    }
}
