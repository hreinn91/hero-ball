package heroball.map;

import heroball.character.Character;
import heroball.physics.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

import static heroball.util.GraphicsUtil.*;
import static heroball.util.GraphicsUtil.paintCircle;

public class TestWindow extends Window {
    @Getter @Setter
    int tic = 0;
    @Getter @Setter
    Vector2D origin = new Vector2D(250, 300);
    @Getter @Setter
    Vector2D ref = new Vector2D( 50, 50);

    public TestWindow(int width, int height, Color backgroundColor, List<Character> characters) {
        super(width, height, backgroundColor, characters);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        painArchTest(graphics);
    }

    @Override
    public void step() {

        //End with repaint
        repaint();
    }

    public void moveSquare(Vector2D point){
        int pX = point.getX();
        int pY = point.getY();
        int centerPoint = getHeight() / 2;
        int turningPoint = centerPoint + 200;
        if (pX < turningPoint && pY < turningPoint && pX >= 50) {
            point.add(1, 0);
        } else if (pX >= turningPoint && pY < turningPoint) {
            point.add(0, 1);
        } else if (pY >= turningPoint && pX >= 50) {
            point.add(-1, 0);
        } else if (pX <= 50 && pY >= 50) {
            point.add(0, -1);
        }
    }

    public void painArchTest(Graphics graphics){
        moveSquare(getRef());
        Color color = Color.RED;
        graphics.setColor(color);
        int size = 20;
        paintCharacterPointer(graphics, color, getOrigin(), getRef(), (int)(size*1.7));
        drawCircle(graphics, size, color, getOrigin());
        drawLine(graphics, color, getOrigin(), getRef());
        paintCircle(graphics, 5, color, getRef());


        short angle = origin.getAngleTo(getRef());
        paintCircle(graphics, 5, color, origin.clone().addPolar(size, angle));

    }
}
