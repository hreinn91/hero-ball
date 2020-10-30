package heroball;


import heroball.character.Player;
import heroball.scene.Scene;
import heroball.scene.Scene1;

import javax.swing.*;

public class Main {

    public static void run() {

        // Thread safety
//
//        SwingUtilities.invokeLater(() -> {
//            Scene scene = new Scene1();
//            try {
//                while (true){
//                    scene.play();
//                    Thread.sleep(20);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        // Thread safety
        Runnable swingStarter = () -> {
            Scene scene = new Scene1();
            try {
                while (true){
                    scene.play();
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] arg) {
        run();
    }
}
