
package candycrush.GUI;

import candycrush.entities.GameTable;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author smoranbl
 */
public class CandyFrame extends JFrame {
    private GamePanel gamePanel;
    
    public CandyFrame(GameTable table){
        gamePanel = new GamePanel(table);
        
        createAndShowGUI();
    }
    
    private void createAndShowGUI(){                
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
        this.getContentPane().setBackground(Color.GRAY);        
        this.pack();                      
        this.add(gamePanel);
        this.setSize(685, 560);
        this.setLocation(50, 50);        
        this.setVisible(true);        
    }
    
    public GamePanel getGamePanel(){
        return gamePanel;
    }
}
