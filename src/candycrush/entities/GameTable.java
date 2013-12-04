
package candycrush.entities;

import candycrush.GUI.CandyFrame;
import candycrush.configuration.Configuration;
import candycrush.utils.Util;
import java.util.ArrayList;

/**
 *
 * @author smoranbl
 */
public class GameTable {       
    private final ArrayList<ArrayList<Candy>> candyColumns;    
    private final CandyFrame candyFrame;
    
    public GameTable(){         
        this.candyColumns = Util.add.createColums();        
        this.candyFrame = new CandyFrame(this);
    }    
    
    //Metodo de juego, primero rellena los array columnas si no estan llenos.
    //segundo mueve los caramelos si no ocupan su posicion correcta.
    //tercero comprueba si hay caramelos iguales y si los hay los retira.
    //TODO: Se puede modular mejor.
    public void game() {                
        for(int i=0; i<candyColumns.size(); i++) {                        
            for(int j=0; j<candyColumns.get(i).size(); j++)
                moveCandy(candyColumns.get(i).get(j));
            
            addCandy(i);                                        
        }
        
        if(Util.check.checkPanelIsFull(candyColumns)){                                               
            ArrayList<Candy> equalsCandy = Util.get.getEquals(candyColumns);
            
            if(equalsCandy.size() > 2 && Util.check.anyMoving(equalsCandy))
                Util.remove.removeEqualsCandy(candyColumns, equalsCandy);            
        }
    }
    
    //Llama al metodo de mover del caramelo si no ocupa su posicion.
    public void moveCandy(Candy candy) {                
        if(candy.getPositionY() != Util.get.getPosition(candy.getCoordinateY(), false) || candy.getPositionX() != Util.get.getPosition(candy.getCoordinateX(), true))
            candy.moveCandyToPosition();                                
    }
    
    //Añade un caramelo al array columna indicado por el columnIndex
    public void addCandy(int columnIndex) {
        if(Util.check.checkFirstPosition(candyColumns.get(columnIndex)) && Util.check.checkColumns(candyColumns.get(columnIndex))){
            Candy candy = new Candy(columnIndex, (Configuration.NUM_ROW - candyColumns.get(columnIndex).size() - 1), Util.get.getRandomEnumCandy());
            candyColumns.get(columnIndex).add(candy);                                            
        }
    }
        
    //Metodos GET.
    public ArrayList<ArrayList<Candy>> getCandyColumns() {
        return candyColumns;
    }    
    public CandyFrame getCandyFrame(){
        return candyFrame;
    }
}
