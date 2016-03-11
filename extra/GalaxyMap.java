/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

import java.util.Random;

/**
 *
 * @author mark
 */
public class GalaxyMap {
    
    MainPanel main;
    
    private int size;// = 21; 
    SolarSystem[][] galaxyMap;// = new SolarSystem [size][size]; 
    int levelOfSolarSystems;// = 21; // 1-31, with 1 being highest level
    
    public GalaxyMap(MainPanel m){
     
        main = m;
       size = main.size; 
    galaxyMap = new SolarSystem [size][size]; 
    levelOfSolarSystems = 21; // 1-31, with 1 being highest level
       galaxyMap = createMap();
        
    }
    
    public SolarSystem[][] getMap(){
      return galaxyMap;  
    }
    
    public SolarSystem[][] createMap(){
       
      
      for (int i = 0; i < size; i++){
          for(int j = 0; j < size; j++){
              this.galaxyMap[i][j] = randomFill();
          }
      }
      
      
      return galaxyMap;
    }
    
    public SolarSystem randomFill(){
        SolarSystem fill = new EmptySolarSystem();
        Random rand = new Random();
        int chance = 1 + rand.nextInt( levelOfSolarSystems );
        switch(chance){
            case 1 : fill = new SolarSystem(); break;
            case 2 : fill = new EmptySolarSystem(); break;
            case 3 : fill = new EmptySolarSystem(); break;
            case 4 : fill = new EmptySolarSystem(); break;
            case 5 : fill = new EmptySolarSystem(); break;
            case 6 : fill = new EmptySolarSystem(); break;
            case 7 : fill = new EmptySolarSystem(); break;
            case 8 : fill = new EmptySolarSystem(); break;
            case 9 : fill = new EmptySolarSystem(); break;
            case 10 : fill = new EmptySolarSystem(); break;
            case 11 : fill = new EmptySolarSystem(); break;
            case 12 : fill = new EmptySolarSystem(); break;
            case 13 : fill = new EmptySolarSystem(); break;
            case 14 : fill = new EmptySolarSystem(); break;
            case 15 : fill = new EmptySolarSystem(); break;
            case 16 : fill = new EmptySolarSystem(); break;
            case 17 : fill = new EmptySolarSystem(); break;
            case 18 : fill = new EmptySolarSystem(); break;
            case 19 : fill = new EmptySolarSystem(); break;
            case 20 : fill = new EmptySolarSystem(); break;
            case 21 : fill = new EmptySolarSystem(); break;
            case 22 : fill = new EmptySolarSystem(); break;
            case 23 : fill = new EmptySolarSystem(); break;
            case 24 : fill = new EmptySolarSystem(); break;
            case 25 : fill = new EmptySolarSystem(); break;
            case 26 : fill = new EmptySolarSystem(); break;
            case 27 : fill = new EmptySolarSystem(); break;
            case 28 : fill = new EmptySolarSystem(); break;
            case 29 : fill = new EmptySolarSystem(); break;
            case 30 : fill = new EmptySolarSystem(); break;
            case 31 : fill = new EmptySolarSystem(); break;
        } 
        
        return fill;
    }
    
 public void printMap(){
        
        for(int i = 0; i < size; i++){
           for(int j = 0; j < size; j++){
               
                System.out.print(this.galaxyMap[i][j].icon);
               
           }
           System.out.println();
       }
       
        
    }  
 
 public void displayMapNames(){
     
     SolarSystem s1;
        
        for(int i = 0; i < size; i++){
           for(int j = 0; j < size; j++){
               
              // if(this.galaxyMap[i][j].equals(SolarSystem.class)){
                s1 = this.galaxyMap[i][j];   
                System.out.print("[" + i + "][" + j + "]" + s1.SolarSystemName);
             //  }else{
              //  System.out.print(i + j + " Empty Space");   
             //  }
               
           }
           System.out.println();
       }
       
        
    } 
}
