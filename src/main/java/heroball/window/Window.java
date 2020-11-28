package heroball.window;

import heroball.character.Character;
import heroball.character.player.Player;
import heroball.character.player.PlayerAction;
import heroball.map.Map;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import static heroball.character.player.PlayerAction.*;
import static heroball.character.player.PlayerAction.MOVE_RIGHT;

public class Window extends JPanel implements MouseListener{

    @Getter
    private final Map map;
    @Getter
    private final Player player1;
    @Getter
    private final List<Character> characters;

    public Window(int width, int height, Color backgroundColor, Player player1, List<Character> characters, Map map) {
        super(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setBorder(new LineBorder(Color.black, 2));
        this.player1 = player1;
        this.characters = characters;

        this.map = map;
        sizeCheck(map.getWidth(), getWidth());
        sizeCheck(map.getHeight(), getHeight());

        setupActions(getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW), getActionMap());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        super.paintComponent(graphics);
        player1.paint(graphics);
        characters.forEach(character -> character.paint(graphics));
    }

    public void step() {

        if(isMouseInWindow()){
            player1.setDirection(getMousePosition());
        }

        //End with repaint
        repaint();
    }

    public boolean isMouseInWindow() {
        return getMousePosition() != null;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private void setupActions(InputMap inputMap, ActionMap actionMap){

        PlayerAction playerAction = new PlayerAction(getPlayer1());
        inputMap.put(KeyStroke.getKeyStroke("W"), MOVE_UP);
        actionMap.put(MOVE_UP, playerAction);
        inputMap.put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
        actionMap.put(MOVE_DOWN, playerAction);
        inputMap.put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);
        actionMap.put(MOVE_RIGHT, playerAction);
        inputMap.put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
        actionMap.put(MOVE_LEFT, playerAction);
    }

    private static void sizeCheck(int mapSize, int frameSize) {
        if (frameSize > mapSize) {
            throw new IllegalArgumentException("Frame height or width must not exceed map height" +
                    " or width");
        }
    }
}
