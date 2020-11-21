package heroball.character;

import heroball.character.equipment.Equipment;
import heroball.physic.Vector2D;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.GraphicsUtil.*;

public class Player extends Character {

    @Getter
    List<Equipment> equipments = new ArrayList<>();

    public Player(){
        super(12, Color.RED, new Vector2D(200, 200));
    }

    public Player(int size, Color color, Vector2D location){
        super(size, color, location);
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(getColor());
        paintCircle(graphics, getSize(), getColor(), new Vector2D(100, 100));
        paintCharacterPointer(graphics, getColor(), getLocation(), new Vector2D(100, 100), getSize());

        // Paint equipment
        getEquipments().forEach(equipment -> equipment.paint(graphics, getLocation()));
    }
}
