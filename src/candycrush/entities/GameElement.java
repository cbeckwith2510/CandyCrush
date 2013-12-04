
package candycrush.entities;

/**
 *
 * @author smoranbl
 */
public class GameElement {
    protected int coordinateX;
    protected int coordinateY;
    
    public GameElement(int coordinateX, int coordinateY){                
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
    
    //Metodos GET.
    public int getCoordinateX() {
        return coordinateX;
    } 
    public int getCoordinateY() {
        return coordinateY;
    }
    
    //Metodos SET.
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }    
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }  
    public void setCoordinates(int coordinateX, int coordinateY) {
        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);
    }
}
