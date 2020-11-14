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
        Character character = getCharacters().get(0);
        int pX = character.getLocation().getX();
        int pY = character.getLocation().getY();
        int centerPoint = getHeight()/2;
        int turningPoint = centerPoint + 100;

        if(pX < turningPoint && pY < turningPoint && pX >= 100){
            character.move(1, 0);
        } else if(pX >= turningPoint && pY < turningPoint){
            character.move(0, 1);
        } else if(pY >= turningPoint && pX >= 100){
            character.move(-1, 0);
        } else if (pX <= 100 && pY >= 100){
            character.move(0, -1);
        }



        //End with repaint
        repaint();
    }
}
