package heroball.character;

import heroball.physic.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Character {

    @Getter
    @Setter
    private int size;
    @Getter
    private Color color;
    @Setter
    @Getter
    private Vector2D location;
    @Getter
    @Setter
    private int speed = 1;

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

    public abstract void action(KeyEvent key);

}
