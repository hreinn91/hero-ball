package heroball.physics;

import org.junit.jupiter.api.Test;

import static heroball.physics.Trig.getAngleDeg;
import static org.assertj.core.api.Assertions.assertThat;

public class TrigTest {

    @Test
    public void getAngleTest() {
        Vector2D location = new Vector2D(100, 100);

        Vector2D origin = new Vector2D(100, 100);           //  0
        short angleDeg = getAngleDeg(origin, new Vector2D(200, 100));       //  0
        short angleDeg1 = getAngleDeg(origin, new Vector2D(150, 50));       //  45
        short angleDeg2 = getAngleDeg(origin, new Vector2D(100, 50));       //  90
        short angleDeg3 = getAngleDeg(origin, new Vector2D(50, 50));        //  135
        short angleDeg4 = getAngleDeg(origin, new Vector2D(0, 100));        //  180
        short angleDeg5 = getAngleDeg(origin, new Vector2D(50, 150));       //  225
        short angleDeg6 = getAngleDeg(origin, new Vector2D(100, 200));      //  270
        short angleDeg7 = getAngleDeg(origin, new Vector2D(200, 200));      //  315
    }
}
