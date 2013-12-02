
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
    
    public void game(){
        for(int i=0; i<candyColumns.size(); i++){
            for(int j=0; j<candyColumns.get(i).size(); j++){                  
                if(candyColumns.get(i).get(j).getPositionY() != Util.get.getPositionY(candyColumns.get(i).get(j).getCoordinateY()) || candyColumns.get(i).get(j).getPositionX() != Util.get.getPositionX(candyColumns.get(i).get(j).getCoordinateX()) )
                    candyColumns.get(i).get(j).moveCandyToPosition();
            }
            
            if(Util.check.checkFirstPosition(candyColumns.get(i)) && Util.check.checkColumns(candyColumns.get(i)))
                addCandy(i);
        }                
    }
    
    public void addCandy(int columnIndex) {
        Candy candy = new Candy(columnIndex, (Configuration.NUM_ROW - candyColumns.get(columnIndex).size() - 1), Util.get.getRandomEnumCandy());        
        candyColumns.get(columnIndex).add(candy);                
    }
        
    //Metodos GET.
    public ArrayList<ArrayList<Candy>> getCandyColumns() {
        return candyColumns;
    }    
    public CandyFrame getCandyFrame(){
        return candyFrame;
    }
}
