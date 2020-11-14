package heroball.character.equipment;

import heroball.physics.Vector2D;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
public class DirectionPointer extends Equipment{

    @Getter private int size;

    @Override
    public void paint(Graphics graphicsContext, Vector2D location) {

    }
}
