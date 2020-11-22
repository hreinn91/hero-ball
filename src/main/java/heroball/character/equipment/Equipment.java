package heroball.character.equipment;

import heroball.character.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
public abstract class Equipment {

    @Getter
    private final Player player;
    @Getter
    private int size;


    public abstract void paint(Graphics graphics);

}
