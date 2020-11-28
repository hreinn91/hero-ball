package heroball.physic;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
@AllArgsConstructor
public class Vector2D {
    int x;
    int y;

    public Vector2D add(Vector2D translation) {
        setX(getX() + translation.getX());
        setY(getY() + translation.getY());
        return this;
    }

    public Vector2D sub(Vector2D translation) {
        setX(getX() - translation.getX());
        setY(getY() - translation.getY());
        return this;
    }

    public Vector2D add(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
        return this;
    }

    public Vector2D addPolar(int r, float angle) {
        int dx = (int) (r * Math.cos(Math.toRadians(angle)));
        int dy = (int) (r * Math.sin(Math.toRadians(angle)));
        return add(dx, -1 * dy);
    }

    public Vector2D scalarProd(float speed) {
        return add((int) speed*getX(), (int) speed*getY());
    }

    public static Vector2D getVectorFromPoint(Point point) {
        return point == null ? null : new Vector2D((int)point.getX(), (int)point.getY());
    }

    public Vector2D vectorClone() {
        return new Vector2D(getX(), getY());
    }

    public float getXAsFloat() {
        return (float) x;
    }

    public float getYAsFloat() {
        return (float) y;
    }

    public short getAngleTo(Vector2D to) {
        return Trig.getAngleDeg(this, to);
    }

    public double distance(Vector2D to) {
        return Math.sqrt((to.getX() - getX()) * (to.getX() - getX()) + (to.getY() - getY()) * (to.getY() - getY()));
    }
}
