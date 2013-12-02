
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
        
        this.positionX = Util.get.getPositionX(coordinateX);
        this.positionY = 0;
        this.type = type;             
        this.image = Util.add.createImageIcon(type);               
    }   
    
    //TODO: Modular mucho mejor.
    public void moveCandyToPosition(){
        if(positionX != Util.get.getPositionX(coordinateX)){
            if(positionX < Util.get.getPositionX(coordinateX))
                positionX++;
            else if(positionX > Util.get.getPositionX(coordinateX))
                positionX--;
        }
        else if(positionY != Util.get.getPositionY(coordinateY)){
            if(positionY < Util.get.getPositionY(coordinateY))
                positionY++;
            else if(positionY > Util.get.getPositionY(coordinateY))
                positionY--;            
        }
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
