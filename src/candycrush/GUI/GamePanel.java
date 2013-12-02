
package candycrush.GUI;

import candycrush.entities.Candy;
import candycrush.entities.GameTable;
import candycrush.utils.Util;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author smoranbl
 */
public class GamePanel extends JPanel {
    CandyFrame frame;
    GameTable table;
    
    public GamePanel(GameTable table){                
        this.table = table;
        
        configureGamePanel();
    }
    
    private void configureGamePanel(){
        this.setPreferredSize(new Dimension(681, 542));
        this.addMouseListener(moveCandy);
    }            
    
    @Override
    public void paint(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 681, 542);        
        
        for(int i=0; i<table.getCandyColumns().size(); i++)
            drawCandy(graphics, table.getCandyColumns().get(i));
    }
    
    public void drawCandy(Graphics graphics, ArrayList<Candy> candys){
        for(int i=0; i<candys.size(); i++){
            graphics.drawImage(candys.get(i).getImage(), candys.get(i).getPositionX(), candys.get(i).getPositionY(), this);
        }
    }
    
    MouseListener moveCandy = new MouseListener(){
        Candy sourceCandy = null;
        Candy targetCandy = null;
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            sourceCandy = Util.get.getCandyOnMouse(table.getCandyColumns(), e.getPoint()); 
            if(Util.check.isMoving(sourceCandy))
                System.out.println(sourceCandy.getCoordinateX() + "," + sourceCandy.getCoordinateY());
        }

        @Override
        //TODO: Modular mucho mejor.
        public void mouseReleased(MouseEvent e) {
            targetCandy = Util.get.getCandyOnMouse(table.getCandyColumns(), e.getPoint());
            if(Util.check.isMoving(targetCandy)){
                int targetX = targetCandy.getCoordinateX();
                int targetY = targetCandy.getCoordinateY();
                
                targetCandy.setCoordinateX(sourceCandy.getCoordinateX());
                targetCandy.setCoordinateY(sourceCandy.getCoordinateY());
                sourceCandy.setCoordinateX(targetX);
                sourceCandy.setCoordinateY(targetY);                                 
            }                
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    };
}
