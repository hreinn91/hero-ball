package heroball.progii;

import java.awt.*;  // For Color and Graphics

public class Ball {

    private int x;    // x-position
    private int y;    // y-position
    private int dx;   // speed in x direction
    private int dy;   // speed in y direction
    private int r;    // radius
    private Color c;  // guess!
    private Hall h;   // the room

    public Ball(Hall h, int x, int y, int dx, int dy) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        r = 10;
        c = new Color((float)Math.random(),
                (float)Math.random(),
                (float)Math.random()); // Random color
    }
    public void move() {
        x += dx;
        y += dy;
        if (y>h.getHeight()) {
            y = h.getHeight()-r-2;  // Keep it above the floor!
        }
        if(dy!=0 || y!=h.getHeight()-r-2){
            dy++;                 // The effect of the gravity, keep it above the floor
        }
        // Collision with the floor
        if (y >= h.getHeight()-r-2 && dy>0) {
            dy = -dy;
            dy = dy + 2;        // Friction in the bounce
        }

        // Collison with the roof
        if (y<r && dy<0) {
            dy = -dy;
        }

        // Collision with walls
        if (x<r && dx < 0 ||               // left wall
                x > h.getWidth()-r && dx>0) {  // right wall
            dx = -dx;
        }

    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval(x-r, y-r, 2*r, 2*r);
    }
    public int getDy(){
        return this.dy;
    }

    public int getDx(){
        return this.dx;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public int getR(){
        return this.r;
    }

}