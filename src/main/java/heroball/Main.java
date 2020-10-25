package heroball;


import heroball.character.Player;
import heroball.scene.Scene;
import heroball.scene.Scene1;

import javax.swing.*;

public class Main {

    public static void run(){

        // Thread safety
        Runnable swingStarter = new Runnable() {
            @Override
            public void run() {
                Scene scene = new Scene1();
                scene.play();
                Player player = scene.getPlayers().get(0);
            }
        };

        SwingUtilities.invokeLater(swingStarter);
    }

    public static void main(String[] arg){
        run();
    }
}
