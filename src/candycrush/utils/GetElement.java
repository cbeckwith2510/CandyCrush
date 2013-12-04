
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
    //Obtiene un numero random entre 0 y el parametro size.
    public int getRandom(int size){
        Random random = new Random();        
        int number = random.nextInt(size);
        
        return number;
    }
    
    //Obtiene una EnumCandy aleatoria.
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
    
    //Obtiene la posicion que corresponde para la coordenada que se le pase, se le pasa un true si se quiere positionX o
    //un false si se quiere una posicionY.
    public int getPosition(int coordinate, boolean side){
        if(side)
            return coordinate * Configuration.CELL_SIZE_X;
        else
            return coordinate * Configuration.CELL_SIZE_Y;
    }
    
    //Obtiene el Candy que ocupa la poscion que se le pase.
    public Candy getCandyOnMouse(ArrayList<ArrayList<Candy>> candys, Point point){
        Candy candy = null;
        int indexColumn = 0, indexRow = 0;
        
        while(candy == null && indexColumn < candys.size()){
            if(Util.check.checkCandyPosition(candys.get(indexColumn).get(indexRow), point))
                candy = candys.get(indexColumn).get(indexRow);
            
            indexRow++;            
            if(indexRow == candys.get(indexColumn).size()){                                
                indexRow = 0;
                indexColumn++;
            } 
        }
        
        return candy;
    }
    
    //Obtiene un array de tres caramelos en funcion a la linea que se le pasa como parametro.
    public ArrayList<Candy> getEquals(ArrayList<ArrayList<Candy>> columns){
        ArrayList<Candy> equalsCandy = new <Candy>ArrayList();
        int rowIndex = 0, columnIndex = 0;
        
        while(equalsCandy.size() < 3 && rowIndex < columns.get(columnIndex).size()) {                        
            equalsCandy = Util.check.checkTypes(equalsCandy, columns.get(columnIndex).get(rowIndex));            
             
            columnIndex++;            
            
            if(columnIndex >= columns.size()){                                
                columnIndex = 0;
                rowIndex++;
                if(equalsCandy.size() < 3)
                    equalsCandy.clear();
            }       
        }
        
        return equalsCandy;
    }
}
