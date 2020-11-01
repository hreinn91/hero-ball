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
        Vector2D location = new Vector2D(400, 400);
        Vector2D direction = getLocation();
        paintCharacterPointer(graphics, getColor(), location, direction, size);
        drawCircle(graphics, size, getColor(), location);
        drawLine(graphics, getColor(), location, direction);
        paintCircle(graphics, 5, getColor(), direction);


//        Vector2D point = new Vector2D(100, 200);
//        paintArch(graphics, point, getColor(), 35, 0, 90);
//        paintCircle(graphics, 4, Color.BLACK, point);


        paintArch(graphics, new Vector2D(300, 200), getColor(), 35, 90, 90);
        paintCircle(graphics, 4, Color.BLACK, new Vector2D(300, 200));

        Vector2D point2 = new Vector2D(300, 200);
        paintCircle(graphics, 4, getColor(), point2);
        paintArch(graphics, point2, getColor(), 35, 180, 45);

        Vector2D point1 = new Vector2D(500, 200);
        paintCircle(graphics, 4, getColor(), point1);
        paintArch(graphics, point1, getColor(), 35, 90, 45);

        Vector2D point3 = new Vector2D(700, 200);
        paintCircle(graphics, 4, getColor(), point3);
        paintArch(graphics, point3, getColor(), 35, 270, 45);


        // Paint equipment
//        equipments.forEach(equipment -> equipment.paint(graphicsContext, getLocation()));
    }
}
