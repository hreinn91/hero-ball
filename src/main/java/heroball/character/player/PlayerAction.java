package heroball.character.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;

@AllArgsConstructor
public class PlayerAction extends AbstractAction {

    // This needs super()?

    @Getter
    public final Player player;


    public static final String MOVE_UP = "move up";
    public static final String MOVE_DOWN = "move down";
    public static final String MOVE_LEFT = "move left";
    public static final String MOVE_RIGHT = "move right";


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent != null){
            Object source = actionEvent.getSource();
            getPlayer().move(0, -1*getPlayer().getSpeed());
        }
    }
}
