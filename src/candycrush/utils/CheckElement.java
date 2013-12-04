
package candycrush.utils;

import candycrush.configuration.Configuration;
import candycrush.entities.Candy;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author smoranbl
 */
public class CheckElement {
    //Comprueba si el array columna tiene el tamaño que le corresponde.
    public boolean checkColumns(ArrayList<Candy> column) {
        return column.size() < Configuration.NUM_ROW;
    }
    
    //Comprueba si el ultimo Candy añadido al array columna no esta ocupando la primera posicion.
    public boolean checkFirstPosition(ArrayList<Candy> column) {
        if(column.size() > 0)
            return column.get(column.size()-1).getPositionY() >= Configuration.CELL_SIZE_Y;
        else
            return true;            
    }
        
    //Comprueba que el candy que se le pasa este en la posicion seleccionada por el mouse.    
    public boolean checkCandyPosition(Candy candy, Point point) {                                                        
        return ((point.x > candy.getPositionX() && point.x < (candy.getPositionX() + Configuration.CELL_SIZE_X)) && (point.y > candy.getPositionY() && point.y < (candy.getPositionY() + Configuration.CELL_SIZE_Y)))            ;        
    }
    
    //Comprueba si un caramelo se esta moviendo verticalmente.
    public boolean isMovingDown(Candy candy) {
        return candy.getPositionY() == Util.get.getPosition(candy.getCoordinateY(), false);
    }        
    
    //Comprueba si se esta moviendo un array de candys.
    public boolean anyMoving(ArrayList<Candy> candys){
        int moving = 0, index = 0;
        
        while(moving < 1 && index < candys.size()){
            if(!(candys.get(index).getPositionY() == Util.get.getPosition(candys.get(index).getCoordinateY(), false)) || !(candys.get(index).getPositionX() == Util.get.getPosition(candys.get(index).getCoordinateX(), true)))
                moving++;
            
            index++;
        }
        
        return moving < 1;
    }
    
    //Comprueba si un caramelo es del mismo tipo a los que estan en el array de equalsCandy. 
    public ArrayList<Candy> checkTypes(ArrayList<Candy> equalsCandy, Candy nextCandy) {
        if(!equalsCandy.isEmpty()) {
            if(nextCandy.getType().equals(equalsCandy.get((equalsCandy.size() - 1)).getType()))
                equalsCandy.add(nextCandy);
            else {
                equalsCandy.clear();          
                equalsCandy.add(nextCandy);
            }
        }else
            equalsCandy.add(nextCandy);
        
        return equalsCandy;
    }
    
    //Comprueba si el panel esta completo.
    public boolean checkPanelIsFull(ArrayList<ArrayList<Candy>> candys) {
        int full = 0, index = 0;        
        
        while(full < 1 && index < Configuration.NUM_ROW) {       
            if(candys.get(index).size() != Configuration.NUM_ROW)
                full++;
        
            index++;
        } 
    
        return full < 1;
    }
}
