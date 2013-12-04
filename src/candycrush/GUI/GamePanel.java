
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
    
    //Metodo paint del panel, llama al metodo draw candy para cada una de las columnas del gameTable.
    @Override
    public void paint(Graphics graphics){
        graphics.setColor(new Color(96,158,171));
        graphics.fillRect(0, 0, 681, 542);        
        
        for(int i=0; i<table.getCandyColumns().size(); i++)
            drawCandy(graphics, table.getCandyColumns().get(i));
    }
    
    //Metodo draw candy, recorre una columna y pinta cada caramelo de la misma en base a su positonX y positionY.
    public void drawCandy(Graphics graphics, ArrayList<Candy> candys){
        for(int i=0; i<candys.size(); i++){
            graphics.drawImage(candys.get(i).getImage(), candys.get(i).getPositionX(), candys.get(i).getPositionY(), this);
        }
    }
    
    //MouseListener con el pressed coge un caramelo, con el released coge el caramelo target y les intercambia las coordinadas.
    //TODO: intercambie posiciones en el arrayList de cada columna.
    MouseListener moveCandy = new MouseListener(){
        Candy sourceCandy = null;
        Candy targetCandy = null;
        
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {
            sourceCandy = Util.get.getCandyOnMouse(table.getCandyColumns(), e.getPoint());             
        }
        @Override        
        public void mouseReleased(MouseEvent e) {
            targetCandy = Util.get.getCandyOnMouse(table.getCandyColumns(), e.getPoint());            
            Util.set.setCoordinates(sourceCandy, targetCandy);
            Util.set.setPositionInArray(table.getCandyColumns(), sourceCandy, targetCandy);
        }
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}        
    };
}
