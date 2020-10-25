package heroball.physics;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2D{
    int x;
    int y;

    public void add(Vector2D translation){
        setX(getX() + translation.getX());
        setY(getY() + translation.getY());
    }

    public void add(int dx, int dy){
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public double getXAsDouble(){
        return (double) x;
    }

    public double getYAsDouble(){
        return (double) y;
    }
}