/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

import java.awt.Color;
  import java.util.Random;  
  import java.util.ArrayList;
/**
 *
 * @author mark
 */
public class SolarSystem extends Thing{
    
    Color color = Color.WHITE;
    String SolarSystemName;
    ArrayList<SolarSystemObject> solarSystem  = new ArrayList<SolarSystemObject>();
    ArrayList<String> solarSystemNameList  = new ArrayList<String>();
    public SolarSystemObject[][] solarSystemMap;
    SolarSystemObject[][] ssMap;
    
    
    
    public SolarSystem(){
        if (shipinspace.ShipInSpace.size < 30) {
            super.icon = " @ ";
        } else {
            super.icon = "@";
        }
        
        Sun sun = new Sun();
        
        
        Random rand = new Random();
        int objects = 1 + rand.nextInt( 10 );   // i think setting this to ten allows for a sun with no planets. pretty certain that's correct
        
        
        
        
        
        
        
        // this is just a switch statement with no break statements, so
        
        switch(objects){
            case 1 : Planet planet9 = new Planet(sun.name,9); solarSystem.add(planet9); solarSystemNameList.add(planet9.name);
            case 2 : Planet planet8 = new Planet(sun.name,8); solarSystem.add(planet8); solarSystemNameList.add(planet8.name);
            case 3 : Planet planet7 = new Planet(sun.name,7); solarSystem.add(planet7); solarSystemNameList.add(planet7.name);
            case 4 : Planet planet6 = new Planet(sun.name,6); solarSystem.add(planet6); solarSystemNameList.add(planet6.name);
            case 5 : Planet planet5 = new Planet(sun.name,5); solarSystem.add(planet5); solarSystemNameList.add(planet5.name);
            case 6 : Planet planet4 = new Planet(sun.name,4); solarSystem.add(planet4); solarSystemNameList.add(planet4.name);
            case 7 : Planet planet3 = new Planet(sun.name,3); solarSystem.add(planet3); solarSystemNameList.add(planet3.name);
            case 8 : Planet planet2 = new Planet(sun.name,2); solarSystem.add(planet2); solarSystemNameList.add(planet2.name);
            case 9 : Planet planet1 = new Planet(sun.name,1); solarSystem.add(planet1); solarSystemNameList.add(planet1.name); 
            
        
        }   
        
        solarSystem.add(sun);
        solarSystemNameList.add(sun.name);
        SolarSystemName = sun.name + " System";
        createSolarSystemMap();
    }
    
    /*public SolarSystemObject[][] createSolarSystemMap(int x, int y){
       SolarSystemObject[][] ssMap = new SolarSystemObject[10][10]; 
        
        return ssMap;
    }
    * */
    public void createSolarSystemMap(){
       ssMap = new SolarSystemObject[shipinspace.ShipInSpace.size][shipinspace.ShipInSpace.size]; 
        
       for(int i = 0; i < shipinspace.ShipInSpace.size; i++){
           for(int j = 0; j < shipinspace.ShipInSpace.size; j++){
              ssMap[i][j] = new EmptySolarSystemObject();
           }
       }
       
       

       //ssMap[shipinspace.ShipInSpace.size/2][shipinspace.ShipInSpace.size/2] = solarSystem.get(solarSystem.size()-1);
       for(int i = 0; i < solarSystem.size() - 1; i++){
           
       insertPlanets(i);
           
       }  // end for
       
       
       
       // add sun (last element of array) to center of map
       ssMap[shipinspace.ShipInSpace.size/2][shipinspace.ShipInSpace.size/2] = solarSystem.get(solarSystem.size()-1);
        solarSystemMap = ssMap;
    } // end create solar system map
    
    
    
    
    public int randomNumberInRange(){
        int randomInt = 0;
        Random randX = new Random();
        randomInt = 1 + randX.nextInt( shipinspace.ShipInSpace.size - 1 );
        return randomInt;
    } // end random number in range
    
    
    
   public void insertPlanets(int i){
        Random randX = new Random();
        int xCord = randomNumberInRange();//1 + randX.nextInt( shipinspace.ShipInSpace.size - 1 );
        Random randY = new Random();
        int yCord = randomNumberInRange();//1 + randY.nextInt( shipinspace.ShipInSpace.size - 1 );
        if(ssMap[xCord][yCord] == null){
        ssMap[xCord][yCord] = solarSystem.get(i);
        }else if(xCord!=shipinspace.ShipInSpace.size/2 && yCord!=shipinspace.ShipInSpace.size/2){
        ssMap[xCord][yCord] = solarSystem.get(i);
        }else{
            insertPlanets(i);
           // ssMap[i][j] = new EmptySolarSystemObject();
          //createSolarSystemMap();  
        }
   } // end insert planets
    
    
    
    
}  // end
