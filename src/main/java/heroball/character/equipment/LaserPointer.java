package heroball.character.equipment;

import heroball.character.player.Player;

import java.awt.*;

import static heroball.util.GraphicsUtil.drawLine;
import static heroball.util.GraphicsUtil.paintCircle;


public class LaserPointer extends Equipment {

    public LaserPointer(Player player, int size) {
        super(player, size);
    }


    @Override
    public void paint(Graphics graphics) {
        drawLine(graphics, Color.RED, getSize(), getPlayer().getLocation(), getPlayer().getDirection());
        paintCircle(graphics, 5, Color.RED, getPlayer().getDirection());
    }
}
