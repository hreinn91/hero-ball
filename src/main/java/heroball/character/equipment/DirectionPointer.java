package heroball.character.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
public class DirectionPointer extends Equipment{

    @Getter private int size;

    @Override
    public void paint(Graphics2D graphicsContext, Point location) {

    }
}
