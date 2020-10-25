package heroball.character;

import heroball.character.equipment.Equipment;
import heroball.physics.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.GraphicsUtil.paintCircle;

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
    public void paint(Graphics2D graphicsContext) {
        // Paint Player
        paintCircle(graphicsContext, getSize(), getColor(), getLocation());

        // Paint equipment
        equipments.forEach(equipment -> equipment.paint(graphicsContext, getLocation()));
    }
}
