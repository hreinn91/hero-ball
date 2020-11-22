package heroball.game;

import heroball.character.Character;
import heroball.character.player.Player;
import heroball.map.Map;
import heroball.physic.Vector2D;
import heroball.window.Window;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

import static heroball.physic.Vector2D.getVectorFromPoint;
import static heroball.util.GraphicsUtil.*;

@Slf4j
public class TestWindow extends Window {
    @Getter
    @Setter
    int tic = 0;
    @Getter
    @Setter
    Vector2D origin = new Vector2D(250, 300);
    @Getter
    @Setter
    Vector2D ref = new Vector2D(50, 50);

    public TestWindow(int width, int height, Color backgroundColor, List<Character> characters, Map map) {
        super(width, height, backgroundColor, new Player(), characters, map);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        paintArchTest(graphics);
//        followMouseTest(graphics);

    }

    @Override
    public void step() {
        //End with repaint
        repaint();
    }

    public void moveSquare(Vector2D point) {
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

    public void paintArchTest(Graphics graphics) {
        moveSquare(getRef());
        Color color = Color.RED;
        graphics.setColor(color);
        int size = 80;
        paintCharacterPointer(graphics, color, getOrigin(), getRef(), (int) (size * 1.7));
        drawCircle(graphics, size, color, getOrigin());
        drawLine(graphics, color, getOrigin(), getRef());
        paintCircle(graphics, 5, color, getRef());
        short angle = origin.getAngleTo(getRef());
        paintCircle(graphics, 5, color, origin.vectorClone().addPolar(size, angle));
    }

    public void followMouseTest(Graphics graphics) {
        Color color = Color.RED;
        graphics.setColor(color);
        int size = 40;
        Vector2D mousePosition = getVectorFromPoint(getMousePosition());
        paintCharacterPointer(graphics, color, getOrigin(), mousePosition, (int) (size * 1.7));
        drawCircle(graphics, size, color, getOrigin());
        drawLine(graphics, color, getOrigin(), mousePosition);
        paintCircle(graphics, 5, color, mousePosition);
        short angle = origin.getAngleTo(mousePosition);
        paintCircle(graphics, 5, color, origin.vectorClone().addPolar(size, angle));
    }
}
