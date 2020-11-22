package heroball.character.equipment;

import heroball.character.player.Player;

import java.awt.*;

import static heroball.util.GraphicsUtil.paintCharacterPointer;

public class DirectionPointer extends Equipment{


    public DirectionPointer(Player player, int size) {
        super(player, size);
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = Color.RED;
        graphics.setColor(color);
        paintCharacterPointer(graphics, color, getPlayer().getLocation(), getPlayer().getDirection(), getSize());
    }
}
