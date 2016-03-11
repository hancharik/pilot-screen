
package shipinspace;



import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class RoundButton extends JButton {
    
        double xVel = 0.0;
    double yVel = 0.0;
    int speedLimit;// 
    double mass = 1.0;// = space.Space.globalParticleMass;
    
    
  public RoundButton() {
    super();

// These statements enlarge the button so that it 
// becomes a circle rather than an oval.
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, 
      size.height);
    setPreferredSize(size);

// This call causes the JButton not to paint 
   // the background.
// This allows us to paint a round background.
    setContentAreaFilled(false);
  }

// Paint the round background and label.
  protected void paintComponent(Graphics g) {
      BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)bufferedImage.getGraphics();
    if (getModel().isArmed()) {
// You might want to make the highlight color 
   // a property of the RoundButton class.
      g.setColor(Color.lightGray);
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON ));
    } else {
      g.setColor(getBackground());
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON ));
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);

// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
  }

// Paint the border of the button using a simple stroke.
  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width-1, 
      getSize().height-1);
  }

// Hit detection.
  Shape shape;
  public boolean contains(int x, int y) {
// If the button has changed size, 
   // make a new shape object.
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }

    
        public void setColor(){
         
         Color whatsMyColor = Color.red;
         int sl = 40;//space.Space.globalSpeedlimit;
         
         if(speedLimit * 100 > sl * 80){
            whatsMyColor = Color.RED; 
         }else if(speedLimit * 100 > sl * 70){
           whatsMyColor = Color.ORANGE;  
         }else if(speedLimit * 100 > sl * 50){
           whatsMyColor = Color.YELLOW;  
         }else if(speedLimit * 100 > sl * 40){
            whatsMyColor = Color.GREEN; 
         }else if(speedLimit * 100 > sl * 30){
            whatsMyColor = Color.BLUE; 
         }else if(speedLimit * 100 > sl * 20){
           whatsMyColor = Color.MAGENTA;  
         }else{
           whatsMyColor = Color.WHITE;   
         }
             
     
      this.setBackground(whatsMyColor);
         
     }
       
     
     
     public void move(){
     //speedLimit = arena.Arena.screen.gamePanel.speedspeedit;
         int negativeSpeedLimit = speedLimit - (speedLimit*2);
         
         if(xVel > speedLimit){
             xVel = speedLimit;
         }else  if(xVel < negativeSpeedLimit){
             xVel = negativeSpeedLimit;
         }
         
         if(yVel > speedLimit){
             yVel = speedLimit;
         }else if(yVel < negativeSpeedLimit){
             yVel = negativeSpeedLimit;
         }
         
     this.setLocation(this.getX() + (int)xVel, this.getY() + (int)yVel); 
     
     
     
     
     
  }  
    
   
} // end