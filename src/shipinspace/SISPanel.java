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
public class SISPanel extends JPanel implements ActionListener, KeyListener{

    JButton ship;
    int shipSize = 20;
    Timer t;
    int x = 600;
    int y= 600;
    double xPosition = 600.237;
    double yPosition = 600.237;
    double xVelocity = 0.00;
    double yVelocity = 0.00;
    double thrust = 0.12;
    
    int height = 1080;
    int width = 1920;
    
    
    int realgx;// = (galaxyX/21)%20-1;
    int realgy;// = (galaxyY/21)%20-1; //int realgy = galaxyY/21;   
    int realx;// = (21-(Math.abs(galaxyX)%21))-1;
    int realy;// = (21-(Math.abs(galaxyY)%21))-1;
    
    JLabel readout = new JLabel("readout");
    
        int galaxyX = -845251357;
                   
    int galaxyY = -978734625;
    MainPanel mainScreen;
    
    
    int counter = 0;
    
    public SISPanel(int w, int h, MainPanel m) {
        
        super();
        
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
        
        readout = new JLabel("readout");
        readout.setBounds(100,100,300,60);
        readout.setForeground(Color.yellow);
        add(readout);
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
            
    //setBackground(Color.BLACK);
        }
        
        
        
        
        
        
        
    }  // end action listener

    
    
    private void displayStats(){
        
        realgx = (21 - (Math.abs((galaxyX / 21)) % 21)) - 1;//Math.abs((galaxyX / 21) % 20 - 1);
        realgy = (21 - (Math.abs((galaxyY / 21)) % 21)) - 1;//= Math.abs((galaxyY / 21) % 20 - 1);//(galaxyY / 21) % 20 - 1; //int realgy = galaxyY/21;   
        realx = (21 - (Math.abs(galaxyX) % 21)) - 1;
        realy = (21 - (Math.abs(galaxyY) % 21)) - 1;
        
          mainScreen.smallX = realx;
       mainScreen.smallY = realy;
       mainScreen.bigX = realgx;
       mainScreen.bigY = realgy;
        
        
        
        String tempReadout = "realx:  " + realx + ", realy: " + realy + ", realgx: " +   realgx  + ", realgy: " +  realgy;

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
        }

        if (ship.getX() <0) {
            ship.setLocation(width, ship.getY());
            xPosition = (double)width;
             galaxyX--;
        mainScreen.travelling = true;
        }
        if (ship.getY() > height) {
            ship.setLocation(ship.getX(),0);
            yPosition = 0.0;
             galaxyY++;
  mainScreen.travelling = true;
        }

        if (ship.getY() < 0) {
            ship.setLocation(ship.getX(),height);
            yPosition = (double)height;
             galaxyY--;
      mainScreen.travelling = true;
        }
         if(realx==10 && realy==10){
            //readout.setText("SOLAR SYSTEM!!!!! FUCK YES BABY!!!! WHOOOOOOO!!!!!!!!!!!!!!!!");
            setBackground(Color.YELLOW);
         }else{
            setBackground(Color.BLACK);  
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
          mainScreen.setReadout3("Local Solar System Coordinates: (" +realx+ "," +realy+ ")");
 
        String plusminusX = "+";
        String plusminusY = "-";
        String tempReadout = "realx:  " + realx + ", realy: " + realy + ", realgx: " +   realgx  + ", realgy: " +  realgy;
        readout.setText(tempReadout);
 
    }    
        
        
        
        
        
        
        
        
        
        
        
        
    
}  // end class
