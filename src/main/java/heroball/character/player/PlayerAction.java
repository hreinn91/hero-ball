package heroball.character.player;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayerAction extends AbstractAction {


    @Getter
    public final Player player;

    public static final String MOVE_UP = "move up";
    public static final String MOVE_DOWN = "move down";
    public static final String MOVE_LEFT = "move left";
    public static final String MOVE_RIGHT = "move right";

    public PlayerAction(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent != null) {
            switch (actionEvent.getActionCommand()) {
                case "w" -> getPlayer().move(0, -1 * getPlayer().getSpeed());
                case "s" -> getPlayer().move(0, getPlayer().getSpeed());
                case "a" -> getPlayer().move(-1 * getPlayer().getSpeed(), 0);
                case "d" -> getPlayer().move(getPlayer().getSpeed(), 0);
            }


        }
    }
}
