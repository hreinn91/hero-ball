package heroball.character;

import heroball.character.equipment.Equipment;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    List<Equipment> equipments = new ArrayList<>();

    public Player(int size, Color color, Point location){
        super(size, color, location);
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void paint(Graphics2D graphicsContext) {
        double size = (double) getSize();
        Shape shape = new Ellipse2D.Double(
                getLocation().getX() - size,
                getLocation().getY() - size,
                size + size,
                size + size);
        graphicsContext.setColor(getColor());
        graphicsContext.fill(shape);
        graphicsContext.draw(shape);

        equipments.forEach(equipment -> equipment.paint(graphicsContext, getLocation()));
    }
}
