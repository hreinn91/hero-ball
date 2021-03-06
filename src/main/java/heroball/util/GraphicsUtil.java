package heroball.util;

import heroball.physic.Vector2D;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

@Slf4j
public class GraphicsUtil {

    /**
     * Create concentric Ring
     */
    public static Shape createConcentricRingShape(
            Vector2D center, double outerRadius, double thickness) {
        Ellipse2D outer = new Ellipse2D.Double(
                center.getXAsFloat() - outerRadius,
                center.getYAsFloat() - outerRadius,
                outerRadius + outerRadius,
                outerRadius + outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
                center.getXAsFloat() - outerRadius + thickness,
                center.getYAsFloat() - outerRadius + thickness,
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

    /**
     * Paint and draw a circle
     */

    public static void paintCircle(Graphics graphics, int radius, Color color, Vector2D location) {
        graphics.setColor(color);
        graphics.fillOval(location.getX() - radius, location.getY() - radius, 2 * radius, 2 * radius);
    }

    public static void drawCircle(Graphics graphics, int radius, Color color, Vector2D origin) {
        graphics.setColor(color);
        graphics.drawOval(origin.getX() - radius, origin.getY() - radius, 2 * radius, 2 * radius);
    }


    /**
     * Paint and draw Arch and pointers
     */

    public static void paintArch(Graphics graphics, Vector2D location, Color color, int radius, int direction, int arcWidth) {
        graphics.setColor(color);
        graphics.fillArc(location.getX() - radius, location.getY() - radius, 2 * radius,
                2 * radius, direction, arcWidth);
    }


    // Paints the arch pointing in the direction of the direction vector
    // The origin of the arch is in the middle of the arch and not on the point
    // The fillArch method draws the image with the coordinates in the TOP right corner.
    public static void paintCharacterPointer(Graphics graphics, Color color, Vector2D location, Vector2D direction, int r) {
        paintCharacterPointer(graphics, color, location, direction, r, 35);
    }

    public static void paintCharacterPointer(Graphics graphics, Color color, Vector2D location, Vector2D direction, int r, int pointerWidth) {
        graphics.setColor(color);
        // Translate to origin
        int originX = location.getX() - r;
        int originY = location.getY() - r;
        int angleTo = location.getAngleTo(direction);
        int angleToStartPaint = angleTo + 180 - pointerWidth / 2;
        int dx = (int) (r * Math.cos(Math.toRadians(angleTo)));
        int dy = (int) (-1 * r * Math.sin(Math.toRadians(angleTo)));
        graphics.fillArc(originX + dx, originY + dy, 2 * r, 2 * r,
                angleToStartPaint, pointerWidth);
    }


    /*
     * Draw line
     * */

    public static void drawLine(Graphics graphics, Color color, Vector2D p1, Vector2D p2) {
        graphics.setColor(color);
        graphics.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public static void drawLine(Graphics graphics,  Color color, int thickness, Vector2D start, Vector2D stop) {

        // The thick line is in fact a filled polygon
        graphics.setColor(color);
        int dX = stop.getX() - start.getX();
        int dY = stop.getY() - start.getY();
        // line length
        double lineLength = Math.sqrt(dX * dX + dY * dY);

        double scale = (double) (thickness) / (2 * lineLength);

        // The x,y increments from an endpoint needed to create a rectangle...
        double ddx = -scale * (double) dY;
        double ddy = scale * (double) dX;
        ddx += (ddx > 0) ? 0.5 : -0.5;
        ddy += (ddy > 0) ? 0.5 : -0.5;
        int dx = (int) ddx;
        int dy = (int) ddy;

        // Now we can compute the corner points...
        int xPoints[] = new int[4];
        int yPoints[] = new int[4];

        xPoints[0] = start.getX() + dx;
        yPoints[0] = start.getY() + dy;
        xPoints[1] = start.getX() - dx;
        yPoints[1] = start.getY() - dy;
        xPoints[2] = stop.getX() - dx;
        yPoints[2] = stop.getY() - dy;
        xPoints[3] = stop.getX() + dx;
        yPoints[3] = stop.getY() + dy;

        graphics.fillPolygon(xPoints, yPoints, 4);

    }


}
