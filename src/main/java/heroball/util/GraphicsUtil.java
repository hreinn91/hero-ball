package heroball.util;

import heroball.physics.Vector2D;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import static heroball.physics.Vector2D.getAngle;

@Slf4j
public class GraphicsUtil {

    public static Shape createConcentricRingShape(
            Vector2D center, double outerRadius, double thickness)
    {
        Ellipse2D outer = new Ellipse2D.Double(
                center.getXAsDouble() - outerRadius,
                center.getYAsDouble() - outerRadius,
                outerRadius + outerRadius,
                outerRadius + outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
                center.getXAsDouble() - outerRadius + thickness,
                center.getYAsDouble() - outerRadius + thickness,
                outerRadius + outerRadius - thickness - thickness,
                outerRadius + outerRadius - thickness - thickness);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        return area;
    }

    public static void paintConcentricRingShape(Graphics2D graphicsContext, Vector2D location, int size, Color color) {
        Shape shape = createConcentricRingShape(location, (double) size, 2.0);
        graphicsContext.setColor(color);
        graphicsContext.fill(shape);
        graphicsContext.draw(shape);
    }

    public static void paintCircle(Graphics graphics, int radius, Color color, Vector2D location){
        graphics.setColor(color);
        graphics.fillOval(location.getX()-radius, location.getY()-radius, 2*radius, 2*radius);
    }

    public static void drawCircle(Graphics graphics, int radius, Color color, Vector2D origin){
        graphics.setColor(color);
        graphics.drawOval(origin.getX()-radius, origin.getY()-radius, 2*radius, 2*radius);
    }

    // This should work for direction 270
    public static void paintArch(Graphics graphics, Vector2D location, Color color, int radius, int direction, int arcWidth){
        graphics.setColor(color);
        int archX = (int) (Math.cos(Math.toRadians((float)direction) + (float)(arcWidth / 2)) * radius);
        int archY = (int) (Math.sin(Math.toRadians((float)direction) + (float)(arcWidth / 2)) * radius);


        graphics.fillArc(location.getX() - radius - archX , location.getY() - radius - archY, 2 * radius,
                2 * radius, direction, arcWidth);
    }

    // Paints the arch pointing in the direction of the direction vector
    // The origin of the arch is in the middle of the arch and not on the point
    public static void paintCharacterPointer(Graphics graphics, Color color, Vector2D location, Vector2D direction, int radius){
        graphics.setColor(color);
//        radius = radius + 10;
        int archWidth = 90;
        int angleToDirection = -1 * getAngle(location, direction) + 90 + 45;


        graphics.fillArc(location.getX() - radius, location.getY() - radius, 2 * radius, 2 * radius,
                angleToDirection, archWidth);
    }

    // Paints the arch pointing in the direction of the direction vector
    // The origin of the arch is in the middle of the arch and not on the point
    public static void paintCharacterPointerExperimental(Graphics graphics, Color color, Vector2D location, Vector2D direction, int radius){
        graphics.setColor(color);
//        radius = radius + 10;
        int archWidth = 90;
        int angleToDirection = -1 * getAngle(location, direction) + 90 + 45;
        int archX = (int) (Math.cos(Math.toRadians((float)angleToDirection)) * radius);
        int archY = (int) (Math.sin(Math.toRadians((float)angleToDirection)) * radius);


        graphics.fillArc(location.getX() - radius - archX, location.getY() - radius - archY, 2 * radius, 2 * radius,
                angleToDirection, archWidth);
    }

    public static void drawLine(Graphics graphics, Color color, Vector2D p1, Vector2D p2){
        graphics.setColor(color);
        graphics.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY() );
    }


}
