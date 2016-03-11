/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class ShipOnGround extends JPanel implements ActionListener, KeyListener{

    JButton ship;
    int shipSize = 20;
    Timer t;
    int x = 600;
    int y= 600;
    double xPosition = 600.237;
    double yPosition = 600.237;
    double xVelocity = 0.00;
    double yVelocity = 0.00;
    double thrust = 12.12;
    
    JLabel readout = new JLabel("readout");
    
    
    public ShipOnGround() {
        
        super();
        
        init();
        
    }

    private void init(){
        
        setLayout(null);
        setBackground(Color.GREEN);
        
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
            
             xPosition = xPosition - thrust;
            
         
        }
       
            if (keyCode == KeyEvent.VK_RIGHT) {
            
             xPosition = xPosition + thrust;
            
         
        }
            
            if (keyCode == KeyEvent.VK_DOWN) {
            
             yPosition =yPosition + thrust;
            
         
        }
            
            if (keyCode == KeyEvent.VK_UP) {
            
              yPosition =yPosition - thrust;
            
         
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
            
            ship.setBounds((int)xPosition,(int)yPosition,shipSize,shipSize);
            
         readout.setText("x val :" +xPosition+ ", y val :" +yPosition);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}  // end class
