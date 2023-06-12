import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Sunflower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sunflower
{
    private Color COLOR_CENTER = new Color(97,54,23);
    private Color COLOR_PETALS = new Color(252,206,1);
    
    private int drawingSize;                         
    private int radius;
    private int petalCount;

    /**
     * 
     * Constructor for objects of class Sunflower
     */
    public Sunflower(int drawingSize, int radius, int petalCount) {
        // add preconditions  
        this.drawingSize = drawingSize;
        this.radius = radius;
        this.petalCount = petalCount;
    }

    /**
     *
     *
     * Draws Sunflower
     *
     */
    public void draw() {
       
        Color sky = new Color(143,170,220); // add to panel background color
        
        DrawingPanel panel = new DrawingPanel(400,400);
        Graphics graphics = panel.getGraphics();
        panel.setBackground(sky);
        
        // the radius added and subtracted is to adjust for the left handed rectangle point
        Circle sunflowerCenterCircle = new Circle(COLOR_CENTER,0-radius,0+radius,radius);
        graphics.setColor(COLOR_CENTER);
        sunflowerCenterCircle.draw(graphics,drawingSize);
        sleepHalfSecond();
        graphics.setColor(COLOR_PETALS);
        //Circle[] petal = new Circle[petalCount];
        double radiansDividedByPetalCount = (2*Math.PI)/petalCount;
        
        for (int numPetals = 0; numPetals < petalCount; numPetals ++) {
            

            int scale2Radii = radius+(radius/2);
            // 1.5 creates consistent point(center of petal) from which to draw the left corner of square
            int scale1Radius= (int) (radius * 1.5);

            double y= (Math.sin(numPetals * radiansDividedByPetalCount)); // * numPetals to keep rotating it around the unit circle
//            double x = centerRadius*(Math.cos(numPetals*radiansDividedByPetalCount))*centerRadius; // * centerRadius to scale it +centerRadius/2
//            double y = centerRadius*(Math.sin(numPetals*radiansDividedByPetalCount))*(centerRadius+centerRadius/2);

            double x =  (Math.cos(numPetals*radiansDividedByPetalCount));
            double xScaled = scale1Radius * x ; // * radius to scale it +centerRadius/2 on Y to get the y coordinates for height
            double yScaled = scale1Radius * y ;
            double xTransposed = xScaled - radius/2;
            double yTransposed = yScaled + radius/2;// is positive because it is flipped in cartesian

            Circle petal = new Circle(COLOR_PETALS,xTransposed,yTransposed,radius/2);
            petal.draw(graphics,drawingSize);
            sleepHalfSecond();
            petal.toString();
        }
    }
    
    private void sleepHalfSecond() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished. No exception happened!");
        }
    }

    
    /*
     * 
     * private void checkNonNegative(double numberToCheck, String identifier) {
        if (numberToCheck < 0.0) {
            throw new IllegalArgumentException(identifier + " must not be negative");
        }
    }
    
    public void setMoonCount(int moonCount) {
        checkNonNegative(moonCount, "moonCount");
        this.moonCount = moonCount;
    }
     * 
     */
}
