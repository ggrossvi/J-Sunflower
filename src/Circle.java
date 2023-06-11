import java.awt.Color;
import java.awt.Graphics;
/**
 * Simple class that creates a Circle on a drawing panel.
 *
 * @author Gloria Villa
 * @version 2023-06-05
 */
public class Circle{
    // instance variables - replace the example below with your own
    private Color color;
    private double centerX;
    private double centerY;
    private double radius;
    

    /**
     * Constructor for objects of class Circle
     * 
     * @param   color       the color of the circle
     *          centerX     the x coordinate of the center of the circle 
     *          center Y    the Y coordinate of the center of the circle
     *          radius      the radius of the circle
     */
    public Circle(Color color, double centerX,double centerY, double radius) {
        // initialise instance variables
        if (color == null) {
            throw new IllegalArgumentException("Color must not be null.");
        }
        setColor(color); //this.color = color ask Barry
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    /**
     * Gets the color of the circle 
     *
     * @return    the color of the circle
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Gets the X of the center of the circle 
     *
     * @return    the X of the circle
     */
    public double getCenterX() {
        return centerX;
    }
    
    /**
     * Gets the Y of the center of the circle 
     *
     * @return    the Y of the circle
     */
    public double getCenterY() {
        return centerY;
    }
    
    
    /**
     * Gets the radius of the center of the circle 
     *
     * @return    the radius of the circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Sets the color of the circle 
     *
     * @param     color     sets the color of the circle   
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Sets the centerX of the circle 
     *
     * @param     centerX    sets the center of the circle  
     */
    
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }
    
    
    /**
     * Sets the centerY of the circle 
     *
     * @param     centerX    sets the centerY of the circle  
     */
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }
    
    /**
     * Sets the radius of the circle 
     *
     * @param     radius    sets the radius of the circle  
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // Finish Javadoc also might want to do round instead of using int   Math.round(n* 100.0 )/ 100.0) 
    /**
     * Draws the circle 
     *
     * @param    graphics    draws the circle on the panel
     *           drawSize    the size of the panel
     */
    public void draw(Graphics graphics, int drawSize) {
        double x = cartesianXToGraphics(drawSize,getCenterX());
        double y = cartesianYToGraphics(drawSize,getCenterY());
        int width = 2*(int)(this.getRadius());
        int height = 2*(int)(this.getRadius());
        graphics.fillOval((int)x,(int)y,width,height); // round instead of int
    }
    
    /**
     * Outputs get methods of the circle 
     *  
     */
    public String toString() {
        //System.out.printf("Circle centered at %s", getCenterX());
        return "Circle centered at (" + getCenterX() + "," + getCenterY() + ") with radius " + getRadius() + "\n" +
        "color java.awt.Color [" + getColor();
    }
    
    /**
     * Translates cartesian xValue to graphic xvalue 
     *
     * @param     drawWidth     the width of the panel
     *            x             the value of x
     */
    static double cartesianXToGraphics(int drawWidth, double x) {
        double xGraphics = (drawWidth/2) + x; 
        return xGraphics;
    }
    
    /**
     * Translates cartesian yValue to graphic yvalue 
     *
     * @param     drawWidth     the width of the panel
     *            y             the value of y
     */
    static double cartesianYToGraphics(int drawWidth, double y) {
        double yGraphics = (drawWidth/2) -y;
        return yGraphics;
    }
    
    //move main to an outside main class
    public static void main(String[] args) {
        // drawing size,radius,petal count 400,100,9
        Sunflower sunflower = new Sunflower(400,100,9);
        sunflower.draw();
        
        
    }
}
