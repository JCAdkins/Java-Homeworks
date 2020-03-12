package sokoban;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

        
        ImageIcon iia = new ImageIcon("/Users/jordanadkins/NetBeansProjects/Sokoban/area.png");
        Image image = iia.getImage();
        this.setImage(image);
    }
}