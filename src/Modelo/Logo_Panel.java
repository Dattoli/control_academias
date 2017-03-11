package Modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Logo_Panel extends JPanel{
    private URL url = getClass().getResource("/Imagenes/login.jpg");
    Image image = new ImageIcon(url).getImage();
    
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    } 
}
