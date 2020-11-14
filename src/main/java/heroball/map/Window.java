package heroball.map;

import heroball.character.Character;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class Window extends JPanel {
    @Getter
    private final List<Character> characters;
    public Window(int width, int height, Color backgroundColor, List<Character> characters){
        super(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(backgroundColor);
        setBorder(new LineBorder(Color.black, 2));
        this.characters = characters;
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        characters.forEach(character -> character.paint(graphics));
    }

    public void step(){


        //End with repaint
        repaint();
    }
}
