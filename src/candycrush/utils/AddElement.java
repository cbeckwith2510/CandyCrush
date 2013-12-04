
package candycrush.utils;

import candycrush.configuration.Configuration;
import candycrush.entities.Candy;
import candycrush.entities.EnumCandy;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author smoranbl
 */
public class AddElement {
    //Devuelve la imagen correspondiente a la enum que se le pase.
    public Image createImageIcon(EnumCandy kindCandy){
        Image imageCandy = null;
        
        switch(kindCandy){
            case BLUE:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\blue.png")).getImage();
                break;
            case GREEN:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\green.png")).getImage();
                break;
            case ORANGE:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\orange.png")).getImage();
                break;
            case PURPLE:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\purple.png")).getImage();
                break;
            case RED:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\red.png")).getImage();
                break;
            case YELLOW:
                imageCandy = new ImageIcon(getClass().getResource("..\\GUI\\image\\yellow.png")).getImage();
                break;
        }
                
        return imageCandy;
    }
    
    //Devuelve un array de columnas de array Candy.
    public ArrayList<ArrayList<Candy>> createColums(){
        ArrayList<ArrayList<Candy>> columnArray = new <ArrayList<Candy>>ArrayList();        
        
        for(int x=0; x<Configuration.NUM_COLUMN; x++)                     
            columnArray.add(new <Candy>ArrayList());            
                
        return columnArray;
    }        
}
