package heroball.physics;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2D{
    int x;
    int y;

    public Vector2D add(Vector2D translation){
        setX(getX() + translation.getX());
        setY(getY() + translation.getY());
        return this;
    }

    public Vector2D sub(Vector2D translation){
        setX(getX() - translation.getX());
        setY(getY() - translation.getY());
        return this;
    }

    public Vector2D add(int dx, int dy){
        setX(getX() + dx);
        setY(getY() + dy);
        return this;
    }

    public Vector2D addPolar(int r, float angle){
        int dx = (int) (r * Math.cos(Math.toRadians(angle)));
        int dy = (int) (r * Math.sin(Math.toRadians(angle)));
        return add(dx, -1 * dy);
    }
    
    @Override
    public Vector2D clone() {
        return new Vector2D(getX(), getY());
    }

    public double getXAsDouble(){
        return (double) x;
    }

    public double getYAsDouble(){
        return (double) y;
    }

    public short getAngleTo(Vector2D to){
        return Trig.getAngleDeg(this, to);
    }

    public double distance(Vector2D to){
        return Math.sqrt((to.getX() - getX()) * (to.getX() - getX()) + (to.getY() - getY()) * (to.getY() - getY()));
    }
}
