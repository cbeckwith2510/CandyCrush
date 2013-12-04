
package candycrush;

import candycrush.entities.GameTable;

/**
 *
 * @author smoranbl
 */
public class CandyCrush {
    private static boolean playing = true;
    private static GameTable game;
    
    //Metodo Update del juego, llama al metodo game del gameTable.
    public static void update(){
        game.game();
    }
    
    //Metodo Draw del juego, llama al repaint del panel.
    public static void draw(){
        game.getCandyFrame().getGamePanel().repaint();
    }        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        game = new GameTable();  
        
        while(playing){                                    
            Thread.sleep(5);
            
            update();            
            draw();            
        }
    }
    
}
