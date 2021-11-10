
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEMO0464
 */
public class Fonds extends Canvas {

    Image fondo; 
    
    public Fonds() {
        fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg")).getImage();
    }
    
    
    
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        this.setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(fondo, 0, 0, this);
    }
        
}
