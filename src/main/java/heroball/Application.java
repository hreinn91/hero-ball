package heroball;


import heroball.scene.Scene;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void run() {
        log.info(" > Starting Application < ");
        Scene scene = new Scene();
    }

    public static void main(String[] arg) {
        run();
    }
}
