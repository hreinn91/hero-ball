package heroball.player;

import heroball.character.Player;
import heroball.physics.Vector2D;

import java.awt.*;

import static heroball.util.GraphicsUtil.*;
import static heroball.util.GraphicsUtil.paintCircle;

public class TestPlayer extends Player {

    @Override
    public void paint(Graphics graphics) {
        // Paint Player body
//        paintCircle(graphics, getSize(), getColor(), getLocation());

        graphics.setColor(getColor());

        int size = 50;
        Vector2D location = new Vector2D(250, 300);
        Vector2D direction = getLocation();
        paintCharacterPointer(graphics, getColor(), location, direction, size);
        drawCircle(graphics, size, getColor(), location);
        drawLine(graphics, getColor(), location, direction);
        paintCircle(graphics, 5, getColor(), direction);


        // Paint equipment
        getEquipments().forEach(equipment -> equipment.paint(graphics, getLocation()));
    }
}
