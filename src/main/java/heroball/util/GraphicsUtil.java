package heroball.util;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class GraphicsUtil {

    public static Shape paintConcentricRingShape(
            Point center, double outerRadius, double thickness)
    {
        Ellipse2D outer = new Ellipse2D.Double(
                center.getX() - outerRadius,
                center.getY() - outerRadius,
                outerRadius + outerRadius,
                outerRadius + outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
                center.getX() - outerRadius + thickness,
                center.getY() - outerRadius + thickness,
                outerRadius + outerRadius - thickness - thickness,
                outerRadius + outerRadius - thickness - thickness);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        return area;
    }



    public static void paint(Graphics2D graphicsContext, Point location, int size, Color color) {
        Shape shape = paintConcentricRingShape(location, (double) size, 2.0);
        graphicsContext.setColor(color);
        graphicsContext.fill(shape);
        graphicsContext.draw(shape);
    }
}
