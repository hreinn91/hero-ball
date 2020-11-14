package heroball.character;

import heroball.character.equipment.Equipment;
import heroball.physics.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.GraphicsUtil.*;

public class Player extends Character {

    List<Equipment> equipments = new ArrayList<>();

    public Player(){
        super(12, Color.BLACK, new Vector2D(200, 200));
    }

    public Player(int size, Color color, Vector2D location){
        super(size, color, location);
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void paint(Graphics graphics) {
        // Paint Player body
//        paintCircle(graphics, getSize(), getColor(), getLocation());

        graphics.setColor(getColor());

        int size = 50;
        Vector2D location = new Vector2D(250, 250);
        Vector2D direction = getLocation();
        paintCharacterPointer(graphics, getColor(), location, direction, size);
        drawCircle(graphics, size, getColor(), location);
        drawLine(graphics, getColor(), location, direction);
        paintCircle(graphics, 5, getColor(), direction);




        // Paint equipment
        equipments.forEach(equipment -> equipment.paint(graphics, getLocation()));
    }
}
