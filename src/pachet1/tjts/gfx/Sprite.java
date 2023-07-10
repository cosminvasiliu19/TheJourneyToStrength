package pachet1.tjts.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Sprite extends Image {

    public SpriteSheet sheet;
    public BufferedImage image;

    public Sprite(SpriteSheet sheet, int x, int y){
        image = sheet.getSprite(x,y);
    }
    public BufferedImage getBufferedImage(){
        return image;
    }
    @Override
    public int getWidth(ImageObserver observer) {
        return 0;
    }
    @Override
    public int getHeight(ImageObserver observer) {
        return 0;
    }
    @Override
    public ImageProducer getSource() {
        return null;
    }
    @Override
    public Graphics getGraphics() {
        return null;
    }
    @Override
    public Object getProperty(String name, ImageObserver observer) {
        return null;
    }
}
