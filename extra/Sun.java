/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipinspace;


import java.awt.Color;
import java.util.Random;
/**
 *
 * @author mark
 */
public class Sun extends SolarSystemObject{
    
    public Sun(){
       super.name = getName(); 
       super.icon = "S";
       super.color = Color.YELLOW;
    }
    
    
    public String getName(){
        
        String first = "";
        String last = "";
        
        
        Random rand = new Random();
        int randFirst = 1 + rand.nextInt( 16 );
        int randLast = 1 + rand.nextInt( 16 );
        switch(randFirst){
            case 1: first = "Khal"; break;
            case 2: first = "Gan"; break;
            case 3: first = "Tyrus"; break;
            case 4: first = "Omno"; break;
            case 5: first = "Niym"; break;
            case 6: first = "Encantor"; break;
            case 7: first = "Hund"; break;
            case 8: first = "Pythori"; break;
            case 9: first = "Sool"; break;
            case 10: first = "Fhar"; break;
            case 11: first = "Zymbda"; break;
            case 12: first = "Luxiuo"; break;
            case 13: first = "Aelphi"; break;
            case 14: first = "Bitta"; break;
            case 15: first = "Aiddy"; break;
            case 16: first = "Zummo"; break;
        }
        switch(randLast){
            case 1: last = "dar"; break;
            case 2: last = "don"; break;
            case 3: last = "nius"; break;
            case 4: last = "dohr"; break;
            case 5: last = "eesian"; break;
            case 6: last = "androma"; break;
            case 7: last = "nius"; break;
            case 8: last = "gegan"; break;
            case 9: last = "laz"; break;
            case 10: last = "fraen"; break;
            case 11: last = "erxk"; break;
            case 12: last = "jnui"; break;
            case 13: last = "wrtxy"; break;
            case 14: last = "aldor"; break;
            case 15: last = "lumbda"; break;
            case 16: last = "hain"; break;    
        }
        
        String randomName = first + last;
        return randomName;
    }
    
    
    
}
