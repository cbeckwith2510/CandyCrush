
package candycrush.entities;

import candycrush.utils.Util;
import java.awt.Image;

/**
 *
 * @author smoranbl
 */
public class Candy extends GameElement{    
    private final EnumCandy type;
    private final Image image;
    
    private int positionX;
    private int positionY;      
    
    public Candy(int coordinateX, int coordinateY, EnumCandy type){
        super(coordinateX, coordinateY);
        
        this.positionX = Util.get.getPosition(coordinateX, true);
        this.positionY = 0;
        this.type = type;             
        this.image = Util.add.createImageIcon(type);               
    }   
    
    //Metodo que mueve el caramelo si no esta ocupadon la posicion que le corresponde para sus coordinates.
    public void moveCandyToPosition(){
        if(positionX != Util.get.getPosition(coordinateX, true)){            
            positionX = moveCandy(positionX, coordinateX, true);
        }
        else if(positionY != Util.get.getPosition(coordinateY, false)){                 
            positionY = moveCandy(positionY, coordinateY, false);
        }
    }
    
    //Metodo que mueve el caramelo hacia arriba o abajo en funcion de la posicion que ocupe.
    public int moveCandy(int position, int coordiante, boolean side){
        if(position < Util.get.getPosition(coordiante, side))
            position++;
        else if(position > Util.get.getPosition(coordiante, side))
            position--;
        
        return position;
    }
    
    //Metodos GET.
    public EnumCandy getType(){
        return type;
    }
    public Image getImage(){
        return image;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    
    //Metodos SET.
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }                            
}
