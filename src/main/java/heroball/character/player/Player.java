package heroball.character.player;

import heroball.character.Character;
import heroball.character.equipment.DirectionPointer;
import heroball.character.equipment.Equipment;
import heroball.character.equipment.LaserPointer;
import heroball.physic.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static heroball.util.GraphicsUtil.paintCircle;

public class Player extends Character {

    @Getter
    @Setter
    private int dir = 0;
    @Getter
    private final Vector2D direction = new Vector2D(0, 0);
    @Getter
    List<Equipment> equipments = new ArrayList<>();

    public Player(){
        super(14, Color.RED, new Vector2D(200, 200));
        setSpeed(2);
        equipments.add(new DirectionPointer(this, (int)(2.5* getSize())));
        equipments.add(new LaserPointer(this, 2));
    }

    public Player(int size, Color color, Vector2D location){
        super(size, color, location);
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public void setDirection(Point point){
        if(point!=null) {
            direction.setX((int) point.getX());
            direction.setY((int) point.getY());
        }
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(getColor());
        paintCircle(graphics, getSize(), getColor(), getLocation());
//        paintCharacterPointer(graphics, getColor(), getLocation(), new Vector2D(100, 100), getSize());

        // Paint equipment
        getEquipments().forEach(equipment -> equipment.paint(graphics));
    }

    @Override
    public void action(KeyEvent key) {
        if(key.getKeyCode() == KeyEvent.VK_W) {
            move(0, 1);
        }else if(key.getKeyCode() == KeyEvent.VK_S){
            move(0, -1);
        }else if(key.getKeyCode() == KeyEvent.VK_A){
            move(-1, 0);
        }else if(key.getKeyCode() == KeyEvent.VK_D){
            move(1, 0);
        }
    }

}
