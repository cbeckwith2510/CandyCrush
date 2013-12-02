
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
    public boolean checkColumns(ArrayList<Candy> column){
        return column.size() < Configuration.NUM_ROW;
    }
    
    public boolean checkFirstPosition(ArrayList<Candy> column){
        if(column.size() > 0)
            return column.get(column.size() - 1).getPositionY() >= Configuration.CELL_SIZE_Y;
        else
            return true;            
    }
        
    //Esto comprueba que el caramelo este en la posicion seleccionada por el mouse     
    public boolean checkCandyPosition(Candy candy, Point point) {                                                        
        return ((point.x > candy.getPositionX() && point.x < (candy.getPositionX() + Configuration.CELL_SIZE_X)) && (point.y > candy.getPositionY() && point.y < (candy.getPositionY() + Configuration.CELL_SIZE_Y)))            ;        
    }
    
    //Comprueba si un caramelo se esta moviendo.
    public boolean isMoving(Candy candy){
        return candy.getPositionY() == Util.get.getPositionY(candy.getCoordinateY());
    }
}
