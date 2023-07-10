package pachet1.tjts.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(String path){
        try {
            sheet= ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getSprite(int x, int y){
        return sheet.getSubimage(x*128-128,y*128-128,128,128);
    }
}
