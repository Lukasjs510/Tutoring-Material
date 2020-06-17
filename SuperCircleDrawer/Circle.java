import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Circle
{
   private int diameter;
   private int xPosition;
   private int yPosition;
   private String color;
   private boolean isVisible;
   
   /**
    * Create a new circle at default position with default color.
    */
   public Circle()
   {
      this.diameter = 30;
      this.xPosition = 20;
      this.yPosition = 60;
      this.color = "blue";
      this.isVisible = false;
   }
   
   /**
    * Create a new circle with specified diameter.
    */
   public Circle(int size)
   {
      this.diameter = size;
      this.xPosition = 20;
      this.yPosition = 60;
      this.color = "blue";
      this.isVisible = false;
   }
   
    /**
     * Move to specified location
     */
    public void moveTo(int x, int y)
    {
        this.erase();
        this.xPosition = x;
        this.yPosition = y;
        this.draw();
    }
    
    /**
    * An accessor for returning the diameter.
    */
   public int getDiameter()
   {
      return this.diameter;    
   }
   
   /**
    * Make this circle visible. If it was already visible, do nothing.
    */
   public void makeVisible()
   {
      this.isVisible = true;
      this.draw();
   }
   
   /**
    * Make this circle invisible. If it was already invisible, do nothing.
    */
   public void makeInvisible()
   {
      this.erase();
      this.isVisible = false;
   }
   
   /**
    * Move the circle a few pixels to the right.
    */
   public void moveRight()
   {
      this.moveHorizontal(20);
   }
   
   /**
    * Move the circle a few pixels to the left.
    */
   public void moveLeft()
   {
      this.moveHorizontal(-20);
   }
   
   /**
    * Move the circle a few pixels up.
    */
   public void moveUp()
   {
      this.moveVertical(-20);
   }
   
   /**
    * Move the circle a few pixels down.
    */
   public void moveDown()
   {
      this.moveVertical(20);
   }
   
   /**
    * Move the circle horizontally by 'distance' pixels.
    */
   public void moveHorizontal(int distance)
   {
      this.erase();
      this.xPosition += distance;
      this.draw();
   }
   
   /**
    * Move the circle vertically by 'distance' pixels.
    */
   public void moveVertical(int distance)
   {
      this.erase();
      this.yPosition += distance;
      this.draw();
   }
   
   /**
    * Slowly move the circle horizontally by 'distance' pixels.
    */
   public void slowMoveHorizontal(int distance)
   {
      int delta;
      
      if(distance < 0) 
      {
         delta = -1;
         distance = -distance;
      }
      else 
      {
         delta = 1;
      }
      
      for(int i = 0; i < distance; i++)
      {
         this.xPosition += delta;
         this.draw();
      }
   }
   
   /**
    * Slowly move the circle vertically by 'distance' pixels.
    */
   public void slowMoveVertical(int distance)
   {
      int delta;
      
      if(distance < 0) 
      {
         delta = -1;
         distance = -distance;
      }
      else 
      {
         delta = 1;
      }
      
      for(int i = 0; i < distance; i++)
      {
         this.yPosition += delta;
         this.draw();
      }
   }
   
   /**
    * Change the size to the new size (in pixels). Size must be >= 0.
    */
   public void changeSize(int newDiameter)
   {
      this.erase();
      this.diameter = newDiameter;
      this.draw();
   }
   
   /**
    * Change the color. Valid colors are "red", "yellow", "blue", "green",
    * "magenta" and "black".
    */
   public void changeColor(String newColor)
   {
      this.color = newColor;
      this.draw();
   }
   
   /*
    * Draw the circle with current specifications on screen.
    */
   private void draw()
   {
      if(isVisible) {
         Canvas canvas = Canvas.getCanvas();
         canvas.draw(this, this.color, new Ellipse2D.Double(this.xPosition, this.yPosition, 
                                                       this.diameter, this.diameter));
         canvas.wait(10);
      }
   }
   
   /*
    * Erase the circle on screen.
    */
   private void erase()
   {
      if(isVisible) {
         Canvas canvas = Canvas.getCanvas();
         canvas.erase(this);
      }
   }
}
