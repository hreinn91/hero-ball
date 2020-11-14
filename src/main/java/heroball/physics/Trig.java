package heroball.physics;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Trig {

    /**
     * @return The atan of the points end and start
     */
    // TODO: Handle case when x = 0
    public static int getAngleDeg(Vector2D start, Vector2D end){
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        int angleDeg = (int) Math.toDegrees(Math.atan2(dy, dx));

        return angleDeg <0 ? 360 + angleDeg : angleDeg;
    }
}
