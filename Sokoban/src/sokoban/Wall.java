package sokoban;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    private final Image image;

    public Wall(int x, int y) {
        super(x, y);

       
        ImageIcon iia = new ImageIcon("/Users/jordanadkins/NetBeansProjects/Sokoban/wall.png");
        image = iia.getImage();
        this.setImage(image);

    }
}