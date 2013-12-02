
package candycrush.utils;

import candycrush.configuration.Configuration;
import candycrush.entities.Candy;
import candycrush.entities.EnumCandy;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author smoranbl
 */
public class GetElement {
    public int getRandom(int size){
        Random random = new Random();        
        int number = random.nextInt(size);
        
        return number;
    }
    
    public EnumCandy getRandomEnumCandy(){                
        switch(this.getRandom(6)){
            case 0:
                return EnumCandy.BLUE;               
            case 1:
                return EnumCandy.GREEN;                
            case 2:
                return EnumCandy.ORANGE;                
            case 3:
                return EnumCandy.PURPLE;                
            case 4:
                return EnumCandy.RED;                
            case 5:
                return EnumCandy.YELLOW;
            default:
                return null;
        }
    }   
    
    public int getPositionX(int coordinateX){
        return coordinateX * Configuration.CELL_SIZE_X;
    }
    
    public int getPositionY(int coordinateY){
        return coordinateY * Configuration.CELL_SIZE_Y;
    }
    
    public Candy getCandyOnMouse(ArrayList<ArrayList<Candy>> candys, Point point){
        Candy candy = null;
        
        for(int x=0; x<candys.size(); x++){
            for(int y=0; y<candys.get(x).size(); y++){
                if(Util.check.checkCandyPosition(candys.get(x).get(y), point))
                    candy = candys.get(x).get(y);
            }
        }
        
        return candy;
    }
}
