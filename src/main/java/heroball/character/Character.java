package heroball.character;

import heroball.physics.Vector2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
public abstract class Character {

    @Getter
    @Setter
    private int size;
    @Getter
    private Color color;
    @Setter
    @Getter
    private Vector2D location;

    public abstract void paint(Graphics2D graphicsContext);

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
