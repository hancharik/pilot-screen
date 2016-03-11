/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class MainPanel extends JPanel implements ActionListener{
    
    SISPanel spaceview;
    JLabel readout1;
    JLabel readout2;
    JLabel readout3;
    
   //  public GalaxyMapPanel galaxyMapPanel;
  //  public SolarSystemMapPanel solarSystemMapPanel;
    
        
     public JPanel galaxyMapPanel;
    public JPanel solarSystemMapPanel;
    
    int sizegmap = 21;
    int sizesmap = 21;
  
    JButton[][] bigButtons;
     JButton[][] smallButtons;
    
     Timer mainTimer;
     
    int counter = 1; 
     
    int smallX = 11;
    int smallY = 11;
   int bigX = 11;
   int bigY = 11;
    
   boolean travelling = false;
   boolean showTrail = false;
    
    public  MainPanel(){
    
        super();
        
        init();
        
      

        
     }  // end constructor
    
    
  private void init(){
      
      setLayout(null);
      
      smallButtons = new JButton[sizesmap][sizesmap];
       bigButtons = new JButton[sizegmap][sizegmap];
      mainTimer = new Timer(100, this);
      mainTimer.start();
      
      
      Color wangsBlue = new Color(162, 223, 254);
        setBackground(wangsBlue);
      int viewSize = 420;
      int viewWidth = viewSize*3;
      int viewHeight = viewSize*2;
      
          readout1 = new JLabel("1");
      readout1.setBounds(940, 940, 300, 40);
      readout2 = new JLabel("2");
      readout2.setBounds(240, 470, 300, 40);
      readout3 = new JLabel("3");
      readout3.setBounds(240, 940, 300, 40);
      
      
      add(readout1);
    add(readout2);
   add(readout3);
      
      
      
     
      
      galaxyMapPanel = createGalaxyMap();//galaxyMapPanel = createGalaxyMap();
      galaxyMapPanel.setBounds(40,40,viewSize,viewSize);
      
   add(galaxyMapPanel);
      
      solarSystemMapPanel = createSolarSystemMap();
      
      solarSystemMapPanel.setBounds(40,500,viewSize,viewSize);
     add(solarSystemMapPanel);
      

       spaceview = new SISPanel(viewWidth,viewHeight, this);
      spaceview.setBounds(600,40,viewWidth,viewHeight);
      add(spaceview);
      
      //colorGbutton(6,5);
     // colorSSbutton(2,8);
      
      repaint();
      
      

      
      // this didn't work here! :(  .. trying JFrame next...  fuck yes! it worked.
    // spaceview.ship.requestFocus();
      
      
      
  }  // end init
    
   
    private JPanel createGalaxyMap() {
        JPanel temp = new JPanel();
       
         temp.setLayout(new GridLayout(sizegmap, sizegmap));
        for (int i = 0; i < sizegmap; i++) {
            for (int j = 0; j < sizegmap; j++) {
            JButton b = new JButton();
            b.setBackground(Color.BLACK);
           bigButtons[i][j] = b;
            temp.add(b);
        }
        }
        return temp;
    }

    private JPanel createSolarSystemMap() {
        JPanel temp = new JPanel();
       
        temp.setLayout(new GridLayout(sizesmap, sizesmap));
        for (int i = 0; i < sizesmap; i++) {
            for (int j = 0; j < sizesmap; j++) {
            JButton b = new JButton();
             b.setBackground(Color.BLACK);
            smallButtons[i][j] = b;
            temp.add(b);
        }
        }
        return temp;
    }

    
  public void colorGbutton(){
      
      if(!showTrail){
      
        for (int iq = 0; iq < (sizesmap); iq++) {
            for (int jq = 0; jq < (sizesmap); jq++) {
            
            bigButtons[iq][jq].setBackground(Color.BLACK);
           
        }
        }
        
      } 
        
       bigButtons[bigY][bigX].setBackground(Color.GREEN);
        for (int ix = 0; ix< (sizegmap); ix++) {
            for (int jx = 0; jx < (sizegmap); jx++) {
            
            bigButtons[ix][jx].repaint();
           
        }
        }
         galaxyMapPanel.repaint();
     
  }  
    
     public void colorSSbutton(){
          if(!showTrail){
       for (int i = 0; i < (sizesmap); i++) {
            for (int j = 0; j < (sizesmap); j++) {
            
            smallButtons[i][j].setBackground(Color.BLACK);
           if(i == 10 && j == 10){
             smallButtons[i][j].setBackground(Color.YELLOW);  
           }
        }
        }
          }
       smallButtons[smallY][smallX].setBackground(Color.GREEN);
        for (int i = 0; i < (sizesmap); i++) {
            for (int j = 0; j < (sizesmap); j++) {
            
            smallButtons[i][j].repaint();
           
        }
        }
        solarSystemMapPanel.repaint();
        
  }  
    
    
    
  public void setReadout1(String entry){
      
    readout1.setText(entry);

  }
  
    
  public void setReadout2(String entry){
      
    readout2.setText(entry);

  }
  
    
  public void setReadout3(String entry){
      
    readout3.setText(entry);

  }

  
  
    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        String choice = event.getActionCommand();

        if (obj == mainTimer) {
          
            if(counter%30==0){
           // setBackground(Color.white);
        }else{
             setBackground(Color.blue);   
                }
            
            if(travelling){
              colorSSbutton();  
         colorGbutton();   
            }
            
          
      setReadout1("smallX: "+ smallX +", smallY: "+ smallY);
            
           counter++; 
        }
        
        
        
        
        
        
        
    }  // end action listener
  
  
  
  
  
    
}  // end class
