package heroball.map;

import heroball.character.Character;
import heroball.character.Player;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Window extends JPanel implements MouseListener, KeyListener {

    @Getter
    private final Player player1;
    @Getter
    private final List<Character> characters;

    public Window(int width, int height, Color backgroundColor, Player player1, List<Character> characters) {
        super(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setBorder(new LineBorder(Color.black, 2));
        this.player1 = player1;
        this.characters = characters;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        characters.forEach(character -> character.paint(graphics));
    }

    public void step() {


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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
