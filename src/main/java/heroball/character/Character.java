package heroball.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
public abstract class Character {

    @Getter
    @Setter
    private final int size;
    @Getter private final Color color;
    @Getter  private final Point location;

    public abstract void paint(Graphics2D graphicsContext);

}
