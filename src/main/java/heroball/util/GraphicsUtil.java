package heroball.util;

import heroball.physics.Vector2D;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

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


    public static void paintCircle(Graphics2D graphicsContext, int size, Color color, Vector2D location){
        Shape shape = new Ellipse2D.Double(
                location.getXAsDouble() - (double) size,
                location.getYAsDouble() - (double) size,
                (double) size + (double) size,
                (double) size + (double) size);
        graphicsContext.setColor(color);
        graphicsContext.fill(shape);
        graphicsContext.draw(shape);
    }



}
