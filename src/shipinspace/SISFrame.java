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



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Mark
 */
public class SISFrame extends JFrame{
    
    
    MainPanel main;
    
    
    
  //  public SISPanel sisPanel;// = new GameJPanel();
  //  public ShipOnGround sog = new ShipOnGround();
   //public PicPanel pic;//  = new PicPanel();
 //  public Ninja ninja;// = new Ninja();
 //  public Monkey monkey;// = new Monkey();
 //  public Merchant merchant;// = new Monkey();
 //   public int size = drawpicture.DrawPicture.size;
   // private int lsize = size*21/10;
  //  private int hsize = size*22/10;
    
    int screenHeight = 1080;
    int screenWidth = 1920;
    
    public SISFrame(){//public SISFrame(int x, int y){
        
       
        super ("A Ship In Space.");
                getContentPane().setLayout(new BorderLayout());
               // sisPanel  = new SISPanel(screenWidth,screenHeight);
               main = new MainPanel();
            getContentPane().add(main,"Center");
               //  getContentPane().add(sog,"Center");
                
                /*
                Random rand = new Random();
                int xfactor = 1 + rand.nextInt(drawpicture.DrawPicture.type);
                switch(xfactor){
                    
                    case 1 : pic  = new PicPanel(); getContentPane().add(pic,"Center"); break;
                    case 2 : ninja = new Ninja(); getContentPane().add(ninja,"Center"); break;
                    case 3 :  monkey = new Monkey(); getContentPane().add(monkey,"Center"); break;
                    case 4 :  merchant = new Merchant(); getContentPane().add(merchant,"Center"); break;
                }
                
                */
               // dPanel = new DPanel();
              // pic  = new PicPanel();
              // ninja = new Ninja();
              // monkey = new Monkey();
              
               //  gamePanel.createScreen();   
              
		
                setDefaultCloseOperation(EXIT_ON_CLOSE);
	       
             setSize (screenWidth, screenHeight);
                 
               
               setLocation(0,0);
               
               
               
		setVisible(true);
    }
 
  
}
