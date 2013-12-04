
package candycrush.utils;

import candycrush.entities.Candy;
import java.util.ArrayList;

/**
 *
 * @author smoranbl
 */
public class SetElement {
    //Edita las coordenadas de dos caramelos, pasa de uno a otro y viceversa.
    public void setCoordinates(Candy sourceCandy, Candy targetCandy){
        if(Util.check.isMovingDown(targetCandy)){
            int targetX = targetCandy.getCoordinateX(), targetY = targetCandy.getCoordinateY();

            targetCandy.setCoordinates(sourceCandy.getCoordinateX(), sourceCandy.getCoordinateY());            
            sourceCandy.setCoordinates(targetX, targetY);                                      
        }
    }
    
    //Edita el array columna en el que han sido eliminados elementos.
    public void setRepositionCandy(ArrayList<ArrayList<Candy>> candys, ArrayList<Candy> equalsCandy){
        for (int i=0; i<equalsCandy.size(); i++) {
            int coordinateY = equalsCandy.get(i).getCoordinateY(), coordinateX = equalsCandy.get(i).getCoordinateX();
            int arrayPosition = candys.get(coordinateX).size() - coordinateY;
            
            while(arrayPosition < candys.get(coordinateX).size()){                                                                                                   
                Candy candy = candys.get(coordinateX).get(arrayPosition);
                candy.setCoordinateY(coordinateY);                                    
                
                arrayPosition++;
                coordinateY--;
            }
        }
    }
    
    //Edita la posicion de los candys en el array o en otro array.
    public void setPositionInArray(ArrayList<ArrayList<Candy>> candys, Candy sourceCandy, Candy targetCandy){
        int indexColumnSource = targetCandy.getCoordinateX(), indexRowSource = candys.get(indexColumnSource).indexOf(sourceCandy);
        int indexColumnTarget = sourceCandy.getCoordinateX(), indexRowTarget = candys.get(indexColumnTarget).indexOf(targetCandy);
        
        candys.get(indexColumnSource).set(indexRowSource, targetCandy);
        candys.get(indexColumnTarget).set(indexRowTarget, sourceCandy); 
    }
}
