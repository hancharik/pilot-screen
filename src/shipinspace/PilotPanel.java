/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class PilotPanel extends JPanel implements ActionListener, KeyListener{

    
    
    JButton ship;
    int shipSize = 8;
    double shipEngine = 1.0;  // default = 1.0   range is between 1 and 100 (above 100 is starship class, 1-100 is interplanetary ship)
    double globalMultiplier = 0.01;  // 0.01 is the default, i think that value works best, just wanted control over it...    
        // thrust sets a value in a world where warp 1.0 = 100.0.  minimum is 0.01, less than .01 is interplanetary ship only (like shuttlecraft or something)  
        // so, if thrust is equal to 100.0, every time you press the button you increase your speed by warp 1
        // right now warp isn't logarithmic, so we need to fix that... 03/13/16
        double thrust = shipEngine * globalMultiplier;
    
    
    
    
    Timer t;
    int x = 600;
    int y= 600;
    
    
    double xPosition = 600.237;
    double yPosition = 600.237;
    
    
    double xVelocity = 0.00;
    double yVelocity = 0.00;
    
    
   
    
    int height = 1080;
    int width = 1920;
    
    int tempX = 0;
    int tempY = 0;
    double angleOfMovement = 0.0;
    
    int realgx;// = (galaxyX/21)%20-1;
    int realgy;// = (galaxyY/21)%20-1; //int realgy = galaxyY/21;   
    int realx;// = (21-(Math.abs(galaxyX)%21))-1;
    int realy;// = (21-(Math.abs(galaxyY)%21))-1;
    
    double distanceTravelled = 0.0;
    
    int speed = 0;
    
    JLabel readout = new JLabel("readout");
    
        int galaxyX = -845251357;
                   
    int galaxyY = -978734625;
    MainPanel mainScreen;
    
    RoundButton planet;// = new RoundButton();
    
    
    int counter = 0;
    
    public PilotPanel(int w, int h, MainPanel m) {
        
        super(true);
        
        height = h;
        width = w;
        mainScreen = m;
        init();
        
    }

    private void init(){
        
        setLayout(null);
        setBackground(Color.BLACK);
        
        ship = new JButton();
        ship.setBounds(x,y,shipSize,shipSize);
        ship.setBackground(Color.WHITE);
        ship.addKeyListener(this);
        add(ship);
        
        
        planet = new RoundButton();
        planet.setBackground(Color.green);
        planet.setBounds(400,200,400,400);
        planet.setVisible(false);
        add(planet);
        
        
     
        //readout = new JLabel("readout");
    //    readout.setBounds(100,100,300,60);
     //   readout.setForeground(Color.yellow);
      //  add(readout);
      
      
        t = new Timer(2, this);
        t.start();
    }


    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       int keyCode = ke.getKeyCode();

      
            if (keyCode == KeyEvent.VK_LEFT) {
            
             xVelocity = xVelocity - thrust;
            
         
        }
       
            if (keyCode == KeyEvent.VK_RIGHT) {
            
             xVelocity = xVelocity + thrust;
            
         
        }
            
            if (keyCode == KeyEvent.VK_DOWN) {
            
             yVelocity =yVelocity + thrust;
            
         
        }
            
            if (keyCode == KeyEvent.VK_UP) {
            
              yVelocity =yVelocity - thrust;
            
         
        }
      if (keyCode == KeyEvent.VK_SPACE) {
            
              xVelocity = 0;
                 yVelocity = 0;
            
         
        }
   
    }
                  
                  
        //Ctrl, Enter, or Space can be used to fire weapon
     //   case KeyEvent.VK_CONTROL:
     //   case KeyEvent.VK_ENTER:
       
          

   

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        String choice = event.getActionCommand();

        if (obj == t) {
            
            moveShip();
            checkForWrap();
            displayStats();
            
            
           // readout.setText("xVelocity: "+ xVelocity+", yVelocity: "+ yVelocity);
            
    //setBackground(Color.BLACK);
        }
        
        
        
        
        
        
        
    }  // end action listener

    
   private void getAngle(boolean tooFastForOdometer){
       boolean fastTravel = tooFastForOdometer;
       
       int grabX = Math.abs(ship.getX());
       int grabY = Math.abs(ship.getY());
       
       
       double distance = Math.sqrt((grabX-tempX)*(grabX-tempX)+(grabY-tempY)*(grabY-tempY));
       
       // above warp 12.6 we loose the odometer, so we added this
       if(fastTravel){
        distanceTravelled = distanceTravelled + distance;   
       }
    //    distanceTravelled = distanceTravelled + distance;
       // set sensitivity for compass
        // set sensitivity for compass
       int surveyDistance = 242;
       
       if(speed < 20){
         surveyDistance = 11;  
       }
        if(speed < 10){
         surveyDistance = 1;  
       }
       
       
       
       
       if(distance > surveyDistance){
           
          
       angleOfMovement = getAngleInDegrees(tempX, tempY, grabX, grabY);
       tempX = grabX;
       tempY = grabY;   
         
       // add to the odometer
       distanceTravelled = distanceTravelled + distance;   
       
       }
       
     
   
   }
    
    
   
    
    
    
    private void displayStats(){
        
        realgx = (21 - (Math.abs((galaxyX / 21)) % 21)) - 1;//Math.abs((galaxyX / 21) % 20 - 1);
        realgy = (21 - (Math.abs((galaxyY / 21)) % 21)) - 1;//= Math.abs((galaxyY / 21) % 20 - 1);//(galaxyY / 21) % 20 - 1; //int realgy = galaxyY/21;   
        realx = (21 - (Math.abs(galaxyX) % 21)) - 1;
        realy = (21 - (Math.abs(galaxyY) % 21)) - 1;
        
          mainScreen.smallX = realx;
       mainScreen.smallY = realy;
       mainScreen.bigX = realgx;
       mainScreen.bigY = realgy;
        
        
       
       int xHere = (int)Math.abs(Math.ceil(xVelocity));
       int yHere = (int)Math.abs(Math.ceil(yVelocity));
       String tempReadout = "zooom!!!!!";
      double converted = 0.0;
      
      if(xHere > yHere){
           converted = (double)xHere/100.0;
        speed = xHere*100;
       }else{
           converted = (double)yHere/100.0;
           speed = yHere;
       }
      
      
      
      if(converted < 0.01){
         double impulseSpeed;   
       if(xHere > yHere){
          // converted = (double)xHere/100.0;
          impulseSpeed = (xVelocity*100);//(int)xVelocity*100;
       }else{
          //  converted = (double)yHere/100.0;
           impulseSpeed = (yVelocity*100);//(int)yVelocity*100;
       }
       impulseSpeed = Math.abs(impulseSpeed);
       int degreesToTwo = (int)(Math.ceil(angleOfMovement));
       tempReadout ="impulse speed " +  (int)impulseSpeed + " || " + degreesToTwo + " degrees"   + " || " + " distance = " + (int)distanceTravelled; // convert distance travelled to int for readout
      getAngle(false);
      // tempReadout = "speed = " + speed + ",  impulse speed " +  (int)impulseSpeed + " || " + degreesToTwo + " degrees"   + " || " + " distance = " + (int)distanceTravelled; // convert distance travelled to int for readout
      
      } else if(converted < .10){
         double impulseSpeed;   
       if(xHere > yHere){
          // converted = (double)xHere/100.0;
          impulseSpeed = (xVelocity*100);//(int)xVelocity*100;
       }else{
          //  converted = (double)yHere/100.0;
           impulseSpeed = (yVelocity*100);//(int)yVelocity*100;
       }
       impulseSpeed = Math.abs(impulseSpeed);
       int degreesToTwo = (int)(Math.ceil(angleOfMovement));
       tempReadout = "impulse speed " +  (int)impulseSpeed + " || " + degreesToTwo + " degrees"   + " || " + " distance = " + (int)distanceTravelled; // convert distance travelled to int for readout
      
      getAngle(false); 
      } else if(converted < 1.0){
       int degreesToTwo = (int)(Math.ceil(angleOfMovement));
        tempReadout =  + converted + "% warp || " + degreesToTwo + " degrees"    + " || " + " distance = " + (int)distanceTravelled ;  // convert distance travelled to int for readout
       getAngle(true); 
      } else{
            
       
       int degreesToTwo = (int)(Math.ceil(angleOfMovement));
        tempReadout =  "warp " + converted + " || " + degreesToTwo + " degrees"    + " || " + " distance = " + (int)distanceTravelled ;  // convert distance travelled to int for readout
       getAngle(true); 
              }
      
      
      
    
       
     
        
        
        
        
        

        if(mainScreen.travelling == true){
         setLabel1(tempReadout);
    }
       
        
        
        
    }
    
    
    
    
    
    private void moveShip() {

        yPosition = yPosition + yVelocity;
        xPosition = xPosition + xVelocity;

        int gotoX = (int) xPosition;
        int gotoY = (int) yPosition;
        
      
            ship.setLocation(gotoX,gotoY);//.setBounds(gotoX,gotoY, shipSize, shipSize);
   
   
        
        
        
    }

    public void checkForWrap() {

        if (ship.getX() > width) {
            ship.setLocation(0, ship.getY());
            xPosition = 0.0;
             galaxyX++;
     mainScreen.travelling = true;
      tempX = ship.getX();
       tempY = ship.getY();
        }

        if (ship.getX() <0) {
            ship.setLocation(width, ship.getY());
            xPosition = (double)width;
             galaxyX--;
        mainScreen.travelling = true;
         tempX = ship.getX();
       tempY = ship.getY();
        }
        if (ship.getY() > height) {
            ship.setLocation(ship.getX(),0);
            yPosition = 0.0;
             galaxyY++;
  mainScreen.travelling = true;
   tempX = ship.getX();
       tempY = ship.getY();
        }

        if (ship.getY() < 0) {
            ship.setLocation(ship.getX(),height);
            yPosition = (double)height;
             galaxyY--;
      mainScreen.travelling = true;
       tempX = ship.getX();
       tempY = ship.getY();
        }
         if(realx==10 && realy==10){
            //readout.setText("SOLAR SYSTEM!!!!! FUCK YES BABY!!!! WHOOOOOOO!!!!!!!!!!!!!!!!");
            setBackground(Color.YELLOW);
          
         }else if(realx==9 && realy==9){
            //readout.setText("SOLAR SYSTEM!!!!! FUCK YES BABY!!!! WHOOOOOOO!!!!!!!!!!!!!!!!");
         
            planet.setVisible(true);
         }else{
            setBackground(Color.BLACK); 
             planet.setVisible(false);
         }
        
    }  // end check for y wrap

 
        
    public int getGx(){
           int realx = (20-(Math.abs(galaxyX)%21));
    
        return realx;
    }    
        
       public int getGy(){
            int realy = (20-(Math.abs(galaxyY)%21));
        return realy;
    }  
    
    
   public void  drawQuadrant(){
       
       if((Math.abs(galaxyX)%21)-10==0 && (Math.abs(galaxyY)%21)-10==0){
           readout.setText("this is the center of the solar system!!!! = galaxy x val :" + galaxyX + ", galaxy y val :" + galaxyX); 
     // 
      
   } 
    
        
   }    
        
        
        
    public void setLabel1(String s){
        
    mainScreen.setReadout1(s);
         
 
       
         mainScreen.setReadout2("Galaxy Coordinates: (" +  realgx + "," +  realgy  + ")");
        //mainScreen.setReadout2("Galaxy Coordinates: (" +(Math.abs(galaxyX)/21)+ "," +(Math.abs(galaxyY)/21)+ ")");
          mainScreen.setReadout3("Local Coordinates: (" +realx+ "," +realy+ ")");
 
          
    
          
          
       // String plusminusX = "+";
       // String plusminusY = "-";
       // String tempReadout = "You are really at :  (" + galaxyX + "," + galaxyY + ")";
        //readout.setText(tempReadout);
 
    }    
        
        
        
        
        
    
   //http://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees
public static double getAngleInDegrees(double x, double y, double x2, double y2) {
    double angle = (double) Math.toDegrees(Math.atan2(y2 - y, x2 - x));

    if(angle < 0){
        angle += 360;
    }

    return angle;
}   
        
        
        
        
        
        
        
    
}  // end class
