
package candycrush.utils;

import candycrush.entities.Candy;
import java.util.ArrayList;

/**
 *
 * @author smoranbl
 */
public class RemoveElement {
    // Elimina los candys en el tablero en funcion del array equalsCandy.
    public void removeEqualsCandy(ArrayList<ArrayList<Candy>> candys, ArrayList<Candy> equalsCandy) {
        for (int i=0; i<equalsCandy.size(); i++)
            candys.get(equalsCandy.get(i).getCoordinateX()).remove(equalsCandy.get(i));
        
        Util.set.setRepositionCandy(candys, equalsCandy);
    }
}
