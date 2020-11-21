package heroball.physics;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * Handle trigonometry for the Swing coordinate system
 */

@Slf4j
@UtilityClass
public class Trig {

    /**
     * @return Gives the angle between from to given swing coordinates
     */
    // TODO: Handle case when x = 0
    public static short getAngleDeg(Vector2D from, Vector2D to) {
        float dx = (float) (to.getXAsFloat() - from.getXAsFloat());
        float dy = (float) (to.getYAsFloat() - from.getYAsFloat());
        dy = dy * -1;
        short angle = atan(dy / dx);
        if (dy == 0 && dx == 0)
            return 0;
        else if (dy >= 0 && dx >= 0) {
            return angle;
        } else if (dx < 0) {
            angle = (short) (angle + 180);
            return angle;
        }
        angle = (short) (360 + atan((float) (dy / dx)));
        return angle;
    }

    private static short atan(float expr) {
        return (short) Math.toDegrees(Math.atan(expr));
    }
}
