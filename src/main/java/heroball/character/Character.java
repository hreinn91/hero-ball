package heroball.character;

import heroball.physics.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class Character {

    @Getter
    @Setter
    private int size;
    @Getter
    @Setter
    private int dir = 0;
    @Getter
    @Setter
    private Vector2D direction = new Vector2D(0, 0);
    @Getter
    private Color color;
    @Setter
    @Getter
    private Vector2D location;

    public Character(int size, Color color, Vector2D location){
        this.size = size;
        this.color = color;
        this.location = location;
    }

    public abstract void paint(Graphics graphicsContext);

    public void move(Vector2D velocity) {
        location.add(velocity);
    }

    public void move(int dx, int dy) {
        location.add(dx, dy);
    }

    public void moveTo(Vector2D newLocation) {
        setLocation(newLocation);
    }

    public void moveTo(int x, int y) {
        setLocation(new Vector2D(x, y));
    }

}
