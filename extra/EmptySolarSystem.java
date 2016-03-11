/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author mark
 */
public class EmptySolarSystem extends SolarSystem{
    
    EmptySolarSystemObject empty = new EmptySolarSystemObject();
   // ArrayList<String> solarSystemNameList  = new ArrayList<String>();
    public EmptySolarSystem(){
        
        super.SolarSystemName = "Empty Space";
        super.solarSystem.clear();
        super.solarSystemNameList.clear();
        super.solarSystem.add(empty);
        super.solarSystemNameList.add("Empty Space");
        super.color = Color.BLACK;
        
        if (shipinspace.ShipInSpace.size < 30) {
            super.icon = "   ";
        } else {
            super.icon = " ";
        }
    }
    
    
    
}
